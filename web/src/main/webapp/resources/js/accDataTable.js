var refDataTable;


var ajaxUrl = "http://localhost:8080/TestOstd/rest/acc/";
    ajaxUrl = "rest/acc/";

var form = $('#detailsForm');
var failedNote;

var isStandalone = false;
var sDeleteBtn = "Delete";
var sEditBtn   = "Edit";


function makeEditable() {


    $('#addRow').click(function () {
        document.getElementById("iban").disabled = false;
        form.find("input").val("");
    });

    form.submit(function () {
        save();
        if( getStandalone()){
        }
        return false;
    });

    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(event, jqXHR, options, jsExc);
    });
}

function findByIBAN( iban){
    var data = refDataTable.data();
    for( var i = 0; i < data.length; i++){
        if( data[ i][0] == iban){
            return i;
        }
    }
    return -1;
}                       



function updateTable() {
    if( !getStandalone()){
        console.log( "updateTable.web");
    }
    else {
        $.ajax({
            type: "GET",
            url: ajaxUrl,
            success: function (data) {
                console.log( "updateTable.ajax.GET");
                updateTableByData(data);
            }
        });
    }
    return false;
}


function getStandalone(){
    return isStandalone;
}

function setStandalone(){
    isStandalone =  document.getElementById("standalone").value == "true";
    console.log( "standalone=" + isStandalone);
}


function updateRow(id) {

    if( !getStandalone()){
        var n = findByIBAN( id);
        if( n > -1){
            var data = refDataTable.data();
            form.find("input[name='iban']").val( data[ n][ 0]);
            form.find("input[name='bic']" ).val( data[ n][ 1]);
            document.getElementById("iban").disabled = true;
            $('#editRow').modal();

            console.log( "updateRow.web");
        }
    }
    else {
        $.get(ajaxUrl + id, function (data) {
            $.each(data, function (key, value) {
                form.find("input[name='" + key + "']").val(value);
                console.log( "updateRow.ajax");
            });
            document.getElementById("iban").disabled = true;
            $('#editRow').modal();
            console.log( "updateRow.ajax");

        });
    }

}

function getModifiedList() {
    var modifiedList = sessionStorage.getItem("modifiedList");
    if( modifiedList == null){ modifiedList = [];}
    else{
        modifiedList = JSON.parse( modifiedList);
    }
    return modifiedList;
}

function updateModifiedList( p_action, p_iban, p_bic){
    var m = getModifiedList();
    var o = {action : p_action,
             iban   : p_iban,
             bic    : p_bic};
    m[m.length] = o;
    sessionStorage.setItem( "modifiedList", JSON.stringify(m));
}

function deleteRow(id) {
   if( !getStandalone()){
        var n = findByIBAN( id);
        if( n > -1){
          var data = refDataTable.data();
          updateModifiedList( "DELETE", data[n][0], data[n][1]);

          data.splice( n, 1);
          refDataTable.clear();
          for (var i = 0; i < data.length; i++) {
             refDataTable.row.add( [ data[i][0], data[i][1], data[i][2], data[i][3] ]);
          }
          refDataTable.draw();         
          successNoty('Deleted');
          console.log( "deleteRow.web");
        }
    }
    else {
        $.ajax({
            url: ajaxUrl + id,
            type: 'DELETE',
            success: function () {
                updateTable();
                console.log( "deleteRow.ajax");
                successNoty('Deleted');
            }
        });
    }

}




function updateTableByData(data) {
    refDataTable.clear();
    for (var i = 0; i < data.length; i++) {
        refDataTable.row.add( [ data[i].iban, data[i].bic, sDeleteBtn, sEditBtn ]);
    }
    refDataTable.draw();
}

function updateTableRowByData( n, iban, bic){
    if( n > -1){
        refDataTable.cell(n, 0).data( iban);
        refDataTable.cell(n, 1).data( bic);
    } else {
        refDataTable.row.add( [ iban, bic, sDeleteBtn, sEditBtn]);
    }

}

function save() {
    var newBIC  = form.find("input[name='bic']").val();
    var newIBAN = form.find("input[name='iban']").val();
    if( newBIC == "" || newIBAN == ""){
        mfailNoty( "Fill the form correctly!");
        return;
    }
    if( !getStandalone()){
        var n = findByIBAN( newIBAN);
        updateTableRowByData( n, newIBAN, newBIC);
        updateModifiedList( "UPDATE", newIBAN, newBIC);

        $('#editRow').modal('hide');

        updateTable();
        refDataTable.rows().invalidate();            
        refDataTable.draw();
        successNoty('Saved');
        console.log( "save.web");
    }
    else {
        document.getElementById("iban").disabled = false;
        $.ajax({
            type: "POST",
            url: ajaxUrl,
            data: form.serialize(),
            success: function () {
                $('#editRow').modal('hide');

                updateTable();
                successNoty('Saved');
                console.log( "save.standalone");
            }
        });
    }

}

function sendList(){

    var data = refDataTable.data();
    var list = [];
    for( var i = 0; i < data.length; i ++){
        list[i] = {}
        list[i]["iban"] = data[ i][0];
        list[i]["bic"]  = data[ i][1];
    }

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "TestOstd/" + ajaxUrl + "list",
        data : JSON.stringify(list),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log( "send list.web");
            successNoty('Sended');
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            successNoty('Done');
        }
    });


}


function renderEditBtn(data, type, row) {
    if (type == 'display') {
        var iban = row[0];
        return '<a class="btn btn-xs btn-primary" onclick="updateRow(\'' + iban + '\');">Edit</a>';
    }
    return data;
}

function renderDeleteBtn(data, type, row) {
    if (type == 'display') {
        var iban = row[0];
        return '<a class="btn btn-xs btn-danger" onclick="deleteRow(\'' + iban +'\');">Delete</a>';
    }
    return data;
}

function storageAvailable(type) {
    try {
        var storage = window[type],
            x = '__storage_test__';
        storage.setItem(x, x);
        storage.removeItem(x);
        return true;
    }
    catch(e) {
        return false;
    }
}

$(document).ready(function() {

    if( !storageAvailable('sessionStorage')){
        console.log( "Storage NOT availiable !!!");
    }
    setStandalone();


    if( isStandalone){
        console.log( "Standalone");
        $('#sendList').addClass('disabled');
    }
        else {
            console.log( "NOT a Standalone");
    }

    refDataTable = $('#datatable').DataTable(
        {
            stateSave: true,
            stateDuration: 60 * 60 * 24,
            "columns": [
                {
                    "searchable": true,
                    "orderable": true
                },
                {
                    "searchable": true,
                    "orderable": true  },
                {   "searchable": false,
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderDeleteBtn
                },
                {
                    "searchable": false,
                    "orderable": false,
                    "defaultContent": "",
                    "render": renderEditBtn
                }
            ],
            "initComplete": function(settings, json) {
                makeEditable();
            }
        }
    );

    <!-- storage -->
    var modifiedList = getModifiedList();
    if( modifiedList == null){
        alert( "Modified list is null")
    } else {
      console.log( "found modified");
      var data = refDataTable.data();
      var newData = [];
      for( var i = 0; i < data.length; i++){
          newData[ newData.length] = [ data[i][0], data[i][1] ];
      }

      refDataTable.clear();
      for( var i = 0; i < modifiedList.length; i++){
          var obj = modifiedList[i];
          var found = false;
          console.log( obj.action + "-" + obj.iban + "-" + obj.bic);
          for( var j = 0; j < newData.length; j++){
              if( obj.iban == newData[j][0]){
                  if( obj.action == "DELETE"){
                      newData.splice( j, 1);
                      console.log( "deleted iban=" + obj.iban);
                  } else {
                      newData[ j][1] = obj.bic;
                      console.log( "updated iban=" + obj.iban + ",bic = " + obj.bic);
                  }
                  found = true;
                  break;
              }
          }
          if( !found){
              if( obj.action != "DELETE") {
                  found = false;
                  for( var k = 0; k < newData.length; k++){
                      if( newData[k][0] == obj.iban){
                          found = true;
                          break;
                      }
                  }
                  if( !found) {
                      newData[ newData.length] = [obj.iban, obj.bic];
                      console.log("inserted iban=" + obj.iban + ",bic = " + obj.bic);
                  }
              }
          }
      }
      for (var i = 0; i < newData.length; i++) {
          refDataTable.row.add( [ newData[i][0], newData[i][1], sDeleteBtn, sEditBtn]);
      }
      refDataTable.rows().invalidate();
      refDataTable.draw();

    }

});



<!-- Noty -->
function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(text) {
    closeNoty();
    noty({
        text: text,
        type: 'success',
        layout: 'bottomRight',
        timeout: true
    });
}

function failNoty(event, jqXHR, options, jsExc) {
    closeNoty();
    var errorInfo = $.parseJSON(jqXHR.responseText);
    failedNote = noty({
        text: 'Failed: ' + jqXHR.statusText + "<br>" + errorInfo.cause + "<br>" + errorInfo.detail,
        type: 'error',
        layout: 'bottomRight'
    });
}


function mfailNoty( message) {
    closeNoty();
    failedNote = noty({
        text: 'Failed: ' + message,
        type: 'error',
        layout: 'bottomRight'
    });
}


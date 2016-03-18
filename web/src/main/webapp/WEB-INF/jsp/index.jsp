<%@ page import="java.util.List" %>
<%@ page import="org.springframework.data.domain.Page" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>

<%@ page session="false" %>
<%@ page language="java" session="false"%>


<html>
<head>

	<title>Test OSTD Application</title>

	<!-- dataTable -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.11/css/jquery.dataTables.min.css">

	<!-- Noty -->
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.4.0/animate.min.css">

</head>
<body>

<c:set var="st" scope="application" value="${standalone}"/>


<div class="navbar navbar-inverse navbar-static-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
				<span class="sr-only">Открыть навигацию</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand navbar-right" href="http://www.github.com/sonepotam">GitHub</a>
		</div>

	</div>
</div>

<h2>OSTD REST Application</h2>
<hr>

<div class="jumbotron">
	<div class="container">
		<div class="shadow">

			<div class="view-box">
				<div class="container">
					<div class="row">
						<div class="btn-group">
							<p>
								<a id="addRow"   class="btn btn-success" data-toggle="modal" data-target="#editRow">Add account</a>
								<a id="sendList" class="btn btn-success" onclick="sendList()" href="#" >Send List</a>
								<input type="hidden" id="standalone" value="${standalone}" >
							</p>
						</div>
					</div>
				</div>
				<p/>
				<table class="table table-striped display" id="datatable">
					<thead>
					<tr>
						<th>IBAN</th>
						<th>BIC</th>
						<th><th/>
						<th><th/>
					</tr>
					</thead>
					<tbody>

					<c:forEach items="${accounts}" var="acc">
						<jsp:useBean id="acc" scope="page" type="ru.pavel2107.ostd.model.Account"/>
						<tr>
							<td>${acc.iban}</td>
							<td>${acc.bic}</td>
							<td>Delete</td>
							<td>Edit</td>
						</tr>
					</c:forEach>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>

<!-- окно для ввода счета. хоть немного оживим эту пустыню...-->
<div class="modal fade" id="editRow">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h2 class="modal-title">Edit Account</h2>
			</div>
			<div class="modal-body">
				<form:form class="form-horizontal" method="post" id="detailsForm">
					<div class="form-group">
						<label for="iban" class="control-label col-xs-3">IBAN</label>
						<div class="col-xs-9">
							<input class="form-control" id="iban" name="iban" placeholder="IBAN">
						</div>
					</div>

					<div class="form-group">
						<label for="bic" class="control-label col-xs-3">BIC</label>

						<div class="col-xs-9">
							<input class="form-control" id="bic" name="bic" placeholder="Business Identifier Code">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-offset-3 col-xs-9">
							<button type="submit" class="btn btn-primary">Save</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</div>



<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>


<!-- Bootstrap -->
<!--
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"/>
-->
	<!--
			integrity="sha256-KXn5puMvxCw+dAYznun+drMdG1IFl3agK0p/pqT9KAo= sha512-2e8qq0ETcfWRI4HJBzQiA3UoyFk6tbNyG+qSaIBZLyW9Xf3sWZHN/lxe9fTh1U45DpPf07yj94KsUHHWe4Yk1A==" crossorigin="anonymous"></script>
     -->

<!-- DataTable -->
<script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>

<!-- Noty -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-noty/2.3.7/packaged/jquery.noty.packaged.min.js"></script>

<!-- TestOstd -->
<script src="<c:url value="/resources/js/accDataTable.js" />"></script>



</body>



</html>

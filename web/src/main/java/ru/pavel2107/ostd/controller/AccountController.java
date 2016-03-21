package ru.pavel2107.ostd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ru.pavel2107.ostd.jms.SimpleMessageProducer;
import ru.pavel2107.ostd.model.Account;
import ru.pavel2107.ostd.service.AccountService;
import ru.pavel2107.ostd.utils.*;
import ru.pavel2107.ostd.dto.AccountTo;

import javax.jms.JMSException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.lang.annotation.*;
import java.util.List;

/**
 * Created by lenovo on 09.12.2015.
 */

//
// CRUD-контроллер для пользователя
// без аутентификации можно только зарегистрироваться

@Controller
@RequestMapping( "/rest/acc")
public class AccountController{
    LoggerWrapper LOG = LoggerWrapper.get( AccountController.class);

    @Autowired
    AccountService service;

    @Autowired
    ConfigurableApplicationContext context;

    @Autowired
    SimpleMessageProducer simpleMessageProducer;


    private void sendMessage(final AccountTo[] list){
        try {
            simpleMessageProducer.sendMessage( list);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping( method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Account> getAll() {
        LOG.info( "AccountController.get all users");
        return service.findAll();
    }

    @RequestMapping(value = "/{iban}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Account get( @PathVariable("iban") String iban) {
        LOG.info( "AccountController.searching id " + iban);
        Account account = service.get( iban);
        return account;
    }

    @RequestMapping(value = "/{iban}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable("iban") String iban) {
        LOG.info("AccountController.delete id =" + iban);
        Account account = service.get( iban);
        service.delete( account);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)//, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void updateOrCreate(@Valid AccountTo account, BindingResult result, SessionStatus status) {
        LOG.info( "AccountController.create account: " + account);
        if (result.hasErrors()) {
            throw new ValidationException(String.valueOf(result));
        }
        status.setComplete();
        Account acc = new Account( account.getIban(),account.getBic());

        service.save( acc);
    }


    @RequestMapping(value="/list", method = RequestMethod.POST)
    @ResponseBody
    public void getList(@RequestBody AccountTo[] accList) {
        LOG.info( "AccountController. account list received: " + accList);
        sendMessage( accList);
    }
}

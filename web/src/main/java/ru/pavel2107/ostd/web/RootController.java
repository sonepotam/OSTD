package ru.pavel2107.ostd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.pavel2107.ostd.controller.AccountController;
import ru.pavel2107.ostd.model.Account;
import ru.pavel2107.ostd.utils.LoggerWrapper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;

/**
 * Created by lenovo on 12.12.2015.
 */
@Controller
public class RootController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(RootController.class);

    @Autowired
    AccountController controller;


    @RequestMapping( value = "/", method = RequestMethod.GET)
    public String root( Map<String, Object> map)
    {
        List<Account> list = controller.getAll();
        map.put( "accounts", list);
        map.put( "standalone", Application.isStandalone());

        return "index";
    }


}

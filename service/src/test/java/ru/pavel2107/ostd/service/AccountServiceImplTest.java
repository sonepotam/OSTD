package ru.pavel2107.ostd.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.ostd.dto.AccountTo;
import ru.pavel2107.ostd.model.Account;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 14.03.2016.
 */

public class AccountServiceImplTest {



    @Test
    public void testSave() throws Exception {
        try( ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "classpath:spring/spring-db.xml",
                "spring/spring-srv.xml")){
            AccountService service = (AccountService )appCtx.getBean( "AccountService");
            Account account = service.get("11111111111111");
            account.setBic( "AAA");
            account = service.save( account);
            System.out.println( account);
            assertTrue( "cannot delete account ", "AAA".equals( account.getBic()));
        }

    }

    @Test
    public void testDelete() throws Exception {
        try( ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "classpath:spring/spring-db.xml",
                "spring/spring-srv.xml")){
            AccountService service = (AccountService )appCtx.getBean( "AccountService");
            Account account = service.get("33333333333333");
            int oldSize = service.findAll().size();
            service.delete( account);
            int newSize = service.findAll().size();
            assertTrue( "cannot delete account ", oldSize != newSize);
        }
    }

    @Test
    public void testGet() throws Exception {
        try( ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "classpath:spring/spring-db.xml",
                "spring/spring-srv.xml")){
            AccountService service = (AccountService )appCtx.getBean( "AccountService");
            Account account = service.get("11111111111111");

            System.out.println( account);
            assertTrue( "cannot get account ", account != null);
        }
    }

    @Test
    public void testFindAll() throws Exception {
        //
        // Just for fun I can get context from xml-file for example
        //
        try( ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "classpath:spring/spring-db.xml",
                "spring/spring-srv.xml")){
            //
            // scanning for beans. This is simple but interesting
            //
            for( String bean: appCtx.getBeanDefinitionNames()){
                System.out.println( bean);
            }
          AccountService service = (AccountService )appCtx.getBean( "AccountService");
            List<Account> list = service.findAll();

            System.out.println( list);
            assertTrue( "cannot get account list", list != null);
            assertTrue( "wrong length account list", list.size() > 0);
       }
    }
}
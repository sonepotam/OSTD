package ru.pavel2107.ostd.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.pavel2107.ostd.model.Account;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by admin on 24.02.2016.
 */

@Configuration
public class AccountServiceImplTest {
    private static ConfigurableApplicationContext appCtx;
    private static AccountService service;


    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml");
        service = appCtx.getBean(AccountService.class);
        Account account = new Account("AAAAAAAAAAAAA", "BBBBBBBBBBBBBBB");  // зато прекрасно видно
        service.delete( account);
    }


    @AfterClass
    public static void afterClass() {
        appCtx.close();
    }


    @Test
    public void testSave() throws Exception {
        int beforeLen = service.findAll().size();
        Account account = new Account("AAAAAAAAAAAAA", "BBBBBBBBBBBBBBB");  // зато прекрасно видно
        service.save( account);
        account = service.get( "AAAAAAAAAAAAA");
        System.out.println( account);
        assertNotNull("Сохранить не удалось", account);
    }

    @Test
    public void testDelete() throws Exception {
        int beforeLen = service.findAll().size();
        Account account = new Account("AAAAAAAAAAAAA", "BBBBBBBBBBBBBBB");  // зато прекрасно видно
        service.delete( account);
        int afterLen = service.findAll().size();
        assertTrue( "Удалить не удалось", beforeLen != afterLen);

    }

    @Test
    public void testGet() throws Exception {
        List<Account> list = service.findAll();
        System.out.println( "before saving" + list);
        Account account = new Account("AAAAAAAAAAAAA", "BBBBBBBBBBBBBBB");  // зато прекрасно видно
        service.save( account);
        account = service.get( account.getIban());
        assertTrue( "Получить не удалось", account != null);


    }

    @Test
    public void testFindAll() throws Exception {
        List<Account> list = service.findAll();
        System.out.println( list);

    }
}
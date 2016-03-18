package ru.pavel2107.ostd.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by admin on 14.03.2016.
 */
public class AccountTest {

    @Test
    public void testGetIban() throws Exception {
        Account account = new Account( "1", "2");
        assertTrue( "wrong iban", "1".equals( account.getIban()));
    }

    @Test
    public void testSetIban() throws Exception {
        Account account = new Account();
        account.setIban( "1");
        assertTrue( "wrong iban", "1".equals( account.getIban()));
    }

    @Test
    public void testGetBic() throws Exception {
        Account account = new Account( "1", "2");
        assertTrue( "wrong bic", "2".equals( account.getBic()));
    }

    @Test
    public void testSetBic() throws Exception {
        Account account = new Account();
        account.setBic( "2");
        assertTrue( "wrong bic", "2".equals( account.getBic()));

    }

    @Test
    public void testEquals() throws Exception {
        Account account1 = new Account( "1", "2");
        Account account2 = new Account( "1", "2");
        assertTrue( "error in equals", account1.equals( account2));
        assertTrue( "error in equals", account2.equals( account1));

    }

    @Test
    public void testHashCode() throws Exception {
        Account account1 = new Account( "1", "2");
        Account account2 = new Account( "1", "2");
        assertTrue( "error in hashcode", account1.hashCode() == account2.hashCode());

    }

    @Test
    public void testToString() throws Exception {
        Account account1 = new Account( "1", "2");
        System.out.println( account1);
    }
}
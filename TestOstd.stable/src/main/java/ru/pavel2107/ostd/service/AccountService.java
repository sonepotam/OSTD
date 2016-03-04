package ru.pavel2107.ostd.service;

import ru.pavel2107.ostd.model.Account;

import java.util.List;

/**
 * Created by admin on 21.02.2016.
 */
public interface AccountService {
    Account save( Account account);
    void delete( Account account);
    Account get( String iban);
    List<Account> findAll();
}

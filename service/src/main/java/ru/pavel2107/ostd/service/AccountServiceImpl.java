package ru.pavel2107.ostd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pavel2107.ostd.model.Account;
import ru.pavel2107.ostd.repository.AccountRepository;
import ru.pavel2107.ostd.utils.LoggerWrapper;

import java.util.List;

/**
 * Created by admin on 21.02.2016.
 */
@Service( "AccountService")
@Transactional( readOnly = true)
public class AccountServiceImpl implements AccountService {
    LoggerWrapper LOG = LoggerWrapper.get( AccountService.class);

    @Autowired
    AccountRepository repository;

    @Override
    @Transactional
    public Account save(Account account) {
        LOG.info( "AccountService.save " + account);
        account = repository.save( account);
        return account;
    }

    @Override
    @Transactional
    public void delete(Account account) {
        LOG.info( "AccountService.delete " + account);
        repository.delete( account);
    }

    @Override
    public Account get(String iban) {
        LOG.info( "AccountService.get " + iban);
        Account account = repository.findOne( iban);
        return account;
    }

    @Override
    public List<Account> findAll() {
        LOG.info( "AccountService.findAll");
        return (List<Account>)repository.findAll();
    }
}

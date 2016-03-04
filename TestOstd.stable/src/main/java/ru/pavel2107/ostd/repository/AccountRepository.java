package ru.pavel2107.ostd.repository;

import ru.pavel2107.ostd.model.Account;

/**
 * Created by admin on 21.02.2016.
 */
public interface AccountRepository extends AccountJpaRepository {

    Account findByBic( String bic);
}

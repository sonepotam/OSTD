package ru.pavel2107.ostd.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pavel2107.ostd.model.Account;

/**
 * Created by admin on 21.02.2016.
 */
public interface AccountJpaRepository  extends CrudRepository<Account, String> {
}

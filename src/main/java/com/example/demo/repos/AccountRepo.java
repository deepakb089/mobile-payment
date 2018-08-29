package com.example.demo.repos;

import com.example.demo.entities.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
    Account findByUserId(long userId);
}

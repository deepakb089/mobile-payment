package com.example.demo.repos;

import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    boolean existsByPhone(String phone);
    List<User> findAll();
    User findByPhone(String phone);
}

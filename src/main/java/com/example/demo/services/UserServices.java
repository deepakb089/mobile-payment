package com.example.demo.services;

import com.example.demo.repos.UserRepo;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServices {

    @Autowired
    UserRepo repo;

    @Autowired
    AccountService accountService;

    public UserServices() {

    }

    public boolean isExists(User user) {
        if (repo.existsByPhone(user.getPhone())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasAccount(String phone) {
        if (repo.existsByPhone(phone)) {
            return true;
        } else {
            return false;
        }
    }

    public void save(User u) {
        repo.save(u);
        accountService.create(u);
    }

    public List<User> all() {
        return repo.findAll();
    }

    public Optional<User> find(long id) {
        return repo.findById(id);
    }

    public User findByPhone(String phone) {
        return repo.findByPhone(phone);
    }


}

package com.example.demo.controllers;

import com.example.demo.exceptions.TestException;
import com.example.demo.services.CacheService;
import com.example.demo.services.UserServices;
import com.example.demo.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.User;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class Test {

    @Autowired
    UserServices userServices;

    @Autowired
    CacheService cacheService;


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> create(@Valid @RequestBody User user) {
        if (userServices.isExists(user)) {
            return new ResponseEntity(new CustomErrorType("User already exists"), HttpStatus.CONFLICT);
        } else {
            userServices.save(user);
            return new ResponseEntity(new CustomErrorType("Saved."), HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userServices.all();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("id") long id) {
        Optional<User> user = userServices.find(id);
        if (user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        } else {
            return new ResponseEntity(new CustomErrorType("User not found"),
                    HttpStatus.CONFLICT);
        }

    }

    @RequestMapping(value = "/cache", method = RequestMethod.GET)
    public String getCache() {
        return cacheService.getName();
    }


    @RequestMapping(value = "/exp", method = RequestMethod.GET)
    public String expTest() throws TestException {
        throw new TestException("This is exception");
        //return "Hello, World!";
    }

    @ExceptionHandler(TestException.class)
    String handleTestException(TestException e) {
        return e.getMessage();
    }

}


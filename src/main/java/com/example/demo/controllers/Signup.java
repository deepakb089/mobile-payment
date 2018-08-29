package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.exceptions.UserAlreadyExists;
import com.example.demo.responses.*;
import com.example.demo.responses.Error;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Signup {

    @Autowired
    UserServices userServices;


    @RequestMapping("/register")
    public ResponseEntity<Response> signup(@Valid @RequestBody User user) throws UserAlreadyExists {
        if (userServices.isExists(user)) {
            throw new UserAlreadyExists();
        } else {
            userServices.save(user);
        }
        return new ResponseEntity<>(new Success(), HttpStatus.OK);
    }

    @ExceptionHandler({UserAlreadyExists.class,MethodArgumentNotValidException.class})
    public ResponseEntity<Response> handleMethodArgumentNotValidException(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            return new ResponseEntity<>(new RequestMalformed(), HttpStatus.BAD_REQUEST);
        } else if (e instanceof UserAlreadyExists) {
            return new ResponseEntity<>(new UserAlreadyExistsError(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Error(), HttpStatus.BAD_REQUEST);

    }


}

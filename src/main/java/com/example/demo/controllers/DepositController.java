package com.example.demo.controllers;

import com.example.demo.entities.Deposit;
import com.example.demo.exceptions.UserNotExistsException;
import com.example.demo.responses.RequestMalformedError;
import com.example.demo.responses.Response;
import com.example.demo.responses.Success;
import com.example.demo.responses.UserNotExistsError;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DepositController {

    @Autowired
    UserServices userServices;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public ResponseEntity<Response> deposit(@Valid @RequestBody Deposit deposit) throws UserNotExistsException {
        if(!userServices.hasAccount(deposit.getPhone())) {
            throw new UserNotExistsException();
        } else {
            accountService.deposit(deposit);
            return new ResponseEntity<>(new Success(), HttpStatus.OK);
        }
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new RequestMalformedError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<Response> handleUserNotExistsException(UserNotExistsException e) {
        return new ResponseEntity<>(new UserNotExistsError(), HttpStatus.BAD_REQUEST);
    }

}

package com.example.demo.controllers;

import com.example.demo.entities.Transfer;
import com.example.demo.exceptions.NotEnoughBalance;
import com.example.demo.exceptions.UserNotExistsException;
import com.example.demo.responses.*;
import com.example.demo.services.AccountService;
import com.example.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TransferController {


    @Autowired
    UserServices userServices;

    @Autowired
    AccountService accountService;


    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<Response> transfer(@Valid @RequestBody Transfer transfer) throws UserNotExistsException, NotEnoughBalance {

        if (!userServices.hasAccount(transfer.getFromPhone()) ||
                !userServices.hasAccount(transfer.getToPhone())) {
            throw new UserNotExistsException();
        } else if (!accountService.isPositive(transfer)) {
            throw new NotEnoughBalance();
        }

        accountService.transfer(transfer);
        return new ResponseEntity<>(new Success(), HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new RequestMalformed(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<Response> handleUserNotExistsException(UserNotExistsException e) {
        return new ResponseEntity<>(new UserNotExistsError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotEnoughBalance.class)
    public ResponseEntity<Response> handleNotEnoughBalance(NotEnoughBalance e) {
        return new ResponseEntity<>(new NotEnoughBalanceError(), HttpStatus.BAD_REQUEST);
    }

}

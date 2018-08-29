package com.example.demo.exceptions;

public class UserNotExistsException extends Exception {
    public UserNotExistsException() {
        super("User not exists");
    }
}

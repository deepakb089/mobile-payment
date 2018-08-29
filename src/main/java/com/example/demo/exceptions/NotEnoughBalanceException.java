package com.example.demo.exceptions;

public class NotEnoughBalanceException extends Exception {
    public NotEnoughBalanceException() {
        super("Not enough balance.");
    }
}

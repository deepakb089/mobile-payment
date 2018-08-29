package com.example.demo.exceptions;

public class NotEnoughBalance extends Exception {
    public NotEnoughBalance() {
        super("Not enough balance.");
    }
}

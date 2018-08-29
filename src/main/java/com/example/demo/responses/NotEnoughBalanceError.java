package com.example.demo.responses;

public class NotEnoughBalanceError implements Response {

    public String status;
    public String message;

    public NotEnoughBalanceError() {
        this.status = "error";
        this.message = "Not enough balance";

    }
}

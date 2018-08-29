package com.example.demo.responses;

public class UserNotExistsError implements Response {

    public String status;
    public String message;

    public UserNotExistsError() {
        this.status = "error";
        this.message = "User does not exists.";
    }

}

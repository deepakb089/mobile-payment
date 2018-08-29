package com.example.demo.responses;



public class UserAlreadyExistsError implements Response {

    public String status;
    public String message;

    public UserAlreadyExistsError() {

        this.status = "error";
        this.message = "User already exists";

    }


}

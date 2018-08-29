package com.example.demo.responses;

public class Error implements Response {

    String status;

    public Error(){
       this.status = "error";
    }

}

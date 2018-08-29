package com.example.demo.responses;

public class RequestMalformed implements Response {

    public String status;
    public String message;

    public RequestMalformed() {

        this.status = "error";
        this.message = "Request malformed";

    }

}

package com.example.demo.responses;

public class RequestMalformedError implements Response {

    public String status;
    public String message;

    public RequestMalformedError() {

        this.status = "error";
        this.message = "Request malformed";

    }

}

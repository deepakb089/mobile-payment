package com.example.demo.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    private String name;
    public NameService(){
        this.name = "Deepak Balani";
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

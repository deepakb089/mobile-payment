package com.example.demo.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


public class Deposit {

    @NotNull
    private String phone;

    @NotNull
    private double amount;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}

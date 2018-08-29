package com.example.demo.entities;


import javax.validation.constraints.NotNull;

public class Transfer {


    @NotNull
    private String fromPhone;

    public String getFromPhone() {
        return fromPhone;
    }

    public void setFromPhone(String fromPhone) {
        this.fromPhone = fromPhone;
    }

    public String getToPhone() {
        return toPhone;
    }

    public void setToPhone(String toPhone) {
        this.toPhone = toPhone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @NotNull
    private  String toPhone;

    @NotNull
    private double amount;


}

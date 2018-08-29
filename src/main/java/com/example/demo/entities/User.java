package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
//    private String username;
//
//    @NotNull
//    private String firstName;
//
//    @NotNull
//    private String lastName;

//    @NotNull
//    private String email;

    @NotNull
    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    private String name;


    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

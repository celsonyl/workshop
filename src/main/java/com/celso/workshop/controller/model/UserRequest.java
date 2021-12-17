package com.celso.workshop.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class UserRequest implements Serializable {

    private String name;
    private String email;

    public UserRequest() {
    }

    public UserRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.celso.workshop.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class UserRequest implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserRequest() {
    }

    public UserRequest(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

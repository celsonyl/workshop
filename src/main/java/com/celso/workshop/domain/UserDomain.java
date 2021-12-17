package com.celso.workshop.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
public class UserDomain implements Serializable {

    private String id;
    private String name;
    private String email;
    private List<?> posts = new ArrayList<>();

    public UserDomain() {
    }

    public UserDomain(String id, String name, String email, List<?> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.posts = posts;
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

    public List<?> getPosts() {
        return posts;
    }

    public void setPosts(List<?> posts) {
        this.posts = posts;
    }
}
package com.celso.workshop.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class PostRequest implements Serializable {

    private String id;
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private Date date;
    private String title;
    private String body;

    private UserRequest userRequest;

    public PostRequest() {
    }

    public PostRequest(String id, Date date, String title, String body, UserRequest userRequest) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.userRequest = userRequest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }
}
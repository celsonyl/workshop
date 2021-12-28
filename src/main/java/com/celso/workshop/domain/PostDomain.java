package com.celso.workshop.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class PostDomain implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;

    private UserDomain userDomain;

    public PostDomain(){}

    public PostDomain(String id, Date date, String title, String body, UserDomain userDomain) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.userDomain = userDomain;
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

    public UserDomain getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(UserDomain userDomain) {
        this.userDomain = userDomain;
    }
}
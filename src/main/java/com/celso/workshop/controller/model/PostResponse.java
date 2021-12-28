package com.celso.workshop.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.io.Serializable;
import java.util.Date;

@Builder
public class PostResponse implements Serializable {

    private String id;
    private String title;
    private String body;

    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-3")
    private Date date;

    private String author;

    public PostResponse(){}

    public PostResponse(String id, String title, String body, Date date, String author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = date;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
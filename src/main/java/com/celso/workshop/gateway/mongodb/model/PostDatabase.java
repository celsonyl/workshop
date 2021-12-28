package com.celso.workshop.gateway.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class PostDatabase implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private UserDatabase userDatabase;


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

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public void setUserDatabase(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDatabase that = (PostDatabase) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(userDatabase, that.userDatabase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, title, body, userDatabase);
    }
}

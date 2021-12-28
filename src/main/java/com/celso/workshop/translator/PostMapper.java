package com.celso.workshop.translator;

import com.celso.workshop.controller.model.PostRequest;
import com.celso.workshop.controller.model.PostResponse;
import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.mongodb.model.PostDatabase;
import com.celso.workshop.gateway.mongodb.model.UserDatabase;

public class PostMapper {

    public PostDomain postDatabaseToDomain(PostDatabase postDatabase) {

        var userDomain = UserDomain.builder()
                .id(postDatabase.getUserDatabase().getId())
                .email(postDatabase.getUserDatabase().getEmail())
                .name(postDatabase.getUserDatabase().getName())
                .build();

        return PostDomain.builder()
                .id(postDatabase.getId())
                .body(postDatabase.getBody())
                .date(postDatabase.getDate())
                .title(postDatabase.getTitle())
                .userDomain(userDomain)
                .build();
    }

    public PostDatabase postDomainToDatabase(PostDomain postDomain) {

        var userDatabase = UserDatabase.builder()
                .id(postDomain.getUserDomain().getId())
                .email(postDomain.getUserDomain().getEmail())
                .name(postDomain.getUserDomain().getName())
                .build();

        return PostDatabase.builder()
                .id(postDomain.getId())
                .body(postDomain.getBody())
                .date(postDomain.getDate())
                .title(postDomain.getTitle())
                .userDatabase(userDatabase)
                .build();
    }

    public PostResponse postDomainToResponse(PostDomain postDomain) {
        return PostResponse.builder()
                .id(postDomain.getId())
                .body(postDomain.getBody())
                .date(postDomain.getDate())
                .title(postDomain.getTitle())
                .author(postDomain.getUserDomain().getName())
                .build();
    }

    public PostDomain postRequestToDomain(PostRequest postRequest) {
        var userDomain = UserDomain.builder()
                .id(postRequest.getUserRequest().getId())
                .build();

        return PostDomain.builder()
                .body(postRequest.getBody())
                .date(postRequest.getDate())
                .title(postRequest.getTitle())
                .userDomain(userDomain)
                .build();
    }
}

package com.celso.workshop.controller;

import com.celso.workshop.controller.model.UserRequest;
import com.celso.workshop.translator.UserMapperImpl;
import com.celso.workshop.usecase.CreateUserUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private CreateUserUsecase createUserUsecase;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriComponentsBuilder) {
        var userSaved = createUserUsecase.execute(new UserMapperImpl().userRequestToDomain(userRequest));
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

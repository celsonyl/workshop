package com.celso.workshop.controller;

import com.celso.workshop.controller.model.UserRequest;
import com.celso.workshop.controller.model.UserResponse;
import com.celso.workshop.translator.UserMapperImpl;
import com.celso.workshop.usecase.CreateUserUsecase;
import com.celso.workshop.usecase.GetUserByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private CreateUserUsecase createUserUsecase;
    @Autowired
    private GetUserByIdUsecase getUserByIdUsecase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        var userDomain = getUserByIdUsecase.exeucte(id);

        return ResponseEntity.ok().body(new UserMapperImpl().userDomainToResponse(userDomain));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriComponentsBuilder) {
        var userSaved = createUserUsecase.execute(new UserMapperImpl().userRequestToDomain(userRequest));
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

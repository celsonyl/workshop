package com.celso.workshop.controller;

import com.celso.workshop.controller.model.UserRequest;
import com.celso.workshop.controller.model.UserResponse;
import com.celso.workshop.translator.UserMapperImpl;
import com.celso.workshop.usecase.CreateUserUsecase;
import com.celso.workshop.usecase.DeleteUserByIdUsecase;
import com.celso.workshop.usecase.GetAllUsersUsecase;
import com.celso.workshop.usecase.GetUserByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private CreateUserUsecase createUserUsecase;
    @Autowired
    private GetUserByIdUsecase getUserByIdUsecase;
    @Autowired
    private GetAllUsersUsecase getAllUsersUsecase;
    @Autowired
    private DeleteUserByIdUsecase deleteUserByIdUsecase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        var userDomain = getUserByIdUsecase.exeucte(id);

        return ResponseEntity.ok().body(new UserMapperImpl().userDomainToResponse(userDomain));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var users = getAllUsersUsecase.execute();
        return ResponseEntity.ok().body(users.stream()
                .map(new UserMapperImpl()::userDomainToResponse)
                .collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest, UriComponentsBuilder uriComponentsBuilder) {
        var userSaved = createUserUsecase.execute(new UserMapperImpl().userRequestToDomain(userRequest));
        URI uri = uriComponentsBuilder.path("/user/{id}").buildAndExpand(userSaved.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable String id) {
        var user = getUserByIdUsecase.exeucte(id);
        deleteUserByIdUsecase.execute(user.getId());

        return ResponseEntity.noContent().build();
    }
}

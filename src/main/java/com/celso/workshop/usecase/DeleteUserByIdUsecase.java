package com.celso.workshop.usecase;

import com.celso.workshop.gateway.DeleteUserByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdUsecase {

    @Autowired
    private DeleteUserByIdGateway deleteUserByIdGateway;

    public void execute(String id) {
        deleteUserByIdGateway.execute(id);
    }
}

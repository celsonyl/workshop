package com.celso.workshop.usecase;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.domain.exceptions.ObjectNotFoundException;
import com.celso.workshop.gateway.GetUserByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdUsecase {

    @Autowired
    private GetUserByIdGateway getUserByIdGateway;

    public UserDomain exeucte(String id) {
        return getUserByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found!"));
    }
}
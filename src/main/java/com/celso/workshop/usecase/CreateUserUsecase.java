package com.celso.workshop.usecase;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.CreateUserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUsecase {

    @Autowired
    private CreateUserGateway createUserGateway;

    public UserDomain execute(UserDomain userDomain) {
        return createUserGateway.execute(userDomain);
    }
}

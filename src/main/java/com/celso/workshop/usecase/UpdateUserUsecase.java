package com.celso.workshop.usecase;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.UpdateUserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserUsecase {

    @Autowired
    private UpdateUserGateway updateUserGateway;
    @Autowired
    private GetUserByIdUsecase getUserByIdUsecase;

    public UserDomain execute(String id, UserDomain userDomain) {
        getUserByIdUsecase.exeucte(id);
        return updateUserGateway.execute(id, userDomain);
    }
}

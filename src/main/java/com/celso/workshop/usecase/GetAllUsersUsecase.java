package com.celso.workshop.usecase;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.GetAllUsersGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllUsersUsecase {

    @Autowired
    private GetAllUsersGateway getAllUsersGateway;

    public List<UserDomain> execute() {
        return getAllUsersGateway.execute();
    }
}

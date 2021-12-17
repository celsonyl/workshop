package com.celso.workshop.gateway;

import com.celso.workshop.domain.UserDomain;

import java.util.Optional;

public interface GetUserByIdGateway {

    Optional<UserDomain> execute(String id);
}

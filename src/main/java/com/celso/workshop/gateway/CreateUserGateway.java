package com.celso.workshop.gateway;

import com.celso.workshop.domain.UserDomain;

public interface CreateUserGateway {

    UserDomain execute(UserDomain userDomain);
}

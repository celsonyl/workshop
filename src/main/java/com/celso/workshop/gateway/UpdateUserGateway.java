package com.celso.workshop.gateway;

import com.celso.workshop.domain.UserDomain;

public interface UpdateUserGateway {

    UserDomain execute(String id, UserDomain userDomain);
}

package com.celso.workshop.gateway;

import com.celso.workshop.domain.UserDomain;

import java.util.List;

public interface GetAllUsersGateway {

    List<UserDomain> execute();
}

package com.celso.workshop.translator;

import com.celso.workshop.controller.model.UserRequest;
import com.celso.workshop.controller.model.UserResponse;
import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.mongodb.model.UserDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDatabase userDomainToDatabase(UserDomain userDomain);

    UserDomain userDatabaseToDomain(UserDatabase userDatabase);

    UserDomain userRequestToDomain(UserRequest userRequest);

    UserResponse userDomainToResponse(UserDomain userDomain);
}

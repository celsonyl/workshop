package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.CreateUserGateway;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import com.celso.workshop.translator.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserGatewayImpl implements CreateUserGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDomain execute(UserDomain userDomain) {
        var userSaved = userRepository.save(new UserMapperImpl().userDomainToDatabase(userDomain));

        return new UserMapperImpl().userDatabaseToDomain(userSaved);
    }
}

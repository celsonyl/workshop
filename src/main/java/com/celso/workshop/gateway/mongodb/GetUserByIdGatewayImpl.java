package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.GetUserByIdGateway;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import com.celso.workshop.translator.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserByIdGatewayImpl implements GetUserByIdGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<UserDomain> execute(String id) {

        var user = userRepository.findById(id);
        if (user.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new UserMapperImpl().userDatabaseToDomain(user.get()));
    }
}

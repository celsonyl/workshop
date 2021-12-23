package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.GetAllUsersGateway;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import com.celso.workshop.translator.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllUsersGatewayImpl implements GetAllUsersGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDomain> execute() {
        var users = userRepository.findAll();

        return users.stream()
                .map(new UserMapperImpl()::userDatabaseToDomain)
                .collect(Collectors.toList());
    }
}

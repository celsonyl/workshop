package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.gateway.DeleteUserByIdGateway;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdGatewayImpl implements DeleteUserByIdGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(String id) {
        userRepository.deleteById(id);
    }
}

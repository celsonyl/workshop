package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.UserDomain;
import com.celso.workshop.gateway.UpdateUserGateway;
import com.celso.workshop.gateway.mongodb.model.UserDatabase;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import com.celso.workshop.translator.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserGatewayImpl implements UpdateUserGateway {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDomain execute(String id, UserDomain userDomain) {
        var user = userRepository.findById(id);
        if (user.isPresent()) {
            updateUser(user.get(), userDomain);
            return new UserMapperImpl().userDatabaseToDomain(user.get());
        }
        return userDomain;
    }

    private void updateUser(UserDatabase userDatabase, UserDomain userDomain) {
        userDatabase.setEmail(userDomain.getEmail());
        userDatabase.setName(userDomain.getName());
        userRepository.save(userDatabase);
    }
}

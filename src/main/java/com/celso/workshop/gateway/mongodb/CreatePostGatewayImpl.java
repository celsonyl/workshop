package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.CreatePostGateway;
import com.celso.workshop.gateway.mongodb.model.UserDatabase;
import com.celso.workshop.gateway.mongodb.repository.PostRepository;
import com.celso.workshop.gateway.mongodb.repository.UserRepository;
import com.celso.workshop.translator.PostMapper;
import com.celso.workshop.translator.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreatePostGatewayImpl implements CreatePostGateway {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<PostDomain> execute(PostDomain postDomain) {
        var user = userRepository.findById(postDomain.getUserDomain().getId());
        if (user.isEmpty()) {
            return Optional.empty();
        }
        preparePost(user.get(), postDomain);
        var postSaved = postRepository.save(new PostMapper().postDomainToDatabase(postDomain));

        return Optional.of(new PostMapper().postDatabaseToDomain(postSaved));
    }

    private void preparePost(UserDatabase userDatabase, PostDomain postDomain) {
        var userDomain = new UserMapperImpl().userDatabaseToDomain(userDatabase);
        postDomain.setUserDomain(userDomain);
    }
}
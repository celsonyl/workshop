package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.GetPostByIdGateway;
import com.celso.workshop.gateway.mongodb.repository.PostRepository;
import com.celso.workshop.translator.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetPostByIdGatewayImpl implements GetPostByIdGateway {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Optional<PostDomain> execute(String id) {
        var post = postRepository.findById(id);
        if (post.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new PostMapper().postDatabaseToDomain(post.get()));
    }
}

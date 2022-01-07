package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.GetAllPostsGateway;
import com.celso.workshop.gateway.mongodb.repository.PostRepository;
import com.celso.workshop.translator.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAllPostsGatewayImpl implements GetAllPostsGateway {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<PostDomain> execute() {
        var posts = postRepository.findAll();

        return posts.stream()
                .map(new PostMapper()::postDatabaseToDomain)
                .collect(Collectors.toList());
    }
}

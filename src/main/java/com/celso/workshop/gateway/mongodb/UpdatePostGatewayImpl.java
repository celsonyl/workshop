package com.celso.workshop.gateway.mongodb;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.UpdatePostGateway;
import com.celso.workshop.gateway.mongodb.model.PostDatabase;
import com.celso.workshop.gateway.mongodb.repository.PostRepository;
import com.celso.workshop.translator.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostGatewayImpl implements UpdatePostGateway {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDomain execute(String id, PostDomain postDomain) {
        var post = postRepository.findById(id);
        if (post.isPresent()) {
            updatePost(post.get(), postDomain);
            return new PostMapper().postDatabaseToDomain(post.get());
        }

        return postDomain;
    }

    private void updatePost(PostDatabase postDatabase, PostDomain postDomain) {
        postDatabase.setBody(postDomain.getBody());
        postDatabase.setTitle(postDomain.getTitle());
        postRepository.save(postDatabase);
    }
}

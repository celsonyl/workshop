package com.celso.workshop.usecase;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.domain.exceptions.ObjectNotFoundException;
import com.celso.workshop.gateway.GetAllPostsByUserIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPostsByUserIdUsecase {

    @Autowired
    private GetAllPostsByUserIdGateway getAllPostsByUserIdGateway;

    public List<PostDomain> execute(String id) {
        var posts = getAllPostsByUserIdGateway.execute(id);
        if (posts.isEmpty()) {
            throw new ObjectNotFoundException("User not exists or not have posts yet");
        }
        return posts;
    }
}

package com.celso.workshop.usecase;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.domain.exceptions.ObjectNotFoundException;
import com.celso.workshop.gateway.CreatePostGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePostUsecase {

    @Autowired
    private CreatePostGateway createPostGateway;

    public PostDomain execute(PostDomain postDomain) {
        return createPostGateway.execute(postDomain)
                .orElseThrow(() -> new ObjectNotFoundException("User not exists!"));
    }
}
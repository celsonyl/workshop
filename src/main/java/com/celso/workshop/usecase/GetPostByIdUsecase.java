package com.celso.workshop.usecase;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.domain.exceptions.ObjectNotFoundException;
import com.celso.workshop.gateway.GetPostByIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostByIdUsecase {

    @Autowired
    private GetPostByIdGateway getPostByIdGateway;

    public PostDomain execute(String id) {
        return getPostByIdGateway.execute(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post not found!"));
    }
}

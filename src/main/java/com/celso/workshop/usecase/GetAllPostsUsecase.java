package com.celso.workshop.usecase;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.GetAllPostsGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPostsUsecase {

    @Autowired
    private GetAllPostsGateway getAllPostsGateway;

    public List<PostDomain> execute() {
        return getAllPostsGateway.execute();
    }
}

package com.celso.workshop.usecase;

import com.celso.workshop.domain.PostDomain;
import com.celso.workshop.gateway.UpdatePostGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdatePostUsecase {

    @Autowired
    private UpdatePostGateway updatePostGateway;

    public PostDomain execute(String id, PostDomain postDomain) {
        return updatePostGateway.execute(id, postDomain);
    }
}

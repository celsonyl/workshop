package com.celso.workshop.gateway;

import com.celso.workshop.domain.PostDomain;

import java.util.Optional;

public interface GetPostByIdGateway {

    Optional<PostDomain> execute(String id);
}

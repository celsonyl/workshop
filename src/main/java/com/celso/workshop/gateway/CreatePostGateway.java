package com.celso.workshop.gateway;

import com.celso.workshop.domain.PostDomain;

import java.util.Optional;

public interface CreatePostGateway {

    Optional<PostDomain> execute(PostDomain postDomain);
}
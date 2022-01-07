package com.celso.workshop.gateway;

import com.celso.workshop.domain.PostDomain;

import java.util.List;

public interface GetAllPostsGateway {

    List<PostDomain> execute();
}

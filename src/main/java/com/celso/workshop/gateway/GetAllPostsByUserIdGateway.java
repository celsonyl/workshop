package com.celso.workshop.gateway;

import com.celso.workshop.domain.PostDomain;

import java.util.List;

public interface GetAllPostsByUserIdGateway {

    List<PostDomain> execute(String id);
}

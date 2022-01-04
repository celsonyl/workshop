package com.celso.workshop.gateway;

import com.celso.workshop.domain.PostDomain;

public interface UpdatePostGateway {

    PostDomain execute(String id, PostDomain postDomain);
}

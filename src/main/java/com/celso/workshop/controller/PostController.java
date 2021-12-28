package com.celso.workshop.controller;

import com.celso.workshop.controller.model.PostRequest;
import com.celso.workshop.controller.model.PostResponse;
import com.celso.workshop.translator.PostMapper;
import com.celso.workshop.usecase.CreatePostUsecase;
import com.celso.workshop.usecase.GetPostByIdUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RequestMapping(value = "/post")
@RestController
public class PostController {

    @Autowired
    private CreatePostUsecase createPostUsecase;
    @Autowired
    private GetPostByIdUsecase getPostByIdUsecase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        var post = getPostByIdUsecase.execute(id);

        return ResponseEntity.ok().body(new PostMapper().postDomainToResponse(post));
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest, UriComponentsBuilder uriComponentsBuilder) {
        var post = createPostUsecase.execute(new PostMapper().postRequestToDomain(postRequest));
        URI uri = uriComponentsBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
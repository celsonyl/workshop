package com.celso.workshop.controller;

import com.celso.workshop.controller.model.PostRequest;
import com.celso.workshop.controller.model.PostResponse;
import com.celso.workshop.translator.PostMapper;
import com.celso.workshop.usecase.CreatePostUsecase;
import com.celso.workshop.usecase.GetAllPostsUsecase;
import com.celso.workshop.usecase.GetPostByIdUsecase;
import com.celso.workshop.usecase.UpdatePostUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/post")
@RestController
public class PostController {

    @Autowired
    private CreatePostUsecase createPostUsecase;
    @Autowired
    private GetPostByIdUsecase getPostByIdUsecase;
    @Autowired
    private UpdatePostUsecase updatePostUsecase;
    @Autowired
    private GetAllPostsUsecase getAllPostsUsecase;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        var post = getPostByIdUsecase.execute(id);

        return ResponseEntity.ok().body(new PostMapper().postDomainToResponse(post));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        var posts = getAllPostsUsecase.execute();

        return ResponseEntity.ok().body(posts.stream()
                .map(new PostMapper()::postDomainToResponse)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<List<PostResponse>> getAllPostsByUserId(@PathVariable String id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest, UriComponentsBuilder uriComponentsBuilder) {
        var post = createPostUsecase.execute(new PostMapper().postRequestToDomain(postRequest));
        URI uri = uriComponentsBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable String id, @RequestBody PostRequest postRequest) {
        var postDomain = new PostMapper().postRequestUpdateToDomain(postRequest);
        updatePostUsecase.execute(id, postDomain);
        return ResponseEntity.noContent().build();
    }
}
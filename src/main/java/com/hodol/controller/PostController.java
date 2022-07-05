package com.hodol.controller;

import com.hodol.request.PostCreate;
import com.hodol.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        log.info("request={}", request);
        postService.write(request);
    }
}

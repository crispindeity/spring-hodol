package com.hodol.controller;

import com.hodol.request.PostCreate;
import com.hodol.service.PostService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    //SSR -> jsp, thymeleaf, mustache, freemarker
    //SPA ->
    //  vue, nuxt
    //  react, next

    private final PostService postService;

    @GetMapping("/posts")
    public void post(@RequestBody @Valid PostCreate request) {
        log.info("request={}", request);
        postService.write(request);
    }
}

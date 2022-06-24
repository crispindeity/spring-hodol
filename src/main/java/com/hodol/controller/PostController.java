package com.hodol.controller;

import com.hodol.request.PostCreate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class PostController {

    //SSR -> jsp, thymeleaf, mustache, freemarker
    //SPA ->
    //  vue, nuxt
    //  react, next
    @GetMapping("/posts")
    public Map<String, String> post(@RequestBody @Valid PostCreate params) {
        log.info("params={}", params);
        return Map.of();
    }
}

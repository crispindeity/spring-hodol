package com.hodol.controller;

import com.hodol.request.PostCreate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
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
    public Map<String, String> post(@RequestBody @Valid PostCreate params, BindingResult result) {
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            FieldError firstFieldError = fieldErrors.get(0);
            String fieldName = firstFieldError.getField();
            String errorMessage = firstFieldError.getDefaultMessage();

            Map<String, String> error = new HashMap<>();
            error.put(fieldName, errorMessage);
            return error;
        }
        log.info("params={}", params);
        return Map.of();
    }
}

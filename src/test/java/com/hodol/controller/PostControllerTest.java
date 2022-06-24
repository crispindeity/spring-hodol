package com.hodol.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("/posts 요청시 {}를 출력한다.")
    void helloTest() throws Exception {
        mockMvc.perform(get("/posts")
                        .contentType(APPLICATION_JSON)
                        .content("{\"title\":\"제목입니다.\",\"content\":\"내용입니다.\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("{}"))
                .andDo(print());
    }

    @Test
    @DisplayName("/posts 요청시 title 값은 필수다.")
    void titleTest() throws Exception {
        mockMvc.perform(get("/posts")
                        .contentType(APPLICATION_JSON)
                        .content("{\"title\": null, \"content\": \"내용입니다.\"}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value("400"))
                .andExpect(jsonPath("$.message").value("잘못된 요청입니다."))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
                .andDo(print());
    }
}

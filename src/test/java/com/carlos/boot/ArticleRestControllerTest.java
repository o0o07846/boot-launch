package com.carlos.boot;

import com.carlos.boot.controller.ArticleController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class ArticleRestControllerTest {

    private static MockMvc  mockMvc;

    @BeforeAll
    static void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void saveArticle() throws Exception{
        String article ="{\n" +
                "        \"title\": \"t1\",\n" +
                "        \"content\": \"RestAPI 風格撰寫\",\n" +
                "        \"createTime\": \"2024/03/12 21:01:46\",\n" +
                "        \"readers\": [\n" +
                "            {\n" +
                "                \"age\": 21,\n" +
                "                \"name\": \"alex\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"age\": 33,\n" +
                "                \"name\": \"carlos\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"auther\": \"zim\"\n" +
                "    }";

        MvcResult mv =mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST,"/rest/articles")
                .contentType("application/json")
                .content(article)
        ).andDo(print()).andReturn();
        mv.getResponse().setCharacterEncoding("UTF-8");
    System.out.println(mv);
    }

}

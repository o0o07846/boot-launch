package com.carlos.boot;

import com.carlos.boot.Model.Article;
import com.carlos.boot.service.ArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ArticleRestControllerTest3 {
@Resource
    private  MockMvc  mockMvc;

@MockBean
    private ArticleService articleService;
//    @BeforeAll
//    static void setUp(){
//        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
//    }

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
        ObjectMapper obm = new ObjectMapper();
        Article articleObj = obm.readValue(article,Article.class);

        //打樁
        when(articleService.saveArticle(articleObj)).thenReturn("ok");



        MvcResult mv =mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST,"/rest/articles")
                .contentType("application/json")
                .content(article)
        ).andDo(print()).andReturn();
        mv.getResponse().setCharacterEncoding("UTF-8");
    System.out.println(mv);
    }

}

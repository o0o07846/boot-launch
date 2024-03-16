package com.carlos.boot;

import com.carlos.boot.Model.Article;
import com.carlos.boot.Model.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {

    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper objectMapper= new ObjectMapper();

        Article ar = new Article();
        List<Reader> readerList = new ArrayList<>();
        readerList.add(new Reader(21,"alex"));
        readerList.add(new Reader(33,"carlos"));

        ar.setId(1L);
        ar.setAuthor("zim");
        ar.setContent("RestAPI 風格格");
        ar.setCreateTime(new Date());
        ar.setTitle("t1");
        ar.setReaders(readerList);

        String jsonString = objectMapper.writeValueAsString(ar);
        System.out.println(jsonString);

        Article article1=   objectMapper.readValue("{\"title\":\"t1\",\"content\":\"RestAPI \",\"createTime\":\"2024/03/11 22:16:14\",\"readers\":[{\"age\":21,\"name\":\"alex\"},{\"age\":33,\"name\":\"carlos\"}],\"auther\":\"zim\"}",Article.class);
        System.out.println(article1.toString());
    }
}

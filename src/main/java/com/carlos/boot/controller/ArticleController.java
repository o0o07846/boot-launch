package com.carlos.boot.controller;


import com.carlos.boot.AjaxResponse;
import com.carlos.boot.Model.Article;
import com.carlos.boot.Model.Reader;
import com.carlos.boot.service.ArticleService;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    ArticleService articleService;

//查文章
@RequestMapping(value = "/articles/{id}" ,method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id){
    Article ar = new Article();

    List<Reader> readerList = new ArrayList<>();
    readerList.add(new Reader(21,"alex"));
    readerList.add(new Reader(33,"carlos"));


    ar.setId(1L);
    ar.setAuthor("zim");
    ar.setContent("RestAPI 風格撰寫");
    ar.setCreateTime(new Date());
    ar.setTitle("t1");
    ar.setReaders(readerList);



    return AjaxResponse.success(ar,"查詢成功");


    }

    //新增文章1
    @RequestMapping(value = "/articles" ,method = RequestMethod.POST)
    public AjaxResponse saveArticle(@RequestBody Article     article){

        return AjaxResponse.success(articleService.saveArticle(article));
    }
    //新增文章2
//    @RequestMapping(value = "/articles" ,method = RequestMethod.POST)
//    public AjaxResponse saveArticle(
//                                    @RequestParam  String author,
//                                    @RequestParam String title,
//                                    @RequestParam String content,
//                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//                                    @RequestParam Date createTime){
//
//        return AjaxResponse.success();
//    }

    //修改文章
    @RequestMapping(value = "/articles" ,method = RequestMethod.PUT)
    public AjaxResponse updateArticle(@RequestBody Article article){

    if(article.getId() == null){
    //TODO 拋出自定義異常
    }
        return AjaxResponse.success();
    }

    //刪除文章 根據id
    @RequestMapping(value = "/articles/{id}" ,method = RequestMethod.DELETE)
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){


        return AjaxResponse.success();
    }
}

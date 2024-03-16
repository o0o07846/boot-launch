package com.carlos.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){
        return "HELLO22 --------" +name;
    }
}

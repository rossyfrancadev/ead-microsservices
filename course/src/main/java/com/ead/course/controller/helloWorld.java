package com.ead.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/hello")
public class helloWorld {
    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }
}

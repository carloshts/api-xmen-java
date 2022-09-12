package com.xmen.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class IndexRestCtr {
    @GetMapping
    public String index(){
        return "Hello World";
    }
}

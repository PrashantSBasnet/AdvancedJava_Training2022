package com.example.springsecurityjpah2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ApplicationController {

    @GetMapping("/process")
    public String greeting() {
        return "spring security example";
    }

}

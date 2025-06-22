package com.pm.ecommerceapiintegration.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categories")
public class Categorycontroller {
    @GetMapping
    public String getCategory(){
        return "Hello World";
    }

    @GetMapping("/count")
    public int getCategoryCount(){
        return 5;
    }
}

package com.storeexample.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreExampleDemoController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping(value = "/catalog")
    public String getCatalog() {
        return "catalog.html";
    }
}

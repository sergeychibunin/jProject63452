package com.storeexample.demo.controllers;

import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreExampleDemoController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private RSSFeedService rssFeedService;

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index.html";
    }

    @GetMapping(value = "/catalog")
    public ModelAndView getCatalog(ModelAndView modelAndView) {
//        modelAndView.addObject("rssFeeds", rssFeedService.listAllRSSFeeds(null));
        modelAndView.setViewName("catalog");
        return modelAndView;
    }

    @GetMapping(value = "/exception")
    public String getException() {
        String pageTitle = null;
        return pageTitle.toUpperCase();
    }
}

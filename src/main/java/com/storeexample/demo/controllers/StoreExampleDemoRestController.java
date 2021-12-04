package com.storeexample.demo.controllers;

import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class StoreExampleDemoRestController {

    @Autowired
    private RSSFeedService rssFeedService;

    @GetMapping("/healthcheck")
    public Map<String, String> checkHealth() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return response;
    }

    @GetMapping("/rssfeeds")
    public List<RSSFeed> getAllRssFeeds() {
        return rssFeedService.listAllRSSFeeds();
    }
}

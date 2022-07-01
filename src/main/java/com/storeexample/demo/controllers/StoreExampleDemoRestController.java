package com.storeexample.demo.controllers;

import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.dao.specifications.RSSFeedSpecificationsBuilder;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Page<RSSFeed> getAllRssFeeds(
            @RequestParam(value = "search", required = false) String search, Pageable pageable
    ) throws InterruptedException {

        Specification<RSSFeed> spec = null;
        if (search != null) {
            RSSFeedSpecificationsBuilder specificationsBuilder = new RSSFeedSpecificationsBuilder();
            // TODO fix for cyrillic letters
            Pattern pattern = Pattern.compile("(\\w+?)(:)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                specificationsBuilder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
            spec = specificationsBuilder.build();
        }

        return rssFeedService.listAllRSSFeeds(spec, pageable);
    }
}

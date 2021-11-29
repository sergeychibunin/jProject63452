package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;

import java.util.List;

public class RSSFeedServiceImpl implements RSSFeedService {

    private RSSFeedRepository rssFeedRepository;

    @Override
    public List<RSSFeed> listAllRSSFeeds() {
        return rssFeedRepository.allRssFeeds();
    }
}

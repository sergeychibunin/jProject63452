package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RSSFeedServiceImpl implements RSSFeedService {

    private RSSFeedRepository rssFeedRepository;

    @Autowired
    public void setRssFeedRepository(RSSFeedRepository rssFeedRepository) {
        this.rssFeedRepository = rssFeedRepository;
    }

    @Cacheable("rssFeeds")
    @Override
    public List<RSSFeed> listAllRSSFeeds() throws InterruptedException {
        Thread.sleep(5000L);
        List<RSSFeed> rssFeeds = new ArrayList<>();
        rssFeedRepository.findAll().forEach(rssFeeds::add);
        return rssFeeds;
    }
}

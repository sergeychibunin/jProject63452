package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<RSSFeed> listAllRSSFeeds() {
        List<RSSFeed> rssFeeds = new ArrayList<>();
        rssFeedRepository.findAll().forEach(rssFeeds::add);
        return rssFeeds;
    }
}

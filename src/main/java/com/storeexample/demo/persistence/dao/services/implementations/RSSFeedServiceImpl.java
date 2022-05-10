package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
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
    public List<RSSFeed> listAllRSSFeeds(Specification<RSSFeed> specification) throws InterruptedException {
        Thread.sleep(1000L);
        return new ArrayList<>(rssFeedRepository.findAll(specification));
    }
}

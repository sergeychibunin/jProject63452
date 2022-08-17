package com.storeexample.demo.persistence.dao.services.implementations;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.interfaces.RSSFeedService;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public RSSFeed get(Long id) {
        return rssFeedRepository.findById(id).orElse(null);
    }

    @Cacheable("rssFeeds")
    @Override
    public Page<RSSFeed> listAllRSSFeeds(Specification<RSSFeed> specification, Pageable pageable)
            throws InterruptedException {

        Thread.sleep(1000L);
        return rssFeedRepository.findAll(specification, pageable);
    }

    @Override
    public List<RSSFeed> listAllOddRSSFeeds() {
        return rssFeedRepository.getOddItems();
    }
}

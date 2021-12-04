package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.RSSFeed;

import java.util.List;

public interface RSSFeedService {
    List<RSSFeed> listAllRSSFeeds() throws InterruptedException;
}

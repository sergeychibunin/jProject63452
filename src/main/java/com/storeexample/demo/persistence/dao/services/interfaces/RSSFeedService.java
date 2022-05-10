package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface RSSFeedService {
    List<RSSFeed> listAllRSSFeeds(Specification<RSSFeed> specification) throws InterruptedException;
}

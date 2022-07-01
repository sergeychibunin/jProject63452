package com.storeexample.demo.persistence.dao.services.interfaces;

import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface RSSFeedService {
    Page<RSSFeed> listAllRSSFeeds(Specification<RSSFeed> specification, Pageable paging) throws InterruptedException;
}

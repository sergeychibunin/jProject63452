package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RSSFeedRepository extends PagingAndSortingRepository<RSSFeed, Long> {
}

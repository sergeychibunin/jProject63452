package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RSSFeedRepository extends CrudRepository<RSSFeed, Long> {
}

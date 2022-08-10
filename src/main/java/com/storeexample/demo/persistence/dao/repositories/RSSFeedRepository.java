package com.storeexample.demo.persistence.dao.repositories;

import com.storeexample.demo.persistence.model.RSSFeed;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RSSFeedRepository
        extends PagingAndSortingRepository<RSSFeed, Long>, JpaSpecificationExecutor<RSSFeed> {

    @Query(value = "select * from rssfeed where mod(id, 2) > 0",
            nativeQuery = true
    )
    List<RSSFeed> getOddItems();
}

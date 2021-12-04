package com.storeexample.demo;

import com.storeexample.demo.persistence.dao.repositories.RSSFeedRepository;
import com.storeexample.demo.persistence.dao.services.implementations.RSSFeedServiceImpl;
import com.storeexample.demo.persistence.model.RSSFeed;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DaoTests {

    @Mock
    private RSSFeedRepository rssFeedRepository;

    @InjectMocks
    private RSSFeedServiceImpl rssFeedService;

    static List<RSSFeed> rssFeedList = new ArrayList<>();

    static {
        rssFeedList.add(new RSSFeed("Feed A"));
    }

    @Test
    public void getAllRSSFeeds() {
        Mockito.when(rssFeedRepository.findAll())
                .thenReturn(rssFeedList);

        Assertions.assertEquals(
                rssFeedService.listAllRSSFeeds(),
                rssFeedList
        );
    }
}

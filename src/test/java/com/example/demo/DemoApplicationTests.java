package com.example.demo;

import com.example.demo.dao.UrlShortenerDao;
import com.example.demo.service.UrlShortenerService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class DemoApplicationTests {

    private final Logger logger = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private UrlShortenerService urlShortenerService;

    @Autowired
    private UrlShortenerDao urlShortenerDao;

    @AfterAll
    void afterAll() {
        urlShortenerDao.deleteAllRows();
    }

    @Test
    void contextLoads() {
        for (int i = 0; i < 100; i++) {
            String originalUrl = "https://google.com/" + UUID.randomUUID().toString();
            String shortenerUrl = urlShortenerService.shorten(originalUrl);
            String originalFromDb = urlShortenerService.original(shortenerUrl);
            logger.info(originalUrl + " -> " + shortenerUrl);
            assertEquals(originalUrl, originalFromDb);
        }
    }

}

package com.example.springbootlogging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootLoggingApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        logger.trace("------这是一个trace日志------");
        logger.debug("------这是一个debug日志------");
        logger.info("------这是一个info日志------");
        logger.warn("------这是一个warn日志------");
        logger.error("------这是一个error日志------");
    }

}

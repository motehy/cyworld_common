package com.cyworld.common.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.URISyntaxException;

@Profile({"local"})
@Component
public class EmbeddedRedisConfiguration {

	@Value("${spring.redis.port}") private int redisPort;

	private RedisServer redisServer;

	@PostConstruct
	public void startRedis() throws IOException, URISyntaxException {
		//if (redisServer == null || !redisServer.isActive()) {
			redisServer = RedisServer.builder()
	                .port(redisPort)
	                .setting("maxmemory 128M") //maxheap 128M
	                .build();
	        redisServer.start(); //Redis 시작
		//}
	}

    @PreDestroy
    public void stopRedis() throws InterruptedException {
        if (redisServer != null) {
            redisServer.stop();
        }
    }
}

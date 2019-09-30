package com.wzy.video.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "reids")
@Data
public class JedisPoolConfig {
    String host;
    Integer port;
    Integer maxIdle;
    Integer maxTotal;
    Integer maxWaitMillis;
    Integer minEvictableIdleTimeMillis;
    Integer numTestsPerEvictionRun;
    long timeBetweenEvictionRunsMillis;
    boolean testOnBorrow;
    boolean testWhileIdle;
    Integer mmaxRedirectsac;
    String redispwd;
}

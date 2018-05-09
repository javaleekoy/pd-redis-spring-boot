package com.peramdy.cache.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author pd
 */
@Configuration
@EnableConfigurationProperties(value = {JedisProperties.class})
public class JedisAutoConfiguration {

}

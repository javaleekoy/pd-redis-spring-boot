package com.peramdy.cache.autoconfigure;

import com.peramdy.cache.config.JedisConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.peramdy.cache.constants.PdConstants.PD_REDIS_PREFIX;


/**
 * @author pd 2018/3/8.
 */
@ConfigurationProperties(prefix = PD_REDIS_PREFIX)
public class JedisProperties extends JedisConfig {

}

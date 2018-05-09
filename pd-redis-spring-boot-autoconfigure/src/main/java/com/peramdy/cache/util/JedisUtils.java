package com.peramdy.cache.util;


import com.peramdy.cache.autoconfigure.JedisProperties;
import com.peramdy.cache.builder.JedisBuilder;
import com.peramdy.cache.builder.JedisClusterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author peramdy on 2018/2/7.
 */

@Component
public class JedisUtils {

    @Autowired
    private JedisProperties jedisProperties;

    /**
     * create cluster
     *
     * @return jedisCluster
     * @throws Exception exception
     */
    public JedisCluster createJedisCluster() throws Exception {
        JedisClusterBuilder jedisClusterBuilder = JedisClusterBuilder.getInstance();
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(jedisProperties.getMaxTotal());
        poolConfig.setMinIdle(jedisProperties.getMinIdle());
        poolConfig.setMaxIdle(jedisProperties.getMaxIdle());
        jedisClusterBuilder.setAddressConfigs(jedisProperties.getAddresses());
        jedisClusterBuilder.setGenericObjectPoolConfig(poolConfig);
        jedisClusterBuilder.setMaxTotal(jedisProperties.getMaxTotal());
        jedisClusterBuilder.setTimeout(jedisProperties.getTimeout());
        return jedisClusterBuilder.build();
    }


    /**
     * create single
     *
     * @return jedis
     */
    public Jedis createJedis() {
        Jedis jedis = null;
        try {
            JedisBuilder jedisBuilder = JedisBuilder.getInstance();
            jedisBuilder.setHost(jedisProperties.getIp());
            jedisBuilder.setPort(jedisProperties.getPort());
            jedisBuilder.setTimeout(jedisProperties.getTimeout());
            jedis = jedisBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
            return jedis;
        }
        return jedis;
    }


}

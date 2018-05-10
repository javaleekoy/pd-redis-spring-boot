package com.peramdy.cache.builder;

import com.peramdy.cache.adaptor.JedisAdaptor;
import com.peramdy.cache.exception.PdIllegalArgumentException;
import com.peramdy.cache.exception.PdJedisConnectionException;
import redis.clients.jedis.Jedis;

/**
 * @author pd 2018/2/8.
 */
public class JedisBuilder {

    /**
     * host
     */
    private String host;

    /**
     * port
     */
    private int port;

    /**
     * timeout
     */
    private int timeout;

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Jedis build() throws Exception {
        if (timeout <= 0) {
            throw new PdIllegalArgumentException("timeout 为0或为空了！");
        }
        if (port <= 0) {
            throw new PdIllegalArgumentException("maxTotal 为0或为空了！");
        }

        if (host == null) {
            throw new PdIllegalArgumentException("未配置redis集群ip地址！");
        }
        Jedis jedis = null;
        try {
            jedis = new JedisAdaptor(host, port, timeout);
        } catch (Exception e) {
            throw new PdJedisConnectionException("redis 连接异常了！", e);
        }
        return jedis;
    }

    public static JedisBuilder getInstance() {
        return new JedisBuilder();
    }


}

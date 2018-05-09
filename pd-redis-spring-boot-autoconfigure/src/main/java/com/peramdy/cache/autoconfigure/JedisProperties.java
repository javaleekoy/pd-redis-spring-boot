package com.peramdy.cache.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static com.peramdy.cache.constants.PdConstants.PD_REDIS_PREFIX;
import static com.peramdy.cache.constants.RedisDefaultConfig.*;


/**
 * @author pd 2018/3/8.
 */
@ConfigurationProperties(prefix = PD_REDIS_PREFIX)
public class JedisProperties {

    private String addresses = REDIS_DEFAULT_ADDRESSES;
    private int timeout = REDIS_DEFAULT_TIMEOUT;
    private int maxTotal = REDIS_DEFAULT_MAXTOTAL;
    private int maxIdle = REDIS_DEFAULT_MAXIDLE;
    private int minIdle = REDIS_DEFAULT_MINIDLE;
    private String ip = REDIS_DEFAULT_IP;
    private int port = REDIS_DEFAULT_PORT;

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }


}

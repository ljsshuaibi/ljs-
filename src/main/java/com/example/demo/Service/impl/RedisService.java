package com.example.demo.Service.impl;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
@Service
public class RedisService {

    private JedisPool jedisPool;

    public RedisService() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(100); // 最大连接数
        poolConfig.setMaxIdle(20); // 最大空闲连接数
        poolConfig.setMinIdle(10); // 最小空闲连接数
        poolConfig.setMaxWaitMillis(1000L); // 获取连接的最大等待时间

        jedisPool = new JedisPool(poolConfig, "localhost", 6379);
    }

    public void set(String key, String value) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String get(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void delete(String key) {
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

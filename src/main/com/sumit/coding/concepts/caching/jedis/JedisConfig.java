package main.com.sumit.coding.concepts.caching.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConfig {

    public void addInRedis(String key, String value) {
        JedisPool pool = new JedisPool("localhost", 6379);

        // Get the pool and use the database
        try (Jedis jedis = pool.getResource()) {
            jedis.set(key, value);
        }

        // close the connection pool
        pool.close();
    }

    public String getFromRedis(String key) {
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), "localhost", 6379);
        String value;
        try (Jedis jedis = jedisPool.getResource()) {
            value = jedis.get(key);
            System.out.println(value);
        }
        jedisPool.close();
        return value;
    }

    public static void main(String[] args) {
        new JedisConfig().addInRedis("Sumit", "Jadiya");
        System.out.println(new JedisConfig().getFromRedis("Sumit"));
    }
}

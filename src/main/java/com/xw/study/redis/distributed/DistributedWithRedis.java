package com.xw.study.redis.distributed;

import java.util.UUID;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 测试redis分布式锁
 * @author TTX034
 *
 */
public class DistributedWithRedis {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-common.xml");
		JedisPool jedisPool = context.getBean(JedisPool.class);
//		System.out.println(jedisPool);
		Jedis jedis = jedisPool.getResource();
		
//		testRedis(jedis);

		boolean lock = RedisTool.tryGetDistributedLock(jedis, "lock:erp:111", UUID.randomUUID().toString(), 10000);
		System.out.println(lock);
	}

	private static void testRedis(Jedis jedis) {
		System.out.println(jedis.configGet("port"));// [port, 6379]
		System.out.println(jedis.configGet("*"));

	}
}

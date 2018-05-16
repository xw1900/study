package com.xw.study.thread.distributed;

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
		System.out.println(jedisPool);
		Jedis jedis = jedisPool.getResource();

		boolean lock = RedisTool.tryGetDistributedLock(jedis, "lock:erp:111", UUID.randomUUID().toString(), 10000);
		System.out.println(lock);
	}
}

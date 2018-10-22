package com.xw.study.redis.distributed;

import java.util.Collections;

import redis.clients.jedis.Jedis;

/**
 * redis分布式锁
 * @author TTX034
 *
 */
public class RedisTool {
 
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final int DEFAULT_EXPIRE_TIME = 1800000;
    private static final Long RELEASE_SUCCESS = 1L;
 
    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间 毫秒
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expire_time) {
 
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expire_time);
 
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
 
    }
    
    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId) {
 
        return tryGetDistributedLock(jedis, lockKey, requestId, DEFAULT_EXPIRE_TIME);
    }
    
    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

    	// 1、不能谁都可以解锁
//    	jedis.del(lockKey);
    	
    	// 2、保证原子性
//    	// 判断加锁与解锁是不是同一个客户端
//        if (requestId.equals(jedis.get(lockKey))) {
//            // 若在此时，这把锁突然不是这个客户端的，则会误解锁
//            jedis.del(lockKey);
//        }
        
    	// 正确姿势：lua脚本保证原子性
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
 
}
package com.xw.study.thread.distributed;

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
 
}
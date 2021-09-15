package entity;

import modelpojo.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bin.yu
 * @create 2019-03-01 10:50
 **/
@Component
public class RedisUtil {

    public static final String CHANNEL_QUOTA_CHANGE_LOCK = "channelQuotaChangeLock";
    public static final String PROMOTION_CODE_QUANTITY_LOCK = "promotionCodeQuantityLock";
    private static final Long SUCCESS = 1L;
    private static final String MAOHAO = ":";

    private static final Long RELEASE_SUCCESS = 1L;
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "EX";
    private static final String RELEASE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
    private static Logger log = LoggerFactory.getLogger(RedisUtil.class);
    private static ScheduledExecutorService threadPool = new ScheduledThreadPoolExecutor(5);
    @Autowired
    private RedisTemplate redisTemplate;


    public String getRedisKey(String keyType, String... params) {
        StringBuilder builder = new StringBuilder();
        builder.append(keyType).append(MAOHAO);
        for (String param : params) {
            if (StringUtils.isNotBlank(param)) {
                builder.append(param).append(MAOHAO);
            }
        }

        return builder.substring(0, builder.length() - 1);
    }


    public boolean getLock(String lockKey, String value, int expireTime) throws Exception {
        Object result;
        try {
            String script = "if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end";
            RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);
            result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, String.valueOf(expireTime));
            int i = 0;
            while (!SUCCESS.equals(result)) {
                try {
                    if (i < 3) {
                        Thread.sleep(500);
                        result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, String.valueOf(expireTime));
                        i++;
                    } else {
                        //超过3次未获取锁,则返回
                        log.error(" redisTemplate.getLock超时，lockKey={}，lockValue={}", lockKey, value);
                        throw new Exception(ErrorCode.REDIS_LOCK_GAIN_TIMEOUT);
                    }
                } catch (InterruptedException e) {
                    throw new Exception(ErrorCode.UNKOWN_ERROR);
                }
            }
        } catch (Exception e) {
            log.error(" redisTemplate.getLock异常，lockKey={}，lockValue={}，error:{}", lockKey, value, e);
            throw new Exception(ErrorCode.REDIS_LOCK_GAIN_ERROR);
        }
        return SUCCESS.equals(result);
    }

    /**
     * 释放锁
     *
     * @param lockKey
     * @param requestId
     * @return
     */
    public boolean releaseLock(String lockKey, String requestId) {
        try {
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            RedisScript<String> redisScript = new DefaultRedisScript<>(script, String.class);
            Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), requestId);
            if (SUCCESS.equals(result)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            log.error(" redisTemplate.releaseLock error:{}", e.getMessage(), e);

        }
        return false;
    }

    public void setForSeconds(String key, Object value, Long timeOut) {
        redisTemplate.opsForValue().set(key, value, timeOut, TimeUnit.SECONDS);
    }

    public Object get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        return o;
    }

    public void saveRedis(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Boolean deleteRedis(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void delByKeys(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 递增或递减
     * @param key 键
     * @param delta 增量或减量
     * @return
     */
    public long chaneValue(String key, long delta){
        if(delta<0){
           return 0L;
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    //===============================list=================================

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束  0 到 -1代表所有值
     * @return
     */
    public List listGet(String key, long start, long end) {
        try {
            List range = redisTemplate.opsForList().range(key, start, end);
            return range;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public long listGetListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object listGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public boolean listRight(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public boolean listRightWithExpireTime(String key, String value, long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param values 值
     * @return
     */
    public boolean listRightAll(String key, String values) {
        try {
            redisTemplate.opsForList().rightPushAll(key, values);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param values 值
     * @param time  时间(秒)
     * @return
     */
    public boolean listRightAllWithExpireTime(String key, Object values, long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, values);
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public boolean listUpdateIndex(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public long listRemove(String key, long count, Object value) {
        try {
            Long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    //===============================hash=================================
    /**
     * 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Long hashIncrementForLong(String key, String hashKey,long number){
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * 给指定 hash 的 hashkey 做增减操作
     * @param key
     * @param hashKey
     * @param number
     * @return
     */
    public Double hashIncrementForDouble(String key, String hashKey,double number){
        return redisTemplate.opsForHash().increment(key, hashKey, number);
    }

    /**
     * 给一个指定的 key 值附加过期时间
     * @param key
     * @param time
     * @param type
     * @return
     */
    public boolean expire(String key,long time,TimeUnit type){
        return redisTemplate.boundValueOps(key).expire(time, type);
    }

    /**
     * 删除指定 hash 的 HashKey
     * @param key
     * @param hashKeys
     * @return 删除成功的 数量
     */
    public Long deleteHashKey(String key, String ...hashKeys){
        return redisTemplate.opsForHash().delete(key, hashKeys);
    }

    /**
     * 获取指定 key 下的 hashkey
     * @param key
     * @param hashKey
     * @return
     */
    public Object getHashKey(String key,String hashKey){
        return redisTemplate.opsForHash().get(key, hashKey);
    }


    /**
     * 获取hashKey对应的所有键值
     * @param key 键
     * @return 对应的多个键值
     */
    public Map<Object,Object> getAllHashKey(String key){
        return redisTemplate.opsForHash().entries(key);
    }


}

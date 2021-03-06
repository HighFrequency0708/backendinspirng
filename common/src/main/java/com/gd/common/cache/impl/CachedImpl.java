package com.gd.common.cache.impl;

import com.gd.common.cache.ICached;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CachedImpl implements ICached {
    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public boolean set(String key, String value, int expiry) {
        return false;
    }

    @Override
    public boolean set(String key, String value) {
        return false;
    }

    @Override
    public boolean add(String key, Object value) {
        return false;
    }

    @Override
    public boolean add(String key, Object value, int expiry) {
        return false;
    }

    @Override
    public boolean set(String key, Object value) {
        return false;
    }

    @Override
    public boolean set(String key, Object value, int expiry) {
        return false;
    }

    @Override
    public <T> T get(String key) {
        return null;
    }

    @Override
    public boolean delete(String key) {
        return false;
    }

    @Override
    public boolean exists(String key) {
        return false;
    }

    @Override
    public Object[] getMultiArray(String[] sKeys) {
        return new Object[0];
    }

    @Override
    public Map<String, Object> getMulti(String[] sKeys) {
        return null;
    }

    @Override
    public boolean flushAll() {
        return false;
    }

    /**
     * @param key
     * @Description: 获取过期时间，单位为（s）
     * @param: [key]
     * @return: long
     * @Date: 2018/12/27 13:33
     */
    @Override
    public long ttl(String key) {
        return 0;
    }

    /**
     * @param key
     * @param score
     * @param value
     * @param expire
     * @Description: 添加sortedSet
     * @param: [key, score, value, expire]
     * @return: boolean
     * @Date: 2018/12/27 13:41
     */
    @Override
    public boolean zadd(String key, Double score, String value, int expire) {
        return false;
    }

    /**
     * @param key
     * @Description: 获取sortedSet
     * @param: [key]
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     * @Date: 2018/12/27 14:36
     */
    @Override
    public Map<Double, String> getSortedSet(String key) {
        return null;
    }

    /**
     * @param key
     * @Description: 获取sortedSet中值的数量
     * @param: [key]
     * @return: long
     * @Date: 2018/12/27 14:47
     */
    @Override
    public long getSortedSetCount(String key) {
        return 0;
    }

    /**
     * 添加一条记录 如果map_key存在 则更新value
     * hset 如果哈希表不存在，一个新的哈希表被创建并进行 HSET 操作。
     * 如果字段已经存在于哈希表中，旧值将被覆盖
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    @Override
    public long setHash(String key, String field, String value) {
        return 0;
    }

    /**
     * 批量添加记录
     * hmset 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * 此命令会覆盖哈希表中已存在的域。
     * 如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作。
     *
     * @param key
     * @param map
     * @return
     */
    @Override
    public String setHashes(String key, Map<String, String> map) {
        return null;
    }

    /**
     * 删除hash中 field对应的值
     * hdel 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略
     *
     * @param key
     * @param field
     * @return
     */
    @Override
    public long deleteHashField(String key, String... field) {
        return 0;
    }

    /**
     * 获取hash中 指定的field的值
     * hmget 返回哈希表 key 中，一个或多个给定域的值。
     * 如果给定的域不存在于哈希表，那么返回一个 nil 值。
     * 不存在的 key 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 HMGET 操作将返回一个只带有 nil 值的表。
     *
     * @param key
     * @param field
     * @return
     */
    @Override
    public List<String> getTargetHash(String key, String... field) {
        return null;
    }

    /**
     * 获取hash中 所有的field value
     *
     * @param key
     * @return
     */
    @Override
    public Map<String, String> getAllHash(String key) {
        return null;
    }

    /**
     * 判断hash中 指定的field是否存在
     *
     * @param key
     * @param field
     * @return
     */
    @Override
    public boolean ifExistInHash(String key, String field) {
        return false;
    }

    /**
     * 获取hash 的size
     * hlen 获取哈希表中字段的数量
     *
     * @param key
     * @return
     */
    @Override
    public long getHashSize(String key) {
        return 0;
    }
}

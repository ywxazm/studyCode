package com.ymj.jedis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.jedis.util
 * @date 2020/9/16 9:34
 */
@Service
public class RedisServer {
    
    @Autowired
    private Jedis jedis;

    /**
     * 获取指定key的值,如果key不存在返回null，如果该Key存储的不是字符串，会抛出一个错误
     */
    public String get(String key) {
        return jedis.get(key);
    }

    /**
     * 设置key的值为value
     */
    public String set(String key, String value) {
        return jedis.set(key, value);
    }

    /**
     * 删除指定的key,也可以传入一个包含key的数组
     */
    public Long del(String... keys) {
        return jedis.del(keys);
    }

    /**
     * 通过key向指定的value值追加值
     */
    public Long append(String key, String str) {
        return jedis.append(key, str);
    }

    /**
     * 判断key是否存在
     */
    public Boolean exists(String key) {
        return jedis.exists(key);
    }

    /**
     * 设置key value,如果key已经存在则返回0
     */
    public Long setnx(String key, String value) {
        return jedis.setnx(key, value);
    }

    /**
     * 设置key value并指定这个键值的有效期
     */
    public String setex(String key, int seconds, String value) {
        return jedis.setex(key, seconds, value);
    }

    /**
     * 通过key 和offset 从指定的位置开始将原先value替换
     */
    public Long setrange(String key, int offset, String str) {
        return jedis.setrange(key, offset, str);
    }

    /**
     * 通过批量的key获取批量的value
     */
    public List<String> mget(String... keys) {
        return jedis.mget(keys);
    }

    /**
     * 批量的设置key:value,也可以一个
     */
    public String mset(String... keysValues) {
        return jedis.mset(keysValues);
    }

    /**
     * 批量的设置key:value,可以一个,如果key已经存在则会失败,操作会回滚
     */
    public Long msetnx(String... keysValues) {
        return jedis.msetnx(keysValues);
    }

    /**
     * 设置key的值,并返回一个旧值
     */
    public String getSet(String key, String value) {
        return jedis.getSet(key, value);
    }

    /**
     * 通过下标 和key 获取指定下标位置的 value
     */
    public String getrange(String key, int startOffset, int endOffset) {
        return jedis.getrange(key, startOffset, endOffset);
    }

    /**
     * 通过key 对value进行加值+1操作,当value不是int类型时会返回错误,当key不存在是则value为1
     */
    public Long incr(String key) {
        return jedis.incr(key);
    }

    /**
     * 通过key给指定的value加值,如果key不存在,则这是value为该值
     */
    public Long incrBy(String key, long integer) {
        return jedis.incrBy(key, integer);
    }

    /**
     * 对key的值做减减操作,如果key不存在,则设置key为-1
     */
    public Long decr(String key) {
        return jedis.decr(key);
    }

    /**
     * 减去指定的值
     */
    public Long decrBy(String key, long integer) {
        return jedis.decrBy(key, integer);
    }

    /**
     * 通过key获取value值的长度
     */
    public Long strLen(String key) {
        return jedis.strlen(key);
    }

    /**
     * 通过key给field设置指定的值,如果key不存在则先创建,如果field已经存在,返回0
     */
    public Long hsetnx(String key, String field, String value) {
        return jedis.hsetnx(key, field, value);
    }

    /**
     * 通过key给field设置指定的值,如果key不存在,则先创建
     */
    public Long hset(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    /**
     * 通过key同时设置 hash的多个field
     */
    public String hmset(String key, Map<String, String> hash) {
        return jedis.hmset(key, hash);
    }

    /**
     * 通过key 和 field 获取指定的 value
     */
    public String hget(String key, String failed) {
        return jedis.hget(key, failed);
    }

    /**
     * 设置key的超时时间为seconds
     */
    public Long expire(String key, int seconds) {
        return jedis.expire(key, seconds);
    }

    /**
     * 通过key 和 fields 获取指定的value 如果没有对应的value则返回null
     */
    public List<String> hmget(String key, String... fields) {
        return jedis.hmget(key, fields);
    }

    /**
     * 通过key给指定的field的value加上给定的值
     */
    public Long hincrby(String key, String field, Long value) {
        return jedis.hincrBy(key, field, value);
    }

    /**
     * 通过key和field判断是否有指定的value存在
     */
    public Boolean hexists(String key, String field) {
        return jedis.hexists(key, field);
    }

    /**
     * 通过key返回field的数量
     */
    public Long hlen(String key) {
        return jedis.hlen(key);
    }

    /**
     * 通过key 删除指定的 field
     */
    public Long hdel(String key, String... fields) {
        return jedis.hdel(key, fields);
    }

    /**
     * 通过key返回所有的field
     */
    public Set<String> hkeys(String key) {
        return jedis.hkeys(key);
    }

    /**
     * 通过key返回所有和key有关的value
     */
    public List<String> hvals(String key) {
        return jedis.hvals(key);
    }

    /**
     * 通过key获取所有的field和value
     */
    public Map<String, String> hgetAll(String key) {
        return jedis.hgetAll(key);
    }

    /**
     * 通过key向list头部添加字符串
     */
    public Long lpush(String key, String... strs) {
        return jedis.lpush(key, strs);
    }

    /**
     * 通过key向list尾部添加字符串
     */
    public Long rpush(String key, String... strs) {
        return jedis.rpush(key, strs);
    }

    /**
     * 通过key在list指定的位置之前或者之后 添加字符串元素
     */
    /*public Long linsert(String key, BinaryClient.LIST_POSITION where,
                        String pivot, String value) {
        return jedis.linsert(key, where, pivot, value);
    }*/

    /**
     * 通过key设置list指定下标位置的value
     * 如果下标超过list里面value的个数则报错
     */
    public String lset(String key, Long index, String value) {
        return jedis.lset(key, index, value);
    }

    /**
     * 通过key从对应的list中删除指定的count个 和 value相同的元素
     */
    public Long lrem(String key, long count, String value) {
        return jedis.lrem(key, count, value);
    }

    /**
     * 通过key保留list中从strat下标开始到end下标结束的value值
     */
    public String ltrim(String key, long start, long end) {
        return jedis.ltrim(key, start, end);
    }

    /**
     * 通过key从list的头部删除一个value,并返回该value
     */
    public synchronized String lpop(String key) {
        return jedis.lpop(key);
    }

    /**
     * 通过key从list尾部删除一个value,并返回该元素
     */
    synchronized public String rpop(String key) {
        return jedis.rpop(key);
    }

    /**
     * 通过key从一个list的尾部删除一个value并添加到另一个list的头部,并返回该value
     * 如果第一个list为空或者不存在则返回null
     */
    public String rpoplpush(String srckey, String dstkey) {
        return jedis.rpoplpush(srckey, dstkey);
    }

    /**
     * 通过key获取list中指定下标位置的value
     */
    public String lindex(String key, long index) {
        return jedis.lindex(key, index);
    }

    /**
     * 通过key返回list的长度
     */
    public Long llen(String key) {
        return jedis.llen(key);
    }

    /**
     * 通过key获取list指定下标位置的value
     * 如果start 为 0 end 为 -1 则返回全部的list中的value
     */
    public List<String> lrange(String key, long start, long end) {
        
        return jedis.lrange(key, start, end);
    }

    /**
     * 通过key向指定的set中添加value
     */
    public Long sadd(String key, String... members) {
        return jedis.sadd(key, members);
    }

    /**
     * 通过key删除set中对应的value值
     */
    public Long srem(String key, String... members) {
        return jedis.srem(key, members);
    }

    /**
     * 通过key随机删除一个set中的value并返回该值
     */
    public String spop(String key) {
        
        return jedis.spop(key);
    }

    /**
     * 通过key获取set中的差集
     * 以第一个set为标准
     */
    public Set<String> sdiff(String... keys) {
        return jedis.sdiff(keys);
    }

    /**
     * 通过key获取set中的差集并存入到另一个key中
     * 以第一个set为标准
     */
    public Long sdiffstore(String dstkey, String... keys) {
        return jedis.sdiffstore(dstkey, keys);
    }

    /**
     * 通过key获取指定set中的交集
     */
    public Set<String> sinter(String... keys) {
        return jedis.sinter(keys);
    }

    /**
     * 通过key获取指定set中的交集 并将结果存入新的set中
     */
    public Long sinterstore(String dstkey, String... keys) {
        return jedis.sinterstore(dstkey, keys);
    }

    /**
     * 通过key返回所有set的并集
     */
    public Set<String> sunion(String... keys) {
        return jedis.sunion(keys);
    }

    /**
     * 通过key返回所有set的并集,并存入到新的set中
     */
    public Long sunionstore(String dstkey, String... keys) {
        return jedis.sunionstore(dstkey, keys);
    }

    /**
     * 通过key将set中的value移除并添加到第二个set中
     */
    public Long smove(String srckey, String dstkey, String member) {
        return jedis.smove(srckey, dstkey, member);
    }

    /**
     * 通过key获取set中value的个数
     */
    public Long scard(String key) {
        return jedis.scard(key);
    }

    /**
     * 通过key判断value是否是set中的元素
     */
    public Boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }

    /**
     * 通过key获取set中随机的value,不删除元素
     */
    public String srandmember(String key) {
        return jedis.srandmember(key);
    }

    /**
     * 通过key获取set中所有的value
     */
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }


    /**
     * 通过key向zset中添加value,score,其中score就是用来排序的
     * 如果该value已经存在则根据score更新元素
     */
    public Long zadd(String key, double score, String member) {
        return jedis.zadd(key, score, member);
    }

    /**
     * 通过key删除在zset中指定的value
     */
    public Long zrem(String key, String... members) {
        return jedis.zrem(key, members);
    }

    /**
     * 通过key增加该zset中value的score的值
     */
    public Double zincrby(String key, double score, String member) {
        return jedis.zincrby(key, score, member);
    }

    /**
     * 通过key返回zset中value的排名
     * 下标从小到大排序
     */
    public Long zrank(String key, String member) {
        return jedis.zrank(key, member);
    }

    /**
     * 通过key返回zset中value的排名
     * 下标从大到小排序
     */
    public Long zrevrank(String key, String member) {
        return jedis.zrevrank(key, member);
    }

    /**
     * 通过key将获取score从start到end中zset的value
     * socre从大到小排序
     * 当start为0 end为-1时返回全部
     */
    public Set<String> zrevrange(String key, long start, long end) {
        return jedis.zrevrange(key, start, end);
    }

    /**
     * 通过key返回指定score内zset中的value
     */
    public Set<String> zrangeByScore(String key, double min, double max) {
        return jedis.zrevrangeByScore(key, max, min);
    }

    /**
     * 返回指定区间内zset中value的数量
     */
    public Long zcount(String key, String min, String max) {
        return jedis.zcount(key, min, max);
    }

    /**
     * 通过key返回zset中的value个数
     */
    public Long zcard(String key) {
        return jedis.zcard(key);
    }

    /**
     * 通过key获取zset中value的score值
     */
    public Double zscore(String key, String member) {
        return jedis.zscore(key, member);
    }

    /**
     * 通过key删除给定区间内的元素
     */
    public Long zremrangeByRank(String key, long start, long end) {
        return jedis.zremrangeByRank(key, start, end);
    }

    /**
     * 通过key删除指定score内的元素
     */
    public Long zremrangeByScore(String key, double start, double end) {
        return jedis.zremrangeByScore(key, start, end);
    }

    /**
     * 返回满足pattern表达式的所有key
     * keys(*)
     * 返回所有的key
     */
    public Set<String> keys(String pattern) {
        return jedis.keys(pattern);
    }

    /**
     * 通过key判断值得类型
     */
    public String type(String key) {
        return jedis.type(key);
    }
}
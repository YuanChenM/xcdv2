package com.framework.cache.map;

import com.framework.cache.Cache;
import com.framework.cache.bean.CacheEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 本地缓存实现.
 * @author jiang_nan
 * @version 1.0
 */
public class LocalCache implements Cache<String,Object>{
    /**Logger*/
    private static Logger logger = LoggerFactory.getLogger(LocalCache.class);
    /**默认缓存容器大小:100*/
    private final static int DEFAULT_INITIAL_CAPACITY = 100;
    /**最大缓存大小:100000*/
    private final static int DEFAULT_MAX_CAPACITY = 100000;
    /**本地缓存存储对象*/
    private LRUHashMap<String,CacheEntity<String,Object>> cacheMap;
    /**缓存处理定时器*/
    private Timer timer = new Timer();

    /**
     * 默认构造函数
     */
    public LocalCache(){
        this(DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_CAPACITY);
        logger.info("初始化本地缓存大小为{},最大缓存容器大小{}",DEFAULT_INITIAL_CAPACITY,DEFAULT_MAX_CAPACITY);
    }

    /**
     * 设置初始缓存容量和最大缓存容量的构造函数
     * @param initialCapacity 缓存初始化大小
     * @param maxCapacity 最大缓存大小
     */
    public LocalCache(int initialCapacity,int maxCapacity){
        this.cacheMap = new LRUHashMap<>(initialCapacity,maxCapacity);
    }

    /**
     * 获取缓存数据
     *
     * @param key 缓存Key
     * @return 缓存Value
     */
    @Override
    public Object get(String key) {
        return cacheMap.get(key);
    }

    /**
     * 新增缓存数据
     *
     * @param key         缓存Key
     * @param value       缓存Value
     * @param milliSecond 缓存生命周期(毫秒)
     */
    @Override
    public void put(String key, Object value, long milliSecond) {
        CacheEntity<String,Object> cacheEntity = new CacheEntity<>(key,value,milliSecond);
        this.cacheMap.put(key,cacheEntity);
        TimeoutTask timeoutTask = new TimeoutTask(key);
        logger.info("定时清除时间:{}秒",cacheEntity.getValidityTime());
        timer.schedule(timeoutTask,cacheEntity.getValidityTime()*1000);
    }

    /**
     * 新增多条数据
     * @param values 缓存Values
     */
    @Override
    public void putAll(Map<? extends String, ?> values) {

    }

    /**
     * 获取缓存长度
     *
     * @return 获得缓存对象列表
     */
    @Override
    public long size() {
        return this.cacheMap.size();
    }

    /**
     * 清空缓存
     */
    @Override
    public void clean() {
        this.cacheMap.clear();
    }

    /**
     * 移除缓存
     *
     * @param key 缓存Key
     */
    @Override
    public void remove(String key) {
        this.cacheMap.remove(key);
    }

    /**
     * 移除缓存集合
     *
     * @param collection 缓存Key集合
     */
    @Override
    public void remove(Collection<? extends String> collection) {
        for (String key: collection) {
            remove(key);
        }
    }

    /**
     * 判断缓存是否存在
     *
     * @param key 缓存Key
     * @return 是否已经存在True, False
     */
    @Override
    public boolean containCache(String key) {
        return this.cacheMap.containsKey(key);
    }

    /**
     * 缓存超时Task
     * @author jiang_nan
     * @version 1.0
     */
    final class TimeoutTask extends TimerTask{
        /**缓存Key*/
        private String key;

        /**
         *
         * @param key
         */
        public TimeoutTask(String key){
            this.key = key;
        }

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            logger.info("定时器删除数据,key:{}",key);
            remove(key);
        }
    }

}

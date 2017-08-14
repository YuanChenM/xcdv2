package com.framework.cache.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU是Least Recently Used.<br/>
 * 内存管理的一种页面置换算法<br/>
 * 对于在内存中但又不用的数据块（内存块）叫做LRU<br/>
 * 操作系统会根据哪些数据属于LRU而将其移出内存而腾出空间来加载另外的数据。
 * @param <K> Key
 * @param <V> Value
 */
public class LRUHashMap<K, V> extends ConcurrentHashMap<K, V> {

    /** 默认最大缓存数量 */
    private static final int DEFAULT_MAX_ENTRIES = 100;
    /**默认Map中容量*/
    private static final int DEFAULT_CAPACITY = 16;
    /**Map中最大容量*/
    private final int maxCapacity;
    /** 是否允许自动移除比较旧的元素(添加元素时) */
    private boolean enableRemoveEldestEntry = true;

    /**
     * 默认构造函数,设置缓存默认容量为16.
     */
    public LRUHashMap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 创建一个带有指定初始容量的新的空映射。
     * @param initialCapacity 初始化容量
     */
    public LRUHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_ENTRIES);
    }

    /**
     * 创建一个带有指定初始容量和最大容量的空映射
     * @param initialCapacity 初始容量
     * @param maxCapacity 最大容量
     */
    public LRUHashMap(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        this.maxCapacity = maxCapacity;
    }

    /**
     * 创建一个带有指定初始容量和最大容量的空映射<br/>
     * 否允许自动移除比较旧的元素.
     * @param initialCapacity 初始容量
     * @param maxCapacity 最大容量
     * @param enableRemoveEldestEntry 否允许自动移除比较旧的元素
     */
    public LRUHashMap(int initialCapacity, int maxCapacity, boolean enableRemoveEldestEntry) {
        this(initialCapacity, maxCapacity);
        this.enableRemoveEldestEntry = enableRemoveEldestEntry;
    }

    /**
     * 是否Remove旧的元素
     * @return True:移除 False:不移除
     */
    protected boolean removeEldestEntry() {
        return enableRemoveEldestEntry && (size() > maxCapacity);
    }

    /**
     * 将指定键映射到此表中的指定值。键和值都不可以为 null。<br/>
     * 通过使用与原来的键相同的键调用 get 方法，可以获取相应的值。
     * 
     * @param key 指定值相关联的键
     * @param value 指定键相关联的值
     * @return 以前与 key 相关联的值，如果 key 没有映射关系，则返回 null
     * @throws NullPointerException 如果指定键或值为 null
     */
    @Override
    public V put(K key, V value) {
        if(this.removeEldestEntry()){
            //TODO 考虑移除旧数据
        }
        return super.put(key, value);
    }

}

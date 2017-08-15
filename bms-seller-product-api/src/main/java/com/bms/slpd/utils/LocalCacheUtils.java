package com.bms.slpd.utils;

import com.framework.cache.CacheManager;
import com.framework.cache.InitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 管理缓存，提供生成、添加、获取缓存数据的方法，可以批量操作
 */
public class LocalCacheUtils {
	private static final Logger logger = LoggerFactory.getLogger(LocalCacheUtils.class);

	/**
	 * 生成缓存数据
	 */
	public static void cache(InitListener initializer) {
		logger.info("开始缓存数据......");
		long start = System.currentTimeMillis();
		CacheManager cacheManager = CacheManager.getInstance();
		cacheManager.init(initializer);
		long end = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder().append("缓存数据完成，耗时").append(end - start).append("毫秒。");
		logger.info(builder.toString());
	}
	
	/**
	 * 异步生成缓存数据
	 */
	public static void asyncCache(final InitListener initializer) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				cache(initializer);
			}
		};
		Thread thread = new Thread(runnable);
        thread.start();
	}
	
	/**
	 * 从缓存中获取一条数据
	 */
	public static Object get(String key) {
		CacheManager cacheManager = CacheManager.getInstance();
		return cacheManager.get(key);
	}
	
	/**
	 * 从缓存中获取批量数据
	 */
	public static List<Object> get(List<String> keys) {
		CacheManager cacheManager = CacheManager.getInstance();
		List<Object> objs = new ArrayList<>();
		for (String key : keys) {
			objs.add(cacheManager.get(key));
		}
		return objs;
	}
	
	/**
	 * 从缓存中获取批量数据
	 */
	public static Map<String, Object> find(List<String> keys) {
		CacheManager cacheManager = CacheManager.getInstance();
		Map<String, Object> map = new HashMap<>();
		for (String key : keys) {
			map.put(key, cacheManager.get(key));
		}
		return map;
	}

	/**
	 * 向缓存中添加一条数据
	 */
	public static void put(String key, Object value, long milliSecond) {
		CacheManager cacheManager = CacheManager.getInstance();
		cacheManager.removeListener();
		cacheManager.remove(key);
		cacheManager.putListener();
		cacheManager.put(key, value, milliSecond);
	}
	
	/**
	 * 向缓存中添加一条数据
	 */
	public static void put(String key, Object value) {
		put(key, value, 1471228928L);
	}
	
	/**
	 * 向缓存中添加批量数据
	 */
	public static void put(Map<String, Object> map) {
		CacheManager cacheManager = CacheManager.getInstance().putListener().removeListener();
		String key = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			key = entry.getKey();
			cacheManager.remove(key);
			cacheManager.put(key, entry.getValue());
		}
	}
	
}

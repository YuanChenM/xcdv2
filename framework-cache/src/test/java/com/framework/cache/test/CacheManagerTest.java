package com.framework.cache.test;

import com.framework.cache.CacheManager;
import org.junit.Test;

/**
 * Created by jackjiang on 16/11/7.
 */
public class CacheManagerTest {

    @Test
    public void putTest(){
        CacheManager cacheManager = CacheManager.getInstance().putListener();
        cacheManager.put("aaa","aaaa");
    }

    @Test
    public void getTest() {
        CacheManager cacheManager = CacheManager.getInstance().putListener();
        System.out.print(cacheManager.get("aaa"));
    }

    @Test
    public void removeTest() {
        CacheManager cacheManager = CacheManager.getInstance().putListener().removeListener();
        cacheManager.remove("aaa");
    }
    @Test
    public void timeoutRemoveTest(){
        CacheManager cacheManager = CacheManager.getInstance().putListener().removeListener();
        cacheManager.put("bbb","bbb",10);
        cacheManager.put("ccc","bbb",10);
        cacheManager.put("ddd","bbb",10);
        cacheManager.put("eee","bbb",10);
        cacheManager.put("fff","bbb",10);
        try {
            Thread.sleep(1000*20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}

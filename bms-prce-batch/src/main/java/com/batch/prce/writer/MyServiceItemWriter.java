package com.batch.prce.writer;

import com.framework.boot.base.BaseService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by sunjiaju on 2017/2/16.
 */
public abstract class MyServiceItemWriter<O> implements ItemWriter<O>, InitializingBean {
    private BaseService baseService;

    public MyServiceItemWriter() {
    }

    public BaseService getBaseService() {
        return baseService;
    }

    public void setBaseService(BaseService baseService) {
        this.baseService = baseService;
    }

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(this.baseService);
    }

    public void write(List<? extends O> paramList) throws Exception {
        this.doWrite(paramList);
    }

    protected abstract void doWrite(List<? extends O> var1) throws Exception;
}

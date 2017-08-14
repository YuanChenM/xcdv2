package com.framework.batch.item.database;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.framework.base.dao.BaseDao;

/**
 * <p>Mybatis访问数据库的写接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class MybatisItemWriter<O> implements ItemWriter<O>, InitializingBean {
	private BaseDao baseDao;

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(baseDao);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void write(List<? extends O> paramList) throws Exception {
		this.doWrite((List<O>) paramList);
	}
	
	protected abstract void doWrite(List<O> items) throws Exception; 

}

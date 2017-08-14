package com.framework.batch.item.database;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.batch.item.database.AbstractPagingItemReader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import com.framework.base.dao.BaseDao;
import com.framework.batch.constant.BatchConstant;
import com.github.pagehelper.PageHelper;

/**
 * <p>Mybatis访问数据库的读接口。</p>
 *
 * @author xia_xiaojie
 * @date 2016/11/08
 * @version 1.0.0
 */
public abstract class MybatisItemReader<I> extends AbstractPagingItemReader<I> {
	private BaseDao baseDao;

	public MybatisItemReader() {
		super.setName(ClassUtils.getShortName(MybatisItemReader.class));
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	    super.afterPropertiesSet();
	    Assert.notNull(baseDao);
	}
	
	@Override
	protected void doReadPage() {
		if (results == null) {
			results = new CopyOnWriteArrayList<I>();
		}
		else {
			results.clear();
		}
		
		super.setPageSize(this.pageSize());
		PageHelper.startPage(super.getPage(), super.getPageSize());
		List<I> items = this.query();
		results.addAll(items);
	}
	
	protected int pageSize() {
		return BatchConstant.Items.PAGE_SIZE;
	}

	protected abstract List<I> query();

	@Override
	protected void doJumpToPage(int itemIndex) {
	}

}

package com.framework.resource.dao;

import java.util.List;

import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.resource.bean.param.PageResourceDocParam;

/**
 * Created by dai_youcheng on 2016-12-7.
 */
public interface PageResourceDao {
    /**
     * 新增画面资源
     * 
     * @param param
     * @return
     */
    void insert(PageResourceDoc param);

    /**
     * 删除画面资源
     * 
     * @param pageIdList
     * @return
     */
    int delete(List<String> pageIdList);

    /**
     * 更新画面资源
     * 
     * @param param
     * @return
     */
    int update(PageResourceDoc param);

    /**
     * 查询画面资源
     * 
     * @param request
     * @return
     */
    List<PageResourceDoc> findList(PageResourceDocParam request);

    Long findCount(PageResourceDocParam request);
}

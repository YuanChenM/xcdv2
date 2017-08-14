package com.framework.resource.service;

import java.util.List;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.resource.bean.entity.PageResourceDoc;
import com.framework.resource.bean.param.PageResourceDocParam;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
public interface PageResourceService {

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
    BaseRestPaginationResult<PageResourceDoc> findList(PageResourceDocParam request);
}

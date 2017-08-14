/*
 * 2017/04/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.linv.services;

import com.bms.linv.bean.param.LINV0104IParam;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>InvmLoadAlocInventoryService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface InvmLoadAlocInventoryService extends BaseService {

    @Transactional
    void cancelLoadAlocInvCounts(List<LINV0104IParam> param);
}
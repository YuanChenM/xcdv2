/*
 * 2017/03/16 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.puch.service;

import com.bms.puch.bean.param.PuchReceiveParam;
import com.bms.puch.bean.result.PuchReceiveXmlResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>PuchReceiveService接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface PuchReceiveService extends BaseService {

    @Transactional
    PuchReceiveXmlResult exceutePuchInfo(PuchReceiveParam param);

//    @Transactional
//    BaseRestPaginationResult<PuchReceiveRestResult> searchPuchReceive(PuchReceivePageParam param);
}
package com.bms.linv.services;

import com.bms.linv.bean.param.LINV0115IParam;
import com.bms.linv.bean.result.LINV0115IResult;
import com.framework.boot.base.BaseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
public interface InvmComoInvTransferCompleteService extends BaseService {

    /**
     * 库存划拨完成接口
     */
    @Transactional
    LINV0115IResult modifyComoInvTransferComplete(List<LINV0115IParam> param);

}

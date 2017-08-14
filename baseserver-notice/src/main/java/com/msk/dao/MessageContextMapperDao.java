package com.msk.dao;

import com.msk.bean.CreateNoticeBean;
import com.msk.bean.param.QueryNoticeSenderParam;
import com.msk.bean.result.SenderNoticeResult;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mao_yejun on 2016/10/12.
 */
@Mapper
public interface MessageContextMapperDao {
    int createMessageContext(CreateNoticeBean createNoticeBean);
    List<SenderNoticeResult> querySenderNoticeList(QueryNoticeSenderParam queryNoticeListParam);
}

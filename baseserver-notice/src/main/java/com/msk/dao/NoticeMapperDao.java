package com.msk.dao;

import com.msk.bean.result.NoticeResult;
import com.msk.bean.param.QueryNoticeDetailParam;
import com.msk.bean.param.QueryNoticeListParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by mao_yejun on 2016/10/13.
 */
@Mapper
public interface NoticeMapperDao {
    List<NoticeResult> queryNoticeList(QueryNoticeListParam queryNoticeListParam);
    NoticeResult queryNoticeDetail(QueryNoticeDetailParam queryNoticeDetailParam);
}

package com.msk.service;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.bean.param.*;
import com.msk.bean.result.NoticeResult;
import com.msk.bean.result.SenderNoticeResult;

/**
 * Created by mao_yejun on 2016/10/12.
 */
public interface NoticeService {

    public Boolean createNoticeByEmploy(CreateNoticeParam createNoticeByEmployParam);

    public BaseRestPaginationResult<NoticeResult> queryNoticeList(QueryNoticeListParam queryNoticeListParam);

    public NoticeResult queryNoticeDetail(QueryNoticeDetailParam queryNoticeDetailParamParam);

    public Boolean updateMessageRelationById(UpdateNoticeParam updateNoticeParam);

    public Boolean updateMessageRelationByEmploy(UpdateNoticeByEmployParam updateNoticeByEmployParam);

    public Boolean deleteNoticeById(DeleteNoticeParam deleteNoticeParam);

    public Boolean deleteNoticeByEmploy(DeleteNoticeByEmployParam deleteNoticeByEmployParam);

    public BaseRestPaginationResult<SenderNoticeResult> querySenderNoticeList(QueryNoticeSenderParam param);
}

package com.msk.rest;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.bean.param.QueryNoticeDetailParam;
import com.msk.bean.param.QueryNoticeListParam;
import com.msk.bean.param.QueryNoticeSenderParam;
import com.msk.bean.result.NoticeResult;
import com.msk.bean.result.SenderNoticeResult;
import com.msk.service.NoticeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mao_yejun on 2016/10/13.
 */
@RestController
@RequestMapping("api")
@Api(value = "Query-Api", description = "查询接口")
public class QueryNoticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 消息列表
     * @param queryNoticeListParam
     * @return
     */
    @RequestMapping(value = "notice/list/_query", method = RequestMethod.POST)
    public BaseRestPaginationResult<NoticeResult> queryNoticeList(@RequestBody QueryNoticeListParam queryNoticeListParam) {
       return  noticeService.queryNoticeList(queryNoticeListParam);
    }

    /**
     * 消息明细
     * @param queryNoticeDetailParam
     * @return
     */
    @RequestMapping(value = "notice/detail/_query",method = RequestMethod.POST)
    public NoticeResult queryNoticeDetail(@RequestBody QueryNoticeDetailParam queryNoticeDetailParam){
        return noticeService.queryNoticeDetail(queryNoticeDetailParam);
    }

    /**
     * 查询发送者发送的消息
     * @param noticeListParam
     * @return
     */
    @RequestMapping(value = "notice/sender/_query",method = RequestMethod.POST)
    public BaseRestPaginationResult<SenderNoticeResult> querySenderNoticeList(@RequestBody QueryNoticeSenderParam noticeListParam){
        return noticeService.querySenderNoticeList(noticeListParam);
    }
}

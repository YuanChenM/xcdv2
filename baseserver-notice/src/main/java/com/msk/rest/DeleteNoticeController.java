package com.msk.rest;

import com.msk.bean.param.DeleteNoticeByEmployParam;
import com.msk.bean.param.DeleteNoticeParam;
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
@Api(value = "Delete-Api", description = "消息删除")
public class DeleteNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "notice/_delete", method = RequestMethod.POST)
    public Boolean deleteNoticeById(@RequestBody DeleteNoticeParam deleteNoticeParam) {
        return noticeService.deleteNoticeById(deleteNoticeParam);
    }

    @RequestMapping(value = "notice/employ/_delete", method = RequestMethod.POST)
    public Boolean deleteNoticeByEmploy(@RequestBody DeleteNoticeByEmployParam deleteNoticeByEmployParam) {
       return noticeService.deleteNoticeByEmploy(deleteNoticeByEmployParam);
    }

}

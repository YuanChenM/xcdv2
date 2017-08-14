package com.msk.rest;

import com.msk.bean.param.UpdateNoticeByEmployParam;
import com.msk.bean.param.UpdateNoticeParam;
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
@Api(value = "Update-Api", description = "更新消息状态接口")
public class UpdateNoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "notice/_update", method = RequestMethod.POST)
    public Boolean updateNoticeByID(@RequestBody UpdateNoticeParam updateNoticeParam) {
        return noticeService.updateMessageRelationById(updateNoticeParam);
    }

    @RequestMapping(value = "notice/employ/_update", method = RequestMethod.POST)
    public Boolean updateNoticeByEmploy(@RequestBody UpdateNoticeByEmployParam updateNoticeByEmployParam) {
        return noticeService.updateMessageRelationByEmploy(updateNoticeByEmployParam);
    }
}

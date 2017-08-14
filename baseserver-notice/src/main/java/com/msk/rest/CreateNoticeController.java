package com.msk.rest;


import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.msk.bean.param.CreateNoticeParam;
import com.msk.bean.param.GroupUserParam;
import com.msk.bean.result.GroupUserResult;
import com.msk.service.NoticeService;
import com.msk.utils.RestUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mao_yejun on 2016/10/13.
 */
@RestController
@RequestMapping("api")
@Api(value = "Create-Api",description = "根据用户组或员工创建通知")
public class CreateNoticeController {
    private static Logger logger = LoggerFactory.getLogger(CreateNoticeController.class);
    @Autowired
    private NoticeService noticeService;
    @RequestMapping(value = "notice/employ/_create",method = {RequestMethod.POST})
    public Boolean createNoticeByEmploy(@RequestBody CreateNoticeParam createNoticeParam){
        List<String> receiverCodes = new ArrayList<>();
        // 若需要给某个用户组发消息
        if (CollectionUtils.isNotEmpty(createNoticeParam.getGroupCodes())){
            logger.info("根据用户组创建通知");
            GroupUserParam groupUserParam = new GroupUserParam();
            groupUserParam.setGroup(createNoticeParam.getGroupCodes());
            BaseRestPaginationResult<GroupUserResult> result =  RestUtils.getUserInfo(groupUserParam);
            if(null !=result && CollectionUtils.isNotEmpty(result.getData())){
                for (GroupUserResult groupUserResult: result.getData()){
                    receiverCodes.add(groupUserResult.getUserLogin());
                }
                createNoticeParam.setReceiverCodes(receiverCodes);
            }
        }
        return noticeService.createNoticeByEmploy(createNoticeParam);
    }

}

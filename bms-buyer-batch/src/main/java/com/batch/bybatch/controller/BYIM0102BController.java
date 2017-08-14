package com.batch.bybatch.controller;

import com.batch.bybatch.configer.job.BYIM0102BJobConfiger;
import com.framework.batch.core.support.SimpleJobExecutor;
import com.framework.exception.SystemException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuan_zhifei on 2017/6/1.
 */
@RestController
@Api(value = "BYIM0102BController-api",
        description = "买家池batch单独触发控制",
        tags = "BYIM0102BController")
@RequestMapping({ "api" })
public class BYIM0102BController {

    @Autowired
    private SimpleJobExecutor simpleJobExecutor;

    @Autowired
    private BYIM0102BJobConfiger byim0102BJobConfiger;

    @ApiOperation(value = "手动触发任务",
            notes = "手动触发任务",position = 1)
    @RequestMapping(value = "buyerPool/batch/test",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String doWork() {
        try {
            simpleJobExecutor.execute(byim0102BJobConfiger.Byim0102bJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "手动触发完毕";
    }
}

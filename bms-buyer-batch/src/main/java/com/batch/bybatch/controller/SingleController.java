package com.batch.bybatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.batch.bybatch.configer.job.BYIM0101BJobConfiger;
import com.framework.batch.core.support.SimpleJobExecutor;
import com.framework.exception.SystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@RestController
@Api(value = "SingleController-api",
    description = "batch单独触发控制",
    tags = "SingleController")
@RequestMapping({ "api" })
public class SingleController {

    @Autowired
    private SimpleJobExecutor simpleJobExecutor;

    @Autowired
    private BYIM0101BJobConfiger byim0101BJobConfiger;

    @ApiOperation(value = "手动触发任务",
        notes = "手动触发任务",position = 5)
    @RequestMapping(value = "/batch/test",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String doWork() {
        try {
            simpleJobExecutor.execute(byim0101BJobConfiger.Byim0101bJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "手动触发完毕";
    }
}

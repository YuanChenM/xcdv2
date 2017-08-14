package com.batch.order.controller;

import com.batch.order.configer.job.ORDR0302BJobConfiger;
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

@RestController
@Api(value = "ORDR0302BController-api",
        description = "生成配送通知数据batch",
        tags = "ORDR0302BController")
@RequestMapping({"api"})
public class ORDR0302BController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;


    @Autowired
    ORDR0302BJobConfiger ordr0302BJobConfiger;


    /**
     * 生产配送通知单数据
     *
     * @return
     */
    @ApiOperation(value = "ORDR0302BJob",
            notes = "ORDR0302BJob")
    @RequestMapping(value = "/batch/ORDR0302BJob",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    String ORDR0302BJob() {
        try {
            simpleJobExecutor.execute(ordr0302BJobConfiger.ORDR0302BJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "生产配送通知单数据Batch成功";
    }
}

package com.batch.order.controller;

import com.batch.order.configer.job.ORDR0302BJobConfiger;
import com.batch.order.configer.job.ORDR0303BJobConfiger;
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
@Api(value = "ORDR0303BController-api",
        description = "生成配送通知xml文件batch",
        tags = "ORDR0303BController")
@RequestMapping({"api"})
public class ORDR0303BController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;


    @Autowired
    ORDR0303BJobConfiger ordr0303BJobConfiger;


    /**
     * 生产配送通知单xml
     *
     * @return
     */
    @ApiOperation(value = "ORDR0303BJob",
            notes = "ORDR0303BJob")
    @RequestMapping(value = "/batch/ORDR0303BJob",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    String ORDR0303BJob() {
        try {
            simpleJobExecutor.execute(ordr0303BJobConfiger.ORDR0303BJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "生产配送通知单xmlBatch成功";
    }
}

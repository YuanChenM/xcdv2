package com.batch.order.controller;

import com.batch.order.configer.job.ORDR0201BJobConfiger;
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
@Api(value = "ORDR0201BController-api",
        description = "分拆batch",
        tags = "ORDR0201BController")
@RequestMapping({"api"})
public class ORDR0201BController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;

    @Autowired
    ORDR0201BJobConfiger ordr0201BJobConfiger;

    /**
     * 分拆
     *
     * @return
     */
    @ApiOperation(value = "ORDR0201BJob",
            notes = "ORDR0201BJob")
    @RequestMapping(value = "/batch/ORDR0201BJob",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    String ORDR0201BJob() {
        try {
            simpleJobExecutor.execute(ordr0201BJobConfiger.ORDR0201BJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "分拆batch成功";
    }
}

package com.batch.order.controller;

import com.batch.order.configer.job.ORDR0801BJobConfiger;
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
@Api(value = "ORDR0801BController-api",
        description = "生成退货入库单xml文件batch",
        tags = "ORDR0801BController")
@RequestMapping({"api"})
public class ORDR0801BController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;


    @Autowired
    ORDR0801BJobConfiger ordr0801BJobConfiger;


    /**
     * 退货入库单
     *
     * @return
     */
    @ApiOperation(value = "ORDR0801BJob",
            notes = "ORDR0801BJob")
    @RequestMapping(value = "/batch/ORDR0801BJob",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    String ORDR0801BJob() {
        try {
            simpleJobExecutor.execute(ordr0801BJobConfiger.ORDR0801BJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "退货入库单batch成功";
    }
}

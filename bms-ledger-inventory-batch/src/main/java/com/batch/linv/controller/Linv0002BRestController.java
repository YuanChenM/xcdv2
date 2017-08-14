package com.batch.linv.controller;

import com.batch.linv.configer.job.SynWmsInvJobConfiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.batch.linv.configer.job.SynInvJobConfiger;
import com.framework.batch.core.support.SimpleJobExecutor;
import com.framework.exception.SystemException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "linv0001BRestController-api",
    description = "同步WMS库存",
    tags = "linv0001BRestController")
@RequestMapping({"api"})
public class Linv0002BRestController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;

    @Autowired
    SynWmsInvJobConfiger linv0002BJobConfiger;

    /**
     * 库存WMS同步batch
     *
     * @return
     */
    @ApiOperation(value = "linv0001BJob", notes = "linv0001BJob")
    @RequestMapping(value = "/batch/linv0001BJob",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String Linv0002BJob() {
        try {
            simpleJobExecutor.execute(linv0002BJobConfiger.synWmsInvJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "同步WMS库存成功";
    }
}

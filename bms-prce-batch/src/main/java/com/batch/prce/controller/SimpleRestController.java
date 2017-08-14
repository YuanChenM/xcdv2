package com.batch.prce.controller;

import com.batch.prce.configer.job.PRCE0101BJobConfiger;
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
@Api(value = "SimpleRestController-api",
    description = "测试batch",
    tags = "SimpleRestController")
@RequestMapping({"api"})
public class SimpleRestController {

    @Autowired
    SimpleJobExecutor simpleJobExecutor;

    @Autowired
    PRCE0101BJobConfiger prce0101BJobConfiger;

    /**
     * 商品同步batch
     *
     * @return
     */
    @ApiOperation(value = "PRCE0101BJob",
        notes = "PRCE0101BJob")
    @RequestMapping(value = "/batch/PRCE0101BJob",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String PRCE0101BJob() {
        try {
            simpleJobExecutor.execute(prce0101BJobConfiger.PRCE0101BJob());
        } catch (Exception ex) {
            throw new SystemException(ex.getMessage());
        }
        return "测试同步batch成功";
    }
}

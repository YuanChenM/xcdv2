package com.batch.linv.controller;

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
@Api(value = "Linv0001BRestController-api",
    description = "测试batch",
    tags = "Linv0001BRestController")
@RequestMapping({"api"})
public class Linv0001BRestController {

//    @Autowired
//    SimpleJobExecutor simpleJobExecutor;
//
//    @Autowired
//    SynInvJobConfiger linv0001BJobConfiger;
//
//    /**
//     * 商品同步batch
//     *
//     * @return
//     */
//    @ApiOperation(value = "Linv0001BJob", notes = "Linv0001BJob")
//    @RequestMapping(value = "/batch/Linv0001BJob",
//        method = RequestMethod.POST,
//        produces = { MediaType.APPLICATION_JSON_VALUE })
//    public @ResponseBody String Linv0001BJob() {
//        try {
//            simpleJobExecutor.execute(linv0001BJobConfiger.synInvJob());
//        } catch (Exception ex) {
//            throw new SystemException(ex.getMessage());
//        }
//        return "测试同步batch成功";
//    }
}

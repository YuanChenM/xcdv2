package com.framework.authority.rest;

import java.util.List;

import com.framework.authority.entity.Test;
import com.framework.authority.service.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.base.bean.RestRequest;
import com.framework.base.bean.RestResponse;
import com.framework.base.controller.rest.BaseRestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Created by zhang_jian3 on 2016/10/26.
 */
@RestController
@Api(value = "test-api",
    description = "测试操作",
    position = 5,
    tags = "testRestController")
public class TestRestController extends BaseRestController {

    @Autowired
    TestServices testLogic;

    @ApiOperation(value = "测试add",
        notes = "测试add",
        position = 5)
    @RequestMapping(value = "/springboot/mongo/_add",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RestResponse<List<Test>> getAddOne(@RequestBody RestRequest<Test> request) {
        Test test = request.getParam();
        testLogic.save(test);
        RestResponse<List<Test>> restResponse = new RestResponse<>();
        restResponse.setStatus("S");
        restResponse.setMessage("新增成功");
        restResponse.setReturnCode("200");
        return restResponse;
    }

    @ApiOperation(value = "测试load",
        notes = "测试load",
        position = 5)
    @RequestMapping(value = "/springboot/mongo/_select",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RestResponse<List<Test>> getLoadOne() {
        RestResponse<List<Test>> restResponse = new RestResponse<>();
        restResponse.setStatus("S");
        restResponse.setMessage("查询成功");
        restResponse.setResult(testLogic.findList(0, 0));
        restResponse.setReturnCode("200");
        return restResponse;
    }
}

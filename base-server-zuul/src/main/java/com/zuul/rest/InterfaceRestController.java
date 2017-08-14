package com.zuul.rest;

import com.zuul.bean.PageResult;
import com.zuul.bean.param.*;
import com.zuul.bean.result.UserAuthResult;
import com.zuul.entity.InterfaceEntity;
import com.zuul.logic.InterfaceLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by mao_yejun on 2017/2/27.
 */
@RestController
@RequestMapping("/api")
@Api(value = "interface-api",
        description = "接口-api")
public class InterfaceRestController {
    @Autowired
    private InterfaceLogic interfaceLogic;

    @RequestMapping(value = "/interface/_create",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "新建接口")
    public boolean createInterface(@RequestBody InterfaceCreateParam param) {
        interfaceLogic.createInterface(param);
        return true;
    }

    @RequestMapping(value = "/interface/_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "删除接口")
    public boolean deleteInterface(@RequestBody ArrayList<Long> param) {

        return interfaceLogic.deleteInterface(param);
    }

    @RequestMapping(value = "interface/detail/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public InterfaceEntity searchInterfaceDetail(@RequestBody Long interfaceDetailId) {
        return interfaceLogic.searchInterfaceDetail(interfaceDetailId);
    }

    @RequestMapping(value = "interface/detail/_update",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUserDetail(@RequestBody UpdateInterfaceParam param) {
        return interfaceLogic.updateInterface(param);
    }

    @RequestMapping(value = "auth/none/interface/_search",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResult<UserAuthResult> searchNoAuthInterface(@RequestBody UserNoneAuthSearchParam param) {
        return interfaceLogic.searchNoAuthInterface(param);
    }
}

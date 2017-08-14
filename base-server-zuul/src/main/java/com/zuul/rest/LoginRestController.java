package com.zuul.rest;

import com.zuul.bean.RestResponse;
import com.zuul.bean.param.UserLoginParam;
import com.zuul.bean.result.UserLoginResult;
import com.zuul.logic.UserLogic;
import com.zuul.repository.UserEntityRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mao_yejun on 2017/2/21.
 */
@RestController
@Api(value = "node-api",
        description = "登陆接口")
@RequestMapping(value = "/api")
public class LoginRestController {
    @Autowired
    private UserLogic userLogic;
    @Autowired
    private UserEntityRepository userEntityRepository;

    @RequestMapping(value = "/user/_login",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "登陆接口")
    public RestResponse<UserLoginResult> userLogin(@RequestBody UserLoginParam param) {
        if(StringUtils.isEmpty(param.getLoginId()) || StringUtils.isEmpty(param.getPassword())){
            RestResponse<UserLoginResult> response = new RestResponse<>();
            response.setMessage("用户名或密码不能为空！");
            response.setReturnCode("F");
            return  response;
        }
        return userLogic.userLogin(param);
    }
}

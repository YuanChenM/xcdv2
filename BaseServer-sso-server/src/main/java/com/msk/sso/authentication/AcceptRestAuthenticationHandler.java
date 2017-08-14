package com.msk.sso.authentication;

import java.security.GeneralSecurityException;
import java.util.List;

import javax.security.auth.login.FailedLoginException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.TypeReference;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.comm.bean.NewLoginParam;
import com.msk.comm.constant.Constant;
import com.msk.comm.utils.ConfigInfo;
import com.msk.comm.utils.Md5Digest;
import com.msk.comm.utils.RestNewClientUtil;

/**
 * Created by zhangjian3 on 16/11/30.
 */
public class AcceptRestAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {

    public static final Logger logger = LoggerFactory.getLogger(AcceptRestAuthenticationHandler.class);

    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential credential)
        throws GeneralSecurityException, PreventedException {
        RestLoginCredential restLoginCredential = (RestLoginCredential) credential;
        final String username = credential.getUsername();
        final String userType = restLoginCredential.getUserType();
        final String password = credential.getPassword();
        NewLoginParam loginParam = new NewLoginParam();
        loginParam.setUserLogin(username);
        loginParam.setUserPwd(Md5Digest.digest(password));
        loginParam.setUserType(userType);

        ConfigInfo configInfo = ConfigInfo.newConfigInfo();
        String apiUrl = configInfo.getZuul() + "/" + Constant.ApiUrl.MODEL_NAME + "/" + Constant.ApiUrl.USER_SEARCH;
        BaseRestPaginationResult<NewLoginParam> loginUserResponse = RestNewClientUtil.post(apiUrl, loginParam,
            new TypeReference<BaseRestPaginationResult<NewLoginParam>>() {});
        List<NewLoginParam> result = loginUserResponse.getData();
        if (null == result || result.size() == 0) {
            throw new FailedLoginException();
        }
        return createHandlerResult(restLoginCredential, new SimplePrincipal(username + " " + userType), null);
    }

    // private String getLoginRestfulServerUrl() {
    // ConfigInfo configInfo = ConfigInfo.newConfigInfo();
    // String loginModuleName = configInfo.getLoginModuleName();
    // String loginServerName = configInfo.getLoginServerName();
    // ConfigParam param = new ConfigParam();
    // param.setEnvironment(configInfo.getEnvironment());
    // param.setType("ConfigConstant");
    // param.setModelName(loginModuleName);
    // param.setKey(loginServerName);
    //
    // RestRequest<ConfigParam> requestBody = new RestRequest<>();
    // requestBody.setParam(param);
    // String configConstantUrl = configInfo.getConfigServerUrl() + configInfo.getConfigLoadConfigConstant();
    // RestResponse<HashMap<String, Object>> responseBody = RestClientUtil.post(configConstantUrl, requestBody,
    // new TypeReference<RestResponse<HashMap<String, Object>>>() {});
    // HashMap<String, Object> result = responseBody.getResult();
    // String baseUrl = (String) result.get(configInfo.getEnvironment());
    // String moduleUrl = (String) result.get(loginModuleName);
    // String apiUrl = (String) result.get(loginServerName);
    // return baseUrl + moduleUrl + apiUrl;
    // return "";
    // }

}

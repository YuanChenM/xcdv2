package com.msk.sso.client.utils;

import com.alibaba.fastjson.TypeReference;
//import com.msk.org.bean.LoginUserType;
//import com.msk.org.bean.param.LoginParam;
import com.msk.sso.client.bean.RestRequest;
import com.msk.sso.client.bean.RestResponse;
import com.msk.sso.client.bean.param.SellerLoginParam;
import com.msk.sso.client.constant.SSORelevanceDefine;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.authentication.AuthenticationFilter;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


public final class AssertionUtils {
    public static String SSO_USER_INFO_MAP_USER_NAME_KEY = "userName";
    public static String SSO_USER_INFO_MAP_USER_TYPE_KEY = "userType";



    public static Assertion getAssertion(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Assertion assertion = session != null ? (Assertion) session.getAttribute(AuthenticationFilter.CONST_CAS_ASSERTION) : null;
        return assertion;
    }

    public static Assertion getAssertion(HttpSession session){
        Assertion assertion = session != null ? (Assertion) session.getAttribute(AuthenticationFilter.CONST_CAS_ASSERTION) : null;
        return assertion;
    }
    public static Map<String,String> getSsoUserInfo(Assertion assertion){
        Map<String,String> ssoUserInfoMap = new HashMap<>();
        if(assertion == null){
            return ssoUserInfoMap;
        }
        AttributePrincipal principal = getAttributePrincipal(assertion);
        String ssoId = principal.getName();
        String [] ssoIdSplit = ssoId.split(" ");
        String userName = ssoIdSplit[0];
        String userType = ssoIdSplit[1];
        ssoUserInfoMap.put(SSO_USER_INFO_MAP_USER_NAME_KEY,userName);
        ssoUserInfoMap.put(SSO_USER_INFO_MAP_USER_TYPE_KEY,userType);
        return ssoUserInfoMap;
    }


    public static AttributePrincipal getAttributePrincipal(Assertion assertion){
        return assertion.getPrincipal();
    }

    public static Map<String,String> getSsoUserInfo(HttpServletRequest request){
        Map<String,String> ssoUserInfoMap = new HashMap<>();
        Assertion assertion = getAssertion(request);
        if(assertion == null){
            return ssoUserInfoMap;
        }
        AttributePrincipal principal = getAttributePrincipal(assertion);
        String ssoId = principal.getName();
        String [] ssoIdSplit = ssoId.split(" ");
        String userName = ssoIdSplit[0];
        String userType = ssoIdSplit[1];
        ssoUserInfoMap.put(SSO_USER_INFO_MAP_USER_NAME_KEY,userName);
        ssoUserInfoMap.put(SSO_USER_INFO_MAP_USER_TYPE_KEY,userType);
        return ssoUserInfoMap;
    }

    public static Map<String,Object> getLoginUserInfo(Map<String,String> ssoUserInfoMap){
        String userName = ssoUserInfoMap.get(SSO_USER_INFO_MAP_USER_NAME_KEY);
        String userType = ssoUserInfoMap.get(SSO_USER_INFO_MAP_USER_TYPE_KEY);
        String loginUserInfoServerUrl = null;
        RestResponse<Map<String,Object>> response = new RestResponse<Map<String,Object>>();
//        if(LoginUserType.getUserTypeEmploy().equals(userType)||LoginUserType.getUserTypeBank().equals(userType)){
//            LoginParam param = new LoginParam();
//            param.setUserName(userName);
//            param.setUserType(userType);
//            loginUserInfoServerUrl = SSORelevanceDefine.getLoginEmployInfoServerUrl();
//            RestRequest<LoginParam> requestBody = new RestRequest<>();
//            requestBody.setParam(param);
//            response = RestClientUtil.post(loginUserInfoServerUrl,requestBody,new TypeReference<RestResponse<Map<String,Object>>>(){});
//        } else if(LoginUserType.getUserTypeSeller().equals(userType)){
//            loginUserInfoServerUrl = SSORelevanceDefine.getLoginSellerInfoServerUrl();
//            SellerLoginParam param = new SellerLoginParam();
//            param.setSlAccount(userName);
//            RestRequest<SellerLoginParam> requestBody = new RestRequest<>();
//            requestBody.setParam(param);
//            requestBody.setAuth("ORG");
//            requestBody.setLoginId("ORG");
//            response = RestClientUtil.post(loginUserInfoServerUrl,requestBody,new TypeReference<RestResponse<Map<String, Object>>>(){});
//        }
//        else if(LoginUserType.getUserTypeBank().equals(userType)){
//            Map<String,Object> result = new HashMap<>();
//            result.put("employCode",userName);
//            result.put("employId",userName);
//            result.put("employCode",userName);
//            response.setResult(result);
//        }

        Map<String,Object> loginUserInfoMap = response.getResult();
        return loginUserInfoMap;
    }

}

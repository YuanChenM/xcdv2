package com.msk.sso.client.service.impl;

import com.alibaba.fastjson.TypeReference;
//import com.msk.org.bean.param.ModifyPasswordParam;
//import com.msk.org.entity.OrgEmploy;
import com.msk.sso.client.bean.RestRequest;
import com.msk.sso.client.bean.RestResponse;
import com.msk.sso.client.constant.SSORelevanceDefine;
import com.msk.sso.client.service.ModifyPasswordService;
import com.msk.sso.client.utils.Md5Digest;
//import org.springframework.util.StringUtils;

/**
 *
 * Created by shi_yuxi on 2016/9/27.
 */
public class EmployModifPasswordServiceImpl implements ModifyPasswordService {

    public static String errorMessage = "";
    private static final int maxPasswordLength = 6;
    private static final String passwordReg = ".*(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[~!@#$%^&*()_+{}|:\"<>?`\\-\\=;',./\\[\\]\\\\]).*";

    /**
     * 修改密码
     *
     * @param param 系统Code
     * @return 是否成功
     */
    // TODO: 2016/12/28  暂时没用2016/12/28
//    @Override
//    public Boolean modifyPassword(ModifyPasswordParam param) {
//        RestRequest<ModifyPasswordParam> requestBody = new RestRequest<>();
//        requestBody.setParam(param);
//        // 调用密码修改接口
//        String url = SSORelevanceDefine.getModifyPassword();
//        RestResponse<Boolean> result = RestClientUtil.post(url, requestBody, new TypeReference<RestResponse<Boolean>>() {
//        });
//        if(result.getResult() == false){
//            errorMessage = result.getMessage();
//        }
//        return result.getResult();
//    }
//
//    @Override
//    public boolean checkParam(String oldPassword, String newPassword, String againPassword, OrgEmploy orgEmploy) {
//        errorMessage = "";
//        //check begin
//        boolean flag = true;
//        if (StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(againPassword)) {
//            errorMessage = "输入值不能为空！";
//            flag = false;
//        }
//        if (orgEmploy.getEmployCode().equals(newPassword)) {
//            errorMessage = "密码不可以和账号相同！";
//            flag = false;
//        }
//        if (!newPassword.equals(againPassword)) {
//            errorMessage = "新密码和确认密码不一致！";
//            flag = false;
//        }
//        if (newPassword.length() < maxPasswordLength) {
//            errorMessage = "密码不可以少于6位！";
//            flag = false;
//        }
//        if (!newPassword.matches(passwordReg)) {
//            errorMessage = "密码必须包含大写字母小写字母特殊符号以及数字组合！";
//            flag = false;
//        }
//        if (!Md5Digest.digest(oldPassword).equals(orgEmploy.getPassword())) {
//            errorMessage = "原始密码输入错误！";
//            flag = false;
//        }
//        if (Md5Digest.digest(newPassword).equals(orgEmploy.getPassword())) {
//            errorMessage = "新密码和原始密码不可以相同！";
//            flag = false;
//        }
//        return flag;
//        //check end
//    }
}

package com.msk.utils;

import com.alibaba.fastjson.TypeReference;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.msk.bean.param.GroupUserParam;
import com.msk.bean.result.GroupUserResult;
import com.msk.common.SystemServerDef;
import com.msk.common.config.ConfigUtils;
import com.msk.common.config.RestClientUtils;

/**
 * Created by zhu_kai1 on 2017/1/6.
 */
public class RestUtils {
    /**
     * 调用权限接口，获取对应用户组下面的用户信息
     * @param param
     * @return
     */
    public static BaseRestPaginationResult<GroupUserResult> getUserInfo(GroupUserParam param){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ConfigUtils.getZuul());
        stringBuffer.append("/");
        stringBuffer.append(ConfigUtils.getModelName());
        stringBuffer.append(SystemServerDef.authorityRestUrl.SEARCH_USER);
        return  RestClientUtils.post(stringBuffer.toString(),param,new TypeReference<BaseRestPaginationResult<GroupUserResult>>(){});
    }

}

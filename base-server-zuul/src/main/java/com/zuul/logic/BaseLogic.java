package com.zuul.logic;

import com.zuul.bean.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mao_yejun on 2017/2/27.
 */
public class BaseLogic {
    @Autowired
    private HttpServletRequest request;
    public String getLoginUserId() {
        String userId = request.getHeader("sign");
        return userId;
    }
    public int getStartPos(Pagination pagination){
        int pageSize = pagination.getPageSize();
        int startPos = pagination.getStartPos();
        return pageSize*(startPos-1);
    }
}

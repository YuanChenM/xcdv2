package com.framework.resource.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */

public class PageResourceDocParam extends BaseRestPaginationParam {

    private String pageId;

    private String pageCode;

    private String pageName;

    private String pageDesc;

    private String isMenu;

    private String pageUrl;

    private Integer pageSort;

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }

    public String getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(String isMenu) {
        this.isMenu = isMenu;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public Integer getPageSort() {
        return pageSort;
    }

    public void setPageSort(Integer pageSort) {
        this.pageSort = pageSort;
    }
}

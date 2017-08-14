package com.framework.resource.bean.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.framework.resource.base.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by zhu_kai1 on 2016/11/25.
 */
@Document(collection = "pageResourceDoc")
public class PageResourceDoc extends BaseEntity {
    @ApiModelProperty(value = "画面资源标识")
    private String pageId;
    @ApiModelProperty(value = "画面资源code")
    private String pageCode;
    @ApiModelProperty(value = "画面资源名称")
    private String pageName;
    @ApiModelProperty(value = "画面资源描述")
    private String pageDesc;
    @ApiModelProperty(value = "是否菜单")
    private String isMenu;
    @ApiModelProperty(value = "菜单来源")
    private String menuSource;
    @ApiModelProperty(value = "资源定位")
    private String pageUrl;
    @ApiModelProperty(value = "排序")
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

    public String getMenuSource() {
        return menuSource;
    }

    public void setMenuSource(String menuSource) {
        this.menuSource = menuSource;
    }
}

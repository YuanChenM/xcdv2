package com.framework.resource.bean.entity;

import com.framework.resource.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dai_youcheng on 2016-11-25.
 */
@Document(collection = "sysResourceDoc")
public class SysResourceDoc extends BaseEntity {
    @ApiModelProperty(value = "标识")
    private String sysId;
    @ApiModelProperty(value = "系统code")
    private String sysCode;
    @ApiModelProperty(value = "系统名称")
    private String sysName;
        @ApiModelProperty(value = "系统资源")
    private String sysUrl;
    @ApiModelProperty(value = "排序")
    private Integer sysSort;
    @ApiModelProperty(value = "图片路劲")
    private String imagePath;

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl;
    }

    public Integer getSysSort() {
        return sysSort;
    }

    public void setSysSort(Integer sysSort) {
        this.sysSort = sysSort;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "SysResourceDoc{" +
                "sysId='" + sysId + '\'' +
                ", sysCode='" + sysCode + '\'' +
                ", sysName='" + sysName + '\'' +
                ", sysUrl='" + sysUrl + '\'' +
                ", sysSort=" + sysSort +
                '}';
    }
}

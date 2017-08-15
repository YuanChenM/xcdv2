package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0245IParam", description = "查询联系人入参")
public class SLIM0245IParam extends BaseRestPaginationParam {


    @ApiModelProperty(value = "联系人ID集合")
    private List<Long> contactIds;
    @ApiModelProperty(value = "联系人名称")
    private String contactName;
    @ApiModelProperty(value = "工作单位ID集合")
    private List<Long> workunitIds;
    @ApiModelProperty(value = "工作单位类型")
    private String workunitType;

    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getContactIds() {
        return contactIds;
    }

    public void setContactIds(List<Long> contactIds) {
        this.contactIds = contactIds;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<Long> getWorkunitIds() {
        return workunitIds;
    }

    public void setWorkunitIds(List<Long> workunitIds) {
        this.workunitIds = workunitIds;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }

    public String getWorkunitType() {
        return workunitType;
    }

    public void setWorkunitType(String workunitType) {
        this.workunitType = workunitType;
    }
}

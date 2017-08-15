package com.bms.slim.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLIM0108IParam",
        description = "查询卖家经营团队接口入参")
public class SLIM0108IParam extends BaseRestPaginationParam {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "卖家经营管理团队Id集合")
    private List<Long> smtIds;
    @ApiModelProperty(value = "实体卖家Id集合")
    private List<Long> entitySellerIds;
    @ApiModelProperty(value = "职务类型集合")
    private List<Integer> positionTypes;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "文化程度")
    private String educationalLevel;
    @ApiModelProperty(value = "删除标识")
    private Boolean delFlg;

    public List<Long> getSmtIds() {
        return smtIds;
    }

    public void setSmtIds(List<Long> smtIds) {
        this.smtIds = smtIds;
    }

    public List<Long> getEntitySellerIds() {
        return entitySellerIds;
    }

    public void setEntitySellerIds(List<Long> entitySellerIds) {
        this.entitySellerIds = entitySellerIds;
    }

    public List<Integer> getPositionTypes() {
        return positionTypes;
    }

    public void setPositionTypes(List<Integer> positionTypes) {
        this.positionTypes = positionTypes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public Boolean getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Boolean delFlg) {
        this.delFlg = delFlg;
    }
}

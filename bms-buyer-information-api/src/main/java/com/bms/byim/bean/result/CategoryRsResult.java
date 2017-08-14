package com.bms.byim.bean.result;

import com.bms.byim.bean.entity.ByimCategory;
import com.bms.byim.bean.param.CategoryRsParam;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/6.
 */

@ApiModel(value = "categoryRsResult", description = "查询列表结构买家分类Result")
public class CategoryRsResult extends BaseRestResult {

    private List<ByimCategory> categoryIdList;
    private List<CategoryRsParam> categoryRsParamList;
    @ApiModelProperty(value = "插入数量")
    private int count;
    @ApiModelProperty(value = "插入物流区ID数组")
    private List<Long> categoryArray;
    @ApiModelProperty(value = "message信息")
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public List<CategoryRsParam> getCategoryRsParamList() {
        return categoryRsParamList;
    }

    public void setCategoryRsParamList(List<CategoryRsParam> categoryRsParamList) {
        this.categoryRsParamList = categoryRsParamList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getCategoryArray() {
        return categoryArray;
    }

    public void setCategoryArray(List<Long> categoryArray) {
        this.categoryArray = categoryArray;
    }

    public List<ByimCategory> getCategoryIdList() {
        return categoryIdList;
    }

    public void setCategoryIdList(List<ByimCategory> categoryIdList) {
        this.categoryIdList = categoryIdList;
    }
}

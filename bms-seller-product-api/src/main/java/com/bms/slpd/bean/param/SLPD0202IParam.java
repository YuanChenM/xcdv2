package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0202IParam", description = "新增品种接口入参")
public class SLPD0202IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "批量新增集合")
    private List<SlpdBreedParam> breedList;

    @ApiModelProperty(value = "功能标识 1:单独新增一级分类;2:单独新增二级分类;3:单独新增品种;4:同时新增一级,二级,品种(快速录入)")
    private String insertFlg;

    public List<SlpdBreedParam> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<SlpdBreedParam> breedList) {
        this.breedList = breedList;
    }

    public String getInsertFlg() {
        return insertFlg;
    }

    public void setInsertFlg(String insertFlg) {
        this.insertFlg = insertFlg;
    }
}

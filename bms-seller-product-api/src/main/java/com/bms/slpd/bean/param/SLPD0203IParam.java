package com.bms.slpd.bean.param;


import com.bms.slpd.bean.param.wrapper.SlpdBreedParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLPD0203IParam", description = "修改品种接口入参")
public class SLPD0203IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "targets")
    private String[] targets;

    @ApiModelProperty(value = "更新品种参数集合")
    private List<SlpdBreedParam> breedList;

    @ApiModelProperty(value = "更新标识;1:功能一;2:功能二;3:功能三")
    private String updateFlg;

    public List<SlpdBreedParam> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<SlpdBreedParam> breedList) {
        this.breedList = breedList;
    }

    public String getUpdateFlg() {
        return updateFlg;
    }

    public void setUpdateFlg(String updateFlg) {
        this.updateFlg = updateFlg;
    }

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }
}

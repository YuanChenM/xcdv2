package com.bms.agif.bean.result;

import com.bms.agif.bean.entity.AgifButlerLevelStandard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "ButlerLevelStandardResult", description = "冻品管家定级标准返回结果")
public class ButlerLevelStandardResult implements Serializable {

    @ApiModelProperty(value = "返回操作条数")
    private Integer count;
    @ApiModelProperty(value = "冻品管家定级标准集合")
    private List<AgifButlerLevelStandard> levelStandardList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<AgifButlerLevelStandard> getLevelStandardList() {
        return levelStandardList;
    }

    public void setLevelStandardList(List<AgifButlerLevelStandard> levelStandardList) {
        this.levelStandardList = levelStandardList;
    }
}

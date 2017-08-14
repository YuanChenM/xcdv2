package com.bms.agif.bean.result;

import com.bms.agif.bean.entity.AgifAgentLevelStandard;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "AgentLevelStandardResult", description = "买手定级标准返回结果")
public class AgentLevelStandardResult implements Serializable {

    @ApiModelProperty(value = "返回操作条数")
    private Integer count;
    @ApiModelProperty(value = "买手定级标准集合")
    private List<AgifAgentLevelStandard> levelStandardList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<AgifAgentLevelStandard> getLevelStandardList() {
        return levelStandardList;
    }

    public void setLevelStandardList(List<AgifAgentLevelStandard> levelStandardList) {
        this.levelStandardList = levelStandardList;
    }
}

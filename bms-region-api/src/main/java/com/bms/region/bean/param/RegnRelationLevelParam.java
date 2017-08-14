package com.bms.region.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by guan_zhongheng on 2017/3/17.
 */
@ApiModel(value = "RegnRelationLevelParam", description = "物流区划、行政区划查询层级")
public class RegnRelationLevelParam implements Serializable{


    /**
     * 查询层级 0:省 - 物流区  1:城市 - 地区  2: 区县 - 配送站
     * 当前层级自动包含上一层级信息
     * 上层级不存在 该处不会显示(省除外)
     */
    @ApiModelProperty(value = "1、以城市、地区 关联查询层级  1:省、物流区、城市、地区  2: (1 + 区县)  3：(1 + 配送站) " +
            "2、当前层级自动包含上一层级信息" +
            "3、上层级不存在 该处不会显示(省除外)" +
            "4、该处关联都是通过城市与地区关系上下建立" +
            "5、默认1")
    private Integer searchLevel = 2;

    @ApiModelProperty(value ="0: 表示物流区与省作为关联双方  1：表示城市与地区作为关联双(默认) 2：表示配送站、区县作为关联双方")
    private String relaType = "1";

    public Integer getSearchLevel() {
        return searchLevel;
    }

    public void setSearchLevel(Integer searchLevel) {
        this.searchLevel = searchLevel;
    }

    public String getRelaType() {
        return relaType;
    }

    public void setRelaType(String relaType) {
        this.relaType = relaType;
    }
}

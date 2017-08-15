package com.bms.slpd.bean.result;

import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SLPD0503IResult",
        description = "修改品牌单品接口出参")
public class SLPD0503IResult extends BaseRestResult {

    @ApiModelProperty(value = "更新数量")
    private int count;
    @ApiModelProperty(value = "品牌单品Id列表")
    private List<Long> brandItemIds;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getBrandItemIds() {
        return brandItemIds;
    }

    public void setBrandItemIds(List<Long> brandItemIds) {
        this.brandItemIds = brandItemIds;
    }

}

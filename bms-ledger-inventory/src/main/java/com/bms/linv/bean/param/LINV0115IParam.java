package com.bms.linv.bean.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by zhang_jian4 on 2017/4/21.
 */
@ApiModel(value = "LINV0115IParam",
        description = "库存划拨完成")
public class LINV0115IParam implements Serializable {

    @ApiModelProperty(value = "source")
    private LINV0115ISourceParam source;

    @ApiModelProperty(value = "deal")
    private LINV0115IDealParam deal;

    public LINV0115ISourceParam getSource() {
        return source;
    }

    public void setSource(LINV0115ISourceParam source) {
        this.source = source;
    }

    public LINV0115IDealParam getDeal() {
        return deal;
    }

    public void setDeal(LINV0115IDealParam deal) {
        this.deal = deal;
    }
}

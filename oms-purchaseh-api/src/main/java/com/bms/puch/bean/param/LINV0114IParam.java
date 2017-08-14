package com.bms.puch.bean.param;

import com.framework.base.rest.param.BaseRestPaginationParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/24.
 */
@ApiModel(value = "LINV0114IInvWhParam",
        description = "仓库信息查询参数")
public class LINV0114IParam extends BaseRestPaginationParam {

    @ApiModelProperty(value = "物流区ID")
    private List<Long> logisticsId;
    @ApiModelProperty(value = "仓库ID")
    private List<Long> whId;
    @ApiModelProperty(value = "仓库编码")
    private List<String> whCode;

    public List<Long> getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(List<Long> logisticsId) {
        this.logisticsId = logisticsId;
    }

    public List<Long> getWhId() {
        return whId;
    }

    public void setWhId(List<Long> whId) {
        this.whId = whId;
    }

    public List<String> getWhCode() {
        return whCode;
    }

    public void setWhCode(List<String> whCode) {
        this.whCode = whCode;
    }
}

package com.bms.byim.bean.result;

import com.framework.base.rest.result.BaseRestPaginationResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by zhao_chen1 on 2016/12/9.
 */

//BasePageResult
@ApiModel(value = "车辆通行区域参数类返回结果集",description = "车辆通行区域参数类返回结果类")
public class DeliveryAreaRsResult extends BaseRestPaginationResult {
/*    @ApiModelProperty(value = "车辆通行区域实体类集合")
    List<ByimDeliveryArea>  deliveryAreas;*/
    @ApiModelProperty(value = "编辑返回更新数量")
    private int count;
    @ApiModelProperty(value = "更新的通行区域ID")
    private  List<Long> deliveryAreaId;

    //新增编辑都需要，先没做泛型
    @ApiModelProperty(value = "")
    private List  deliveryAreaList;

    @ApiModelProperty(value = "")
    private String[] message;

    public String[] getMessage() {
        return message;
    }

    public void setMessage(String[] message) {
        this.message = message;
    }

    public List getDeliveryAreaList() {
        return deliveryAreaList;
    }

    public void setDeliveryAreaList(List deliveryAreaList) {
        this.deliveryAreaList = deliveryAreaList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Long> getDeliveryAreaId() {
        return deliveryAreaId;
    }

    public void setDeliveryAreaId(List<Long> deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }
}

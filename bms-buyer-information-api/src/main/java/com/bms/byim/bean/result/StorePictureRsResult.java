package com.bms.byim.bean.result;

import com.bms.byim.bean.entity.ByimStorePicture;
import com.framework.base.rest.result.BaseRestResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by yuan_zhifei on 2016/12/30.
 */
@ApiModel(value = "StorePictureRsResult", description = "返回集合")
public class StorePictureRsResult extends BaseRestResult {
    @ApiModelProperty(value = "买家店铺证照信息集合")
    private List<ByimStorePicture> storePictureList;

    public List<ByimStorePicture> getStorePictureList() {
        return storePictureList;
    }

    public void setStorePictureList(List<ByimStorePicture> storePictureList) {
        this.storePictureList = storePictureList;
    }
}

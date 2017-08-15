package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0222ProducerHonorCertificateParam;
import com.bms.slim.bean.param.field.SLIM0228ProducerWorkShopParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0222IParam", description = "新增生产商荣誉证书接口入参")
public class SLIM0222IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产商荣誉证书集合")
    private List<SLIM0222ProducerHonorCertificateParam> producerHonorCertificateParams;

    public List<SLIM0222ProducerHonorCertificateParam> getProducerHonorCertificateParams() {
        return producerHonorCertificateParams;
    }

    public void setProducerHonorCertificateParams(List<SLIM0222ProducerHonorCertificateParam> producerHonorCertificateParams) {
        this.producerHonorCertificateParams = producerHonorCertificateParams;
    }
}

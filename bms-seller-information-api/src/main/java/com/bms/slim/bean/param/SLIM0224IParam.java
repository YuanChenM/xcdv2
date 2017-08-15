package com.bms.slim.bean.param;

import com.bms.slim.bean.param.field.SLIM0224ProducerHonorCertificateParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "SLIM0224IParam", description = "批量修改生产商荣誉证书API的入参")
public class SLIM0224IParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "指定需要修改的字段名")
    private String[] targets;

    @ApiModelProperty(value = "生产商荣誉证书参数集合")
    private List<SLIM0224ProducerHonorCertificateParam> producerHonorCertificateParams;

    public String[] getTargets() {
        return targets;
    }

    public void setTargets(String[] targets) {
        this.targets = targets;
    }

    public List<SLIM0224ProducerHonorCertificateParam> getProducerHonorCertificateParams() {
        return producerHonorCertificateParams;
    }

    public void setProducerHonorCertificateParams(List<SLIM0224ProducerHonorCertificateParam> producerHonorCertificateParams) {
        this.producerHonorCertificateParams = producerHonorCertificateParams;
    }
}

package com.bms.slim.rest;

import com.bms.slim.bean.param.SLIM0223IParam;
import com.bms.slim.bean.param.SLIM0232IParam;
import com.bms.slim.bean.result.SLIM0223IResult;
import com.bms.slim.bean.result.SLIM0232IResult;
import com.bms.slim.bean.result.field.SLIM0223ProducerHonorCertificateResult;
import com.bms.slim.bean.result.field.SLIM0232ProducerStorageCapacityResult;
import com.bms.slim.constant.MessageConstant;
import com.bms.slim.services.SLIM0223IService;
import com.bms.slim.services.SLIM0232IService;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "批量查询生产商荣誉证书接口", tags = "SLIM0223IRestController")
public class SLIM0223IRestController extends BaseRestController {

    @Autowired
    private SLIM0223IService slim0223IService;

    @ApiOperation(value = "批量查询生产商荣誉证书",
            notes = "honorCertificateIds,producerIds,issueAuthority,delFlg查询对应的生产商荣誉证书信息")
    @RequestMapping(value = "/producers/honor/certificates/_find",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SLIM0223IResult findProducerHonorCertificates(@RequestBody SLIM0223IParam slim0223IParam) {
        BaseRestPaginationResult<SLIM0223ProducerHonorCertificateResult> results = slim0223IService.findProducerHonorCertificate(slim0223IParam);
        SLIM0223IResult slim0223IResult = BeanUtils.toBean(results, SLIM0223IResult.class);
        slim0223IResult.setMessage(new String[]{MessageConstant.SUCCESS, "查询生产商荣誉证书成功"});
        return slim0223IResult;
    }
}

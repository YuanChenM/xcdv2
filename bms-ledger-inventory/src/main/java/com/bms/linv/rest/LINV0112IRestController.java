package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0112IInvParam;
import com.bms.linv.bean.result.LINV0112IInvResult;
import com.bms.linv.services.InvmComoInventoryService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/4/17.
 */
@RestController
@Api(description = "平台商品总库存查询", tags = "LINV0112IRestController", value = "LINV0110IRestController", position = 5)
public class LINV0112IRestController extends BaseRestController {

    @Autowired
    private InvmComoInventoryService invmComoInventoryService;

    @ApiOperation(value = "平台商品总库存查询", notes = "平台商品总库存查询")
    @RequestMapping(value = "/linv/_queryCommInv", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<LINV0112IInvResult> search(@RequestBody LINV0112IInvParam param) {
        List<LINV0112IInvResult> basicRsResult = invmComoInventoryService.findComoInvRelation(param);
        if(basicRsResult.size() == 0 ){
            basicRsResult= new ArrayList<LINV0112IInvResult>();
        }else{
        if( basicRsResult.get(0) == null){
           basicRsResult= new ArrayList<LINV0112IInvResult>();
        }
        }
        return basicRsResult;
    }

}

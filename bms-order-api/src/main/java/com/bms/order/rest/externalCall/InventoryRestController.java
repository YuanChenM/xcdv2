package com.bms.order.rest.externalCall;

import com.bms.order.archive.impl.externalCall.inventory.Inventory;
import com.bms.order.bean.externalCall.inventory.param.AllocationSupplierInventoryRestParam;
import com.bms.order.bean.externalCall.inventory.param.QuerySupplierInvRestParam;
import com.bms.order.bean.externalCall.inventory.result.AllocationSupplierInventoryRestResult;
import com.bms.order.bean.externalCall.inventory.result.QuerySupplierInvRestResult;
import com.framework.base.rest.RestResponse;
import com.framework.base.rest.SearchRestRequest;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_qiang1 on 2017/1/9.
 */

@RestController
@Api(tags = {"InventoryRestController"}, description = "库存查询")
public class InventoryRestController extends BaseRestController {

    @ApiOperation(value = "库存查询", notes = "库存查询")
    @RequestMapping(value = "/inventory/_find", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<QuerySupplierInvRestResult> execute(@RequestBody SearchRestRequest<QuerySupplierInvRestParam> request) {
        RestResponse restResponse = new RestResponse();
        QuerySupplierInvRestResult restResult = new Inventory().querySupplierInv(request.getFilter());
        restResponse.setResult(restResult);
        return restResponse;
    }



    @ApiOperation(value = "供应商库存占用", notes = "供应商库存占用")
    @RequestMapping(value = "/inventory/_allocation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RestResponse<AllocationSupplierInventoryRestResult> execute2(@RequestBody SearchRestRequest<AllocationSupplierInventoryRestParam> request) {
        RestResponse restResponse = new RestResponse();
        AllocationSupplierInventoryRestResult restResult = new Inventory().allocationSupplierInventory(request.getFilter());
        restResponse.setResult(restResult);
        return restResponse;
    }




}

package com.bms.puch.rest;

import com.bms.puch.bean.param.PuchReceiveParam;
import com.bms.puch.bean.result.PuchReceiveXmlResult;
import com.bms.puch.fms.common.FmsCommon;
import com.bms.puch.service.PuchReceiveService;
import com.framework.boot.base.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by guan_zhongheng on 2017/3/16.
 */
@RestController
@Api(value = "采购入库数据接收接口",
        description = "SRM系统做采购入库后将实际的入库信息通知OMS系统",
        position = 1,
        tags = "PUCH0101IRestController")
public class PUCH0101IRestController extends BaseRestController {

    @Autowired
    private PuchReceiveService puchReceiveService;

    @Autowired
    private FmsCommon fmsCommon;

    /**
     * 区域信息查询
     *
     * @param param
     * @return
     */
    @ApiOperation(value = "采购入库数据接收",
            notes = "采购入库数据接收")
    @RequestMapping(value = "/purchase/receive/_create",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE},
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public PuchReceiveXmlResult addPuchReceiveInfo(@RequestBody PuchReceiveParam param) {
        PuchReceiveXmlResult res = puchReceiveService.exceutePuchInfo(param);

        //买手合伙人竞价订单fms推送
        if(res.isPushFlg()){
            fmsCommon.pushAgentBidOrder(res.getDeliverId());
        }
        return res;
    }
}

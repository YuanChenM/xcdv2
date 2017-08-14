package com.bms.linv.rest;

import com.bms.linv.bean.param.LINV0116IParam;
import com.bms.linv.bean.result.LINV0116IResult;
import com.bms.linv.bean.result.LINV0116ISrcListResult;
import com.bms.linv.dao.InvmComoBalanceDealDetailDao;
import com.bms.linv.dao.InvmComoDealDetailDao;
import com.bms.linv.validator.LINV0116IValidator;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
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
 * Created by zheng_xu on 2017/4/25.
 */
@RestController
@Api(description = "商品库存交易溯源信息查询",
    tags = "LINV0116IRestController",
    value = "LINV0116IRestController",
    position = 5)
public class LINV0116IRestController extends BaseRestController {

    @Autowired
    private InvmComoDealDetailDao invmComoDealDetailDao;
    @Autowired
    private InvmComoBalanceDealDetailDao invmComoBalanceDealDetailDao;

    @ApiOperation(value = "商品库存交易溯源信息查询",
        notes = "商品库存交易溯源信息查询")
    @RequestMapping(value = "/linv/loadInv/allocation/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = LINV0116IValidator.class)
    public BaseRestPaginationResult<LINV0116IResult> search(@RequestBody List<LINV0116IParam> params) {
        BaseRestPaginationResult<LINV0116IResult> tranSearchResult = new BaseRestPaginationResult<>();
        List<LINV0116IResult> result = new ArrayList<>();
        if (params.size() > 0) {
            for (LINV0116IParam param : params) {
                // 查询商品交易明细
        LINV0116IResult linv0116IResult = invmComoDealDetailDao.findOutBoundInfo(param);
                if(null != linv0116IResult){
                    // 查询商品余量库存
        List<LINV0116ISrcListResult> srcList = invmComoBalanceDealDetailDao.findOutBoundInfo(param);
        linv0116IResult.setSrcList(srcList);
                }
                if(null != linv0116IResult){
                result.add(linv0116IResult);
            }
        }
        }
        tranSearchResult.setData(result);
        tranSearchResult.setTotal(result.size());
        return tranSearchResult;
    }
}

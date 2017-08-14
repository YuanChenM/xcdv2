package com.bms.dictionary.rest;

import com.bms.dictionary.bean.param.ModifyDataParam;
import com.bms.dictionary.bean.param.ModifyDictParam;
import com.bms.dictionary.service.LoadNodeService;
import com.bms.dictionary.service.NodeValueService;
import com.bms.dictionary.validator.ModifyCatalogValidator;
import com.bms.dictionary.validator.ModifyDataValidator;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mao_yejun on 2016/11/2.
 */
@RestController
@Api(value = "node-api",
        description = "修改节点值接口")
@RequestMapping(value = "/api")
public class ModifyNodeController {
    @Autowired
    private LoadNodeService loadNodeService;
    @Autowired
    private NodeValueService nodeValueService;

    @RequestMapping(value = "/dict/catalog/_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "更新目录")
    @Validator(validatorClass = ModifyCatalogValidator.class)
    public int modifyCatalog(@RequestBody ModifyDictParam param) {
        int i = 0;
        param.setUpdId(loadNodeService.getLoginUserId());
        param.setUpdTime(DateUtils.getCurrent());
        if(StringUtils.isNotEmpty(param.getDictCode()) || StringUtils.isNotEmpty(param.getDictEn())
                || StringUtils.isNotEmpty(param.getDictCn())){
            i= loadNodeService.modify(param);
        }
        return i;
    }

    @RequestMapping(value = "/dict/data/_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(value = "更新目录数据")
    @Validator(validatorClass = ModifyDataValidator.class)
    public int modifyData(@RequestBody  ModifyDataParam param) {
        int i = 0;
        param.setUpdId(nodeValueService.getLoginUserId());
        param.setUpdTime(DateUtils.getCurrent());
        if(StringUtils.isNotEmpty(param.getDataCn()) || StringUtils.isNotEmpty(param.getDataEn())
                || StringUtils.isNotEmpty(param.getDataValue())){
            i = nodeValueService.modify(param);
        }

        return i;
    }
}

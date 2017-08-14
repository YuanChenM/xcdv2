package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifButlerAddress;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerAddressRsParam;
import com.bms.agif.service.AgifButlerAddressService;
import com.bms.agif.validator.ButlerAddressAddValidator;
import com.bms.agif.validator.ButlerAddressUpdateValidator;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/3/2.
 */
@RestController
@Api(value = "bms-agent-info", description = "冻品管家地址信息接口", position = 1, tags = "ButlerAddressRestController")
public class ButlerAddressRestController extends BaseRestController {

    @Autowired
    private AgifButlerAddressService agifButlerAddressService;

    @ApiOperation(value = "冻品管家地址信息新增", notes = "冻品管家地址信息新增")
    @RequestMapping(value = "/butler/addr/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerAddressAddValidator.class)
    public Integer add(@RequestBody List<ButlerAddressRsParam> butlerAddressList) {
        return agifButlerAddressService.addButlerAddressList(butlerAddressList);
    }

    @ApiOperation(value = "冻品管家地址信息修改", notes = "冻品管家地址信息修改")
    @RequestMapping(value = "/butler/addr/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerAddressUpdateValidator.class)
    public Integer update(@RequestBody List<BaseBean<ButlerAddressRsParam, ButlerAddressRsParam>> butlerAddressList) {
        Date currentDate = DateUtils.getCurrent();
        int count;
        int countAll = NumberConst.IntDef.INT_ZERO;
        for (int i = 0, size = butlerAddressList.size(); i < size; i++) {
            BaseBean<AgifButlerAddress, AgifButlerAddress> bean = new BaseBean<>();
            AgifButlerAddress filter = BeanUtils.toBean(butlerAddressList.get(i).getFilter(), AgifButlerAddress.class);
            AgifButlerAddress target = BeanUtils.toBean(butlerAddressList.get(i).getTarget(), AgifButlerAddress.class);
            String loginUser = agifButlerAddressService.getLoginUserId();
            target.setUpdId(loginUser);
            target.setUpdTime(currentDate);
            bean.setTarget(target);
            bean.setFilter(filter);
            count = agifButlerAddressService.modify(bean);
            countAll += count;
        }
        return countAll;
    }

    @ApiOperation(value = "冻品管家地址信息查询", notes = "冻品管家地址信息查询")
    @RequestMapping(value = "/butler/addr/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    List<ButlerAddressRsParam> find(@RequestBody ButlerAddressRsParam butlerAddressRsParam) {
        return agifButlerAddressService.findList(butlerAddressRsParam);
    }
}

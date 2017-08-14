package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifButlerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerAccountRsParam;
import com.bms.agif.service.AgifButlerAccountService;
import com.bms.agif.validator.ButlerAccountAddValidator;
import com.bms.agif.validator.ButlerAccountModifyValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by tao_zhifa on 2017/3/2.
 */
@RestController
@Api(value = "bms-agent-info", description = "冻品管家账号信息接口", position = 1, tags = "ButlerAccountRestController")
public class ButlerAccountRestController extends BaseRestController {

    @Autowired
    private AgifButlerAccountService agifButlerAccountService;

    @ApiOperation(value = "冻品管家账号新增接口", notes = "冻品管家账号新增接口")
    @RequestMapping(value = "/butler/account/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerAccountAddValidator.class)
    public Integer add(@RequestBody ButlerAccountRsParam butlerAccountRsParam) {
        int count = agifButlerAccountService.getCount(butlerAccountRsParam);
        if(count != NumberUtils.INTEGER_ZERO){
            return -1; //账号已经存在
        }
        AgifButlerAccount bean = BeanUtils.toBean(butlerAccountRsParam, AgifButlerAccount.class);
        Date currentDate = DateUtils.getCurrent();
        String loginUser =agifButlerAccountService.getLoginUserId();
        Long maxId = agifButlerAccountService.maxId("AGIF_BUTLER_ACCOUNT");
        bean.setUpdTime(currentDate);
        bean.setCrtTime(currentDate);
        bean.setUpdId(loginUser);
        bean.setCrtId(loginUser);
        bean.setDelFlg(false);
        bean.setVersion(1);
        bean.setAccountId(maxId);
        return agifButlerAccountService.save(bean);
    }


    @ApiOperation(value = "冻品管家账号修改重置接口", notes = "冻品管家账号修改重置接口")
    @RequestMapping(value = "/butler/account/password/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerAccountModifyValidator.class)
    public Integer passwordModify(@RequestBody BaseBean<ButlerAccountRsParam,ButlerAccountRsParam> baseParam) {
        String loginUser =agifButlerAccountService.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        BaseBean<AgifButlerAccount,AgifButlerAccount> baseBean = new BaseBean<>();
        AgifButlerAccount target = BeanUtils.toBean(baseParam.getTarget(),AgifButlerAccount.class);
        AgifButlerAccount filter = BeanUtils.toBean(baseParam.getFilter(),AgifButlerAccount.class);
        target.setUpdId(loginUser);
        target.setUpdTime(currentDate);
        baseBean.setFilter(filter);
        baseBean.setTarget(target);
        return agifButlerAccountService.modify(baseBean);
    }

    @ApiOperation(value = "冻品管家账号查询接口", notes = "冻品管家账号查询接口")
    @RequestMapping(value = "/butler/account/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ButlerAccountRsParam search(@RequestBody ButlerAccountRsParam butlerAccountRsParam) {
        return agifButlerAccountService.findOne(butlerAccountRsParam);
    }
}

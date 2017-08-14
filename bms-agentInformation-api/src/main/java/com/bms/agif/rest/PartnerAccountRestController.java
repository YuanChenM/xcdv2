package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifPartnerAccount;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.PartnerAccountRsParam;
import com.bms.agif.service.AgifPartnerAccountService;
import com.bms.agif.validator.PartnerAccountAddValidator;
import com.bms.agif.validator.PartnerAccountModifyValidator;
import com.framework.base.consts.NumberConst;
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
 * Created by yuan_zhifei on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api", description = "合伙人帐号基本信息", position = 1, tags = "PartnerAccountRestController")
public class PartnerAccountRestController extends BaseRestController {
    @Autowired
    private AgifPartnerAccountService partnerAccountService;

    @ApiOperation(value = "合伙人帐号信息新增", notes = "合伙人帐号信息新增", position = 1)
    @RequestMapping(value = "/partner/account/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})

    @Validator(validatorClass = PartnerAccountAddValidator.class)
    public Integer addPartner(@RequestBody PartnerAccountRsParam partnerAccountRsParam) {
        int count = partnerAccountService.getCount(partnerAccountRsParam);
        if(count != NumberUtils.INTEGER_ZERO){
            return -1; //账号已经存在
        }
        AgifPartnerAccount partnerAccount = BeanUtils.toBean(partnerAccountRsParam, AgifPartnerAccount.class);
        Date currentDate = DateUtils.getCurrent();
        String loginUserId = this.partnerAccountService.getLoginUserId();
        Long accountId = this.partnerAccountService.maxId("AGIF_PARTNER_ACCOUNT");
        partnerAccount.setAccountId(accountId);
        partnerAccount.setUpdId(loginUserId);
        partnerAccount.setUpdTime(currentDate);
        partnerAccount.setCrtId(loginUserId);
        partnerAccount.setCrtTime(currentDate);
        partnerAccount.setDelFlg(false);
        partnerAccount.setVersion(NumberConst.IntDef.INT_ONE);
        int result = this.partnerAccountService.save(partnerAccount);
        return result;
    }


    @ApiOperation(value = "合伙人帐号信息修改重置接口", notes = "合伙人帐号信息修改重置接口")
    @RequestMapping(value = "/partner/account/password/_modify", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = PartnerAccountModifyValidator.class)
    public Integer passwordModify(@RequestBody BaseBean<PartnerAccountRsParam,PartnerAccountRsParam> baseParam) {
        String loginUser = partnerAccountService.getLoginUserId();
        Date currentDate = DateUtils.getCurrent();
        BaseBean<AgifPartnerAccount,AgifPartnerAccount> baseBean = new BaseBean<>();
        AgifPartnerAccount target = BeanUtils.toBean(baseParam.getTarget(),AgifPartnerAccount.class);
        AgifPartnerAccount filter = BeanUtils.toBean(baseParam.getFilter(),AgifPartnerAccount.class);
        target.setUpdId(loginUser);
        target.setUpdTime(currentDate);
        baseBean.setFilter(filter);
        baseBean.setTarget(target);
        return partnerAccountService.modify(baseBean);
    }

    @ApiOperation(value = "合伙人帐号信息查询接口", notes = "合伙人帐号信息查询接口")
    @RequestMapping(value = "/partner/account/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public PartnerAccountRsParam search(@RequestBody PartnerAccountRsParam partnerAccountRsParam) {
        return partnerAccountService.findOne(partnerAccountRsParam);
    }

}

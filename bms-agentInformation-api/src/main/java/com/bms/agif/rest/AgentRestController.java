package com.bms.agif.rest;

import com.bms.agif.bean.param.*;
import com.bms.agif.bean.result.AccountResult;
import com.bms.agif.bean.result.AgentAndPartnerResult;
import com.bms.agif.service.AgifAgentService;
import com.bms.agif.service.AgifButlerAddressService;
import com.bms.agif.service.AgifButlerService;
import com.bms.agif.service.AgifPartnerAgentService;
import com.bms.agif.validator.AgentAddValidator;
import com.bms.agif.validator.AgentUpdateValidator;
import com.bms.fms.notice.FmsNotice;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.core.db.DbUtils;
import com.framework.core.utils.CollectionUtils;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guan_zhongheng on 2017/3/2.
 */
@RestController
@Api(value = "bms-agif-api",
        description = "买手基础信息操作",
        position = 1,
        tags = "AgifAgentRestController")
public class AgentRestController extends BaseRestController {

    @Autowired
    private AgifAgentService agifAgentService;
    @Autowired
    private AgifButlerService agifButlerService;
    @Autowired
    private AgifButlerAddressService agifButlerAddressService;

    @Autowired
    private AgifPartnerAgentService agifPartnerAgentService;

    @Autowired
    private FmsNotice fmsNotice;

    @ApiOperation(value = "买手基础信息查询操作",
            notes = "买手基础信息查询操作",
            position = 5)
    @RequestMapping(value = "/agent/basic/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<AccountResult> search(@RequestBody AgentDemesnePageParam param) {
        if (StringUtils.isNotEmpty(param.getAgentName())) {
            param.setAgentName(DbUtils.buildLikeCondition(param.getAgentName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAccountName())) {
            param.setAccountName(DbUtils.buildLikeCondition(param.getAccountName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAgentCode())) {
            param.setAgentCode(DbUtils.buildLikeCondition(param.getAgentCode(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getTelNo())) {
            param.setTelNo(DbUtils.buildLikeCondition(param.getTelNo(), DbUtils.LikeMode.PARTIAL));
        }
        return agifAgentService.findPageList(param);
    }

    @ApiOperation(value = "买手资格信息查询操作(包含买手、销售合伙人)",
            notes = "买手资格信息查询操作(包含买手、销售合伙人)",
            position = 5)
    @RequestMapping(value = "/agent/partner/qualification/_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public BaseRestPaginationResult<AgentAndPartnerResult> agentAndPartnerSearch(@RequestBody AgentAndPartnerPageParam param) {

        if (StringUtils.isNotEmpty(param.getAgentName())) {
            param.setAgentName(DbUtils.buildLikeCondition(param.getAgentName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAccountName())) {
            param.setAccountName(DbUtils.buildLikeCondition(param.getAccountName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCategoryName())) {
            param.setCategoryName(DbUtils.buildLikeCondition(param.getCategoryName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getTelNo())) {
            param.setTelNo(DbUtils.buildLikeCondition(param.getTelNo(), DbUtils.LikeMode.PARTIAL));
        }

        if (StringUtils.isNotEmpty(param.getProvinceName())) {
            param.setProvinceName(DbUtils.buildLikeCondition(param.getProvinceName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getCityName())) {
            param.setCityName(DbUtils.buildLikeCondition(param.getCityName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getStreetName())) {
            param.setStreetName(DbUtils.buildLikeCondition(param.getStreetName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAgentWechat())) {
            param.setAgentWechat(DbUtils.buildLikeCondition(param.getAgentWechat(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAgentQq())) {
            param.setAgentQq(DbUtils.buildLikeCondition(param.getAgentQq(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAgentBankName())) {
            param.setAgentBankName(DbUtils.buildLikeCondition(param.getAgentBankName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getAgentBankAccountName())) {
            param.setAgentBankAccountName(DbUtils.buildLikeCondition(param.getAgentBankAccountName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getLgcsAreaName())) {
            param.setLgcsAreaName(DbUtils.buildLikeCondition(param.getLgcsAreaName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getZoneName())) {
            param.setZoneName(DbUtils.buildLikeCondition(param.getZoneName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDistrictName())) {
            param.setDistrictName(DbUtils.buildLikeCondition(param.getDistrictName(), DbUtils.LikeMode.PARTIAL));
        }
        if (StringUtils.isNotEmpty(param.getDemesneName())) {
            param.setDemesneName(DbUtils.buildLikeCondition(param.getDemesneName(), DbUtils.LikeMode.PARTIAL));
        }
        return agifPartnerAgentService.findPageList(param);
    }


    @ApiOperation(value = "买手基础信息新增操作",
            notes = "买手基础信息新增操作",
            position = 5)
    @RequestMapping(value = "/agent/basic/_add",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentAddValidator.class)
    public String add(@RequestBody AccountParam param) {
        String agentId = agifAgentService.addAgifAgentInfo(param);
        this.addButler(param, agentId);
        if (StringUtils.isNotEmpty(agentId)) {
            fmsNotice.sendAgent(agentId);
        }
        return agentId;
    }

    /**
     * 新增冻品管家信息
     *
     * @param param
     * @param agentId
     */
    private void addButler(AccountParam param, String agentId) {
        ButlerRsParam butlerRsParam = new ButlerRsParam();
        butlerRsParam.setAgentId(agentId);
        butlerRsParam.setButlerName(param.getAgentName());
        butlerRsParam.setButlerSex(param.getAgentSex());
        butlerRsParam.setButlerWechat(param.getAgentWechat());
        butlerRsParam.setButlerQq(param.getAgentQq());
        butlerRsParam.setIdCardNo(param.getAgentCardId());
        butlerRsParam.setAccountId(param.getAccountId());
        butlerRsParam.setAccountName(param.getAccountName());
        butlerRsParam.setPassword(param.getPassword());
        butlerRsParam.setTelNo(param.getTelNo());
        butlerRsParam.setMailAddr(param.getMailAddr());
        String butlerId = this.agifButlerService.insertButlerAndAddress(butlerRsParam);
        this.addButlerAddress(param, butlerId);
    }

    /**
     * 新增冻品管家地址信息
     *
     * @param param
     */
    private void addButlerAddress(AccountParam param, String butlerId) {
        ButlerAddressRsParam addressRsParam = new ButlerAddressRsParam();
        addressRsParam.setButlerId(butlerId);
        addressRsParam.setProvinceId(param.getProvinceId());
        addressRsParam.setProvinceCode(param.getProvinceCode());
        addressRsParam.setProvinceName(param.getProvinceName());
        addressRsParam.setCityId(param.getCityId());
        addressRsParam.setCityCode(param.getCityCode());
        addressRsParam.setCityName(param.getCityName());
        addressRsParam.setDistrictId(param.getDistrictId());
        addressRsParam.setDistrictCode(param.getDistrictCode());
        addressRsParam.setDistrictName(param.getDistrictName());
        addressRsParam.setStreetId(param.getStreetId());
        addressRsParam.setStreetCode(param.getStreetCode());
        addressRsParam.setStreetName(param.getStreetName());
        addressRsParam.setAddrDetail(param.getAgentAddr());
        addressRsParam.setAddrType("0");
        addressRsParam.setAddrTypeName("户籍地址");
        List<ButlerAddressRsParam> addressRsParams = new ArrayList<>();
        addressRsParams.add(addressRsParam);
        this.agifButlerAddressService.addButlerAddressList(addressRsParams);
    }

    @ApiOperation(value = "买手基础信息批量新增操作",
            notes = "买手基础信息批量新增操作",
            position = 5)
    @RequestMapping(value = "/agent/batchSave",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public List batchSave(@RequestBody List<AccountParam> paramList) {
        List list = new ArrayList();
        for (AccountParam accountParam : paramList) {
            try {
                add(accountParam);
            } catch (Exception e) {
                list.add(accountParam.getTelNo());
            } finally {
                continue;
            }

        }
        return list;
    }

    @ApiOperation(value = "买手基础信息修改操作",
            notes = "买手基础信息修改操作",
            position = 5)
    @RequestMapping(value = "/agent/basic/_update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = AgentUpdateValidator.class)
    public void update(@RequestBody BaseBean<AccountParam, AccountParam> param) {
        AccountParam taget = param.getTarget();
        //买手基础信息查询根据主键
        AgentDemesnePageParam account = new AgentDemesnePageParam();
        account.setAgentId(param.getFilter().getAgentId());
        BaseRestPaginationResult<AgentDemesnePageParam> agentList = agifAgentService.findPageList(account);
        agifAgentService.updateAgifAgentInfo(param);
        Boolean delFlg = param.getTarget().getDelFlg();
        String agentId =param.getTarget().getAgentId();
        if (!delFlg) {
            if (CollectionUtils.isNotEmpty(agentList.getData())) {
                AgentDemesnePageParam result = agentList.getData().get(0);
                if ((null != taget.getTelNo()&&(!taget.getTelNo().equals(result.getTelNo())))
                        || (null != taget.getAccountName() &&(!taget.getAccountName().equals(result.getAccountName())))
                        || (null != taget.getAgentName() &&(!taget.getAgentName().equals(result.getAgentName())))
                        || (null != taget.getProvinceId() && (!taget.getProvinceId().equals(result.getProvinceId())))
                        || (null != taget.getCityId() &&(!taget.getCityId().equals(result.getCityId())))
                        || (null != taget.getDistrictId() &&(!taget.getDistrictId().equals(result.getDistrictId())))
                        || (null != taget.getStreetId() &&(!taget.getStreetId().equals(result.getStreetId())))
                        || (null != taget.getAgentAddr() &&(!taget.getAgentAddr().equals(result.getAgentAddr())))
                        || (null != taget.getCategoryCode() &&(!taget.getCategoryCode().equals(result.getCategoryCode())))
                        ){
                    if (StringUtils.isNotEmpty(agentId)) {
                        fmsNotice.sendAgent(agentId);
                    }
                }
            }
        }
    }

}

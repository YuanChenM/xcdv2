package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifButlerIntroduce;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerIntroduceRsParam;
import com.bms.agif.service.AgifButlerIntroduceService;
import com.bms.agif.validator.ButlerIntroduceAddValidator;
import com.bms.agif.validator.ButlerIntroduceUpdateValidator;
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
 * Created by tao_zhifa on 2017/3/3.
 */

@RestController
@Api(value = "bms-agent-info", description = "冻品管家自我介绍信息接口", position = 1, tags = "ButlerIntroduceRestController")
public class ButlerIntroduceRestController extends BaseRestController {


    @Autowired
    private AgifButlerIntroduceService agifButlerIntroduceService;

    @ApiOperation(value = "冻品管家自我介绍信息新增", notes = "冻品管家自我介绍信息新增")
    @RequestMapping(value = "/butler/introduce/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerIntroduceAddValidator.class)
    public Integer add(@RequestBody List<ButlerIntroduceRsParam> introduceList) {
        List<AgifButlerIntroduce> addressList = new ArrayList<>();
        for (int i = 0, size = introduceList.size(); i < size; i++) {
            AgifButlerIntroduce bean = BeanUtils.toBean(introduceList.get(i), AgifButlerIntroduce.class);
            Date currentDate = DateUtils.getCurrent();
            String loginUser =agifButlerIntroduceService.getLoginUserId();
            Long maxId = agifButlerIntroduceService.maxId("AGIF_BUTLER_INTRODUCE");
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setUpdId(loginUser);
            bean.setCrtId(loginUser);
            bean.setDelFlg(false);
            bean.setVersion(1);
            bean.setIntroduceId(maxId);
            addressList.add(bean);
        }
        return agifButlerIntroduceService.batchSave(addressList);
    }

    @ApiOperation(value = "冻品管家自我介绍信息修改", notes = "冻品管家自我介绍信息修改")
    @RequestMapping(value = "/butler/introduce/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerIntroduceUpdateValidator.class)
    public Integer update(@RequestBody List<BaseBean<ButlerIntroduceRsParam, ButlerIntroduceRsParam>> butlerIntroduceList) {
        Date currentDate = DateUtils.getCurrent();
        int count;
        int countAll = NumberConst.IntDef.INT_ZERO;
        String loginUser =agifButlerIntroduceService.getLoginUserId();
        for (int i = 0, size = butlerIntroduceList.size(); i < size; i++) {
            BaseBean<AgifButlerIntroduce, AgifButlerIntroduce> bean = new BaseBean<>();
            AgifButlerIntroduce filter = BeanUtils.toBean(butlerIntroduceList.get(i).getFilter(), AgifButlerIntroduce.class);
            AgifButlerIntroduce target = BeanUtils.toBean(butlerIntroduceList.get(i).getTarget(), AgifButlerIntroduce.class);
            target.setUpdId(loginUser);
            target.setUpdTime(currentDate);
            bean.setTarget(target);
            bean.setFilter(filter);
            count = agifButlerIntroduceService.modify(bean);
            countAll += count;
        }
        return countAll;
    }

    @ApiOperation(value = "冻品管家自我介绍信息查询", notes = "冻品管家自我介绍信息查询")
    @RequestMapping(value = "/butler/introduce/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    List<ButlerIntroduceRsParam> find(@RequestBody ButlerIntroduceRsParam butlerIntroduceRsParam) {
        return agifButlerIntroduceService.findList(butlerIntroduceRsParam);
    }
}

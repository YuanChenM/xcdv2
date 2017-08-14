package com.bms.agif.rest;

import com.bms.agif.bean.entity.AgifButlerPicture;
import com.bms.agif.bean.param.BaseBean;
import com.bms.agif.bean.param.ButlerPictureRsParam;
import com.bms.agif.service.AgifButlerPictureService;
import com.bms.agif.validator.ButlerPictureUpdateValidator;
import com.bms.agif.validator.ButlerPictureaddValidator;
import com.framework.boot.base.BaseRestController;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.validator.annotation.Validator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/3/2.
 */
@RestController
@Api(value = "bms-agent-info", description = "冻品管家证照图片信息接口", position = 1, tags = "ButlerPictureRestController")
public class ButlerPictureRestController extends BaseRestController {


    @Autowired
    private AgifButlerPictureService agifButlerPictureService;

    @ApiOperation(value = "冻品管家证照图片信息新增", notes = "冻品管家证照图片信息新增")
    @RequestMapping(value = "/butler/pic/_add", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerPictureaddValidator.class)
    public Integer add(@RequestBody ButlerPictureRsParam butlerPictureRsParam) {

        AgifButlerPicture bean = BeanUtils.toBean(butlerPictureRsParam, AgifButlerPicture.class);
        Date currentDate = DateUtils.getCurrent();
        String loginUser =agifButlerPictureService.getLoginUserId();
        Long maxId = agifButlerPictureService.maxId("AGIF_BUTLER_PICTURE");
        bean.setUpdTime(currentDate);
        bean.setCrtTime(currentDate);
        bean.setUpdId(loginUser);
        bean.setCrtId(loginUser);
        bean.setDelFlg(false);
        bean.setVersion(1);
        bean.setPicId(maxId);
        return agifButlerPictureService.save(bean);
    }

    @ApiOperation(value = "冻品管家证照图片信息修改", notes = "冻品管家证照图片信息修改")
    @RequestMapping(value = "/butler/pic/_update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = ButlerPictureUpdateValidator.class)
    public Integer update(@RequestBody BaseBean<ButlerPictureRsParam, ButlerPictureRsParam> butlerPicParam) {
        Date currentDate = DateUtils.getCurrent();
        String loginUser =agifButlerPictureService.getLoginUserId();
        BaseBean<AgifButlerPicture, AgifButlerPicture> bean = new BaseBean<>();
        AgifButlerPicture filter = BeanUtils.toBean(butlerPicParam.getFilter(), AgifButlerPicture.class);
        AgifButlerPicture target = BeanUtils.toBean(butlerPicParam.getTarget(), AgifButlerPicture.class);
        target.setUpdId(loginUser);
        target.setUpdTime(currentDate);
        bean.setTarget(target);
        bean.setFilter(filter);
        return agifButlerPictureService.modify(bean);
    }

    @ApiOperation(value = "冻品管家证照图片信息查询", notes = "冻品管家证照图片信息查询")
    @RequestMapping(value = "/butler/pic/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public
    @ResponseBody
    List<ButlerPictureRsParam> find(@RequestBody ButlerPictureRsParam butlerPictureRsParam) {
        return agifButlerPictureService.findList(butlerPictureRsParam);
    }
}

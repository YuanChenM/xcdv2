package com.framework.interfaceLog.rest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.interfaceLog.bean.entity.LogMstDoc;
import com.framework.interfaceLog.bean.param.LogMstParam;
import com.framework.interfaceLog.service.BaseInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "LogMst-api",
    description = "Log基本模板CRUD操作",
    tags = "LogMstRestController")
public class LogMstRestController extends BaseRestController {

    public static final Logger logger = LoggerFactory.getLogger(LogMstRestController.class);

    private String apiName = "mst";

    @Autowired
    BaseInfoService baseInfoService;

    /**
     * 查询相关信息
     *
     * @return
     */
    @ApiOperation(value = "log查询",
        notes = "查询log模板的相关信息")
    @RequestMapping(value = "/log/example/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogMstDoc> search(@RequestBody LogMstParam request) throws Exception {
        return baseInfoService.findList(request);
    }

    /**
     * 更新相关信息
     *
     * @return
     */
    @ApiOperation(value = "log模板更新",
        notes = "更新log模板相关信息")
    @RequestMapping(value = "/log/example/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public String update(@RequestBody LogMstDoc request) {
        int writeResult = baseInfoService.update(request);
        return MessageManager.getMessage("log.I00002", new String[] { apiName, String.valueOf(writeResult) });
    }

    /**
     * 保存相关信息
     *
     * @return
     */
    @ApiOperation(value = "log模板保存",
        notes = "保存log模板相关信息")
    @RequestMapping(value = "/log/example/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public String save(@RequestBody LogMstDoc request) {
        boolean flag = baseInfoService.save(request);
        String var = flag ? "成功" : "失败";
        return MessageManager.getMessage("log.I00001", new String[] { apiName, var });
    }

    /**
     * 删除相关信息
     *
     * @return
     */
    @ApiOperation(value = "log模板删除",
        notes = "删除log模板相关信息")
    @RequestMapping(value = "/log/example/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public String delete(@RequestBody ArrayList<String> request) {
        int writeResult = baseInfoService.delete(request);
        return MessageManager.getMessage("log.I00003", new String[] { apiName, String.valueOf(writeResult) });
    }
}

package com.framework.interfaceLog.rest;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bms.template.AbstractTemplate;
import com.bms.template.TemplateFactory;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.boot.base.BaseRestController;
import com.framework.i18n.util.MessageManager;
import com.framework.interfaceLog.bean.entity.LogHistoryDoc;
import com.framework.interfaceLog.bean.entity.LogInterfaceDoc;
import com.framework.interfaceLog.bean.param.LogInterfaceParam;
import com.framework.interfaceLog.service.InterfaceInfoService;
import com.framework.interfaceLog.validator.DelInterfaceLogValidator;
import com.framework.interfaceLog.validator.RepeatInterfaceLogValidator;
import com.framework.interfaceLog.validator.UpdateInterfaceLogValidator;
import com.framework.redis.dao.BaseRedisDao;
import com.framework.validator.annotation.Validator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "LogInterface-api",
    description = "Log基本CRUD操作",
    tags = "LogInterfaceRestController")
public class LogInterfaceRestController extends BaseRestController {

    public static final Logger logger = LoggerFactory.getLogger(LogInterfaceRestController.class);

    private String apiName = "Log";

    @Autowired
    InterfaceInfoService interfaceInfoService;

    @Autowired
    TemplateFactory templateFactory;

    @Autowired
    BaseRedisDao redisDao;

    /**
     * 查询相关信息
     *
     * @return
     */
    @ApiOperation(value = "Log查询",
        notes = "查询Log相关信息")
    @RequestMapping(value = "/log/interface/_search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public BaseRestPaginationResult<LogInterfaceDoc> search(@RequestBody LogInterfaceParam request) throws Exception {
        return interfaceInfoService.findList(request);
    }

    // class Ticket implements Runnable {
    // private int num = 1000;
    // private Object obj = new Object();
    //
    // @Override
    // public void run() {
    // while (true) {
    // // synchronized (obj) {
    // if (num > 0) {
    // try {
    // Thread.sleep(100);
    // Long id = redisDao.getTablePrimaryKey("XXXXXXXinterface", 1);
    // if (id == 0) {
    // System.err.println(obj.toString() + ":id=" + id);
    // }
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // num--;
    // } else {
    // break;
    // }
    // // }
    // }
    // }
    // }

    /**
     * 更新相关信息
     *
     * @return
     */
    @ApiOperation(value = "Log更新",
        notes = "更新Log相关信息")
    @RequestMapping(value = "/log/interface/_update",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = UpdateInterfaceLogValidator.class)
    public String update(@RequestBody LogInterfaceDoc request) {
        int writeResult = interfaceInfoService.update(request);
        return MessageManager.getMessage("log.I00002", new String[] { apiName, String.valueOf(writeResult) });
    }

    /**
     * 保存相关信息
     *
     * @return
     */
    @ApiOperation(value = "Log保存",
        notes = "保存Log相关信息")
    @RequestMapping(value = "/log/interface/_save",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public String save(@RequestBody LogInterfaceDoc request) {
        boolean flag = interfaceInfoService.save(request);
        String var = flag ? "成功" : "失败";
        return MessageManager.getMessage("log.I00001", new String[] { apiName, var });
    }

    /**
     * 删除相关信息
     *
     * @return
     */
    @ApiOperation(value = "Log删除",
        notes = "删除Log相关信息")
    @RequestMapping(value = "/log/interface/_delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = DelInterfaceLogValidator.class)
    public String delete(@RequestBody ArrayList<String> request) {
        int writeResult = interfaceInfoService.delete(request);
        return MessageManager.getMessage("log.I00003", new String[] { apiName, String.valueOf(writeResult) });
    }

    @ApiOperation(value = "Log重发",
        notes = "重发Log相关信息")
    @RequestMapping(value = "/log/interface/_repeat",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = RepeatInterfaceLogValidator.class)
    public String repeat(@RequestBody LogInterfaceDoc request) {
        AbstractTemplate abstractTemplate = templateFactory.getTemplete(request.getSystemName());
        String result = abstractTemplate.post(request.getUrl(), request.getRequestBody());
        boolean flag = abstractTemplate.confirmResult(result);
        LogInterfaceDoc searchOne = new LogInterfaceDoc();
        searchOne.setLogId(request.getLogId());
        searchOne = interfaceInfoService.findOne(searchOne);
        LogHistoryDoc history = new LogHistoryDoc();
        BeanUtils.copyProperties(searchOne, history);
        interfaceInfoService.saveHistory(history);
        LogInterfaceDoc update = new LogInterfaceDoc();
        update.setLogId(request.getLogId());
        update.setRequestBody(request.getRequestBody());
        update.setResponseBody(result);
        update.setResponseState(String.valueOf(flag));
        Date date = new Date(System.currentTimeMillis());
        update.setRequestTime(date);
        update.setUpdTime(date);
        int writeResult = interfaceInfoService.update(update);
        return MessageManager.getMessage("log.I00002", new String[] { apiName, String.valueOf(writeResult) });
    }
}

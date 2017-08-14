package com.msk.mail.rest;

import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import com.msk.mail.bean.MailParam;
import com.msk.mail.bean.RestRequest;
import com.msk.mail.bean.RestResponse;
import com.msk.mail.services.TemplateMailService;
import com.msk.mail.validation.TemplateMailValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * @author zhou_yajun
 * @version 1.0
 */
@RestController
@Api(value = "mail-api",
        description = "模板邮件发送",
        position = 5,
        tags = "TemplateMailRestController")
public class TemplateMailRestController extends BaseRestController {
    private static Logger logger = LoggerFactory.getLogger(TemplateMailRestController.class);
    @Autowired
    private TemplateMailService templateMailService;
    @RequestMapping(value = "text/mail/template/_send",method = RequestMethod.POST)
    @ApiOperation(value = "模板邮件发送",
            notes = "模板邮件发送",
            position = 5)
    @Validator(validatorClass = TemplateMailValidation.class)
    public @ResponseBody RestResponse<String> sendTextMail(@RequestBody RestRequest<MailParam> requestBody){
        RestResponse<String> response = new RestResponse<>();
        String returnCode = "200";
        String status = "S";
        String message = "邮件已经发送";
        String result = "邮件发送成功";
        logger.info("模板邮件发送开始");
        String mailStatus = templateMailService.templateMailSend(requestBody.getParam());
        logger.info("模板邮件发送状态：{},S-代表成功，F-代表失败",mailStatus);
        if("F".equals(mailStatus)){
            returnCode = "500";
            status = "F";
            message = "邮件发送失败";
            result = "邮件发送失败";
        }
        response.setReturnCode(returnCode);
        response.setStatus(status);
        response.setMessage(message);
        response.setResult(result);
        logger.info("模板邮件发送结束");
        return response;
    }
}

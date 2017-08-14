package com.msk.mail.rest;

import com.framework.boot.base.BaseRestController;
import com.framework.validator.annotation.Validator;
import com.msk.mail.bean.MailParam;
import com.msk.mail.bean.RestRequest;
import com.msk.mail.bean.RestResponse;
import com.msk.mail.services.SimpleMailService;
import com.msk.mail.validation.MailValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 简单邮件发送
 *
 * @author liu_tao2
 * @version 1.0
 */
@Api(value = "mail-api",
        description = "简单邮件发送",
        position = 5,
        tags = "SimpleMailRestController")
@RestController
public class SimpleMailRestController extends BaseRestController {

    private static Logger logger = LoggerFactory.getLogger(SimpleMailRestController.class);
    @Autowired
    private SimpleMailService simpleMailService;

    @ApiOperation(value = "发送简单邮件",
            notes = "发送简单邮件",
            position = 5)
    @RequestMapping(value = "text/mail/simple/_send",method = RequestMethod.POST)
    @Validator(validatorClass = MailValidation.class)
    public @ResponseBody RestResponse<String> sendTextMail(@RequestBody RestRequest<MailParam> requestBody){
        RestResponse<String> response = new RestResponse<>();
        logger.info("发送简单邮件开始");
        String status = simpleMailService.sendSimpleMail(requestBody.getParam());
        logger.info("发送简单邮件状态：{}，S-代表成功，F-代表失败",status);
        if(status.equals("S")){
            response.setReturnCode("200");
            response.setStatus(status);
            response.setMessage("邮件已经发送");
            response.setResult("邮件发送成功");
        }else {
            response.setReturnCode("500");
            response.setStatus(status);
            response.setMessage("邮件发送失败");
            response.setResult("邮件发送失败");
        }
        logger.info("发送简单邮件结束");
        return response;
    }
}

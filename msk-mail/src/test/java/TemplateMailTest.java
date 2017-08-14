import com.msk.mail.Application;
import com.msk.mail.bean.MailParam;
import com.msk.mail.services.HtmlMailService;
import com.msk.mail.services.TemplateMailService;
import com.msk.mail.services.impl.TemplateMailServicesImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou_yajun on 2016/11/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class TemplateMailTest {

    @Autowired
    TemplateMailService templateMailService;

    @Autowired
    HtmlMailService htmlMailService;
    @Test
    public void templateMailTestWithOutAttach(){
        MailParam mailParam = new MailParam();
        //主题
        mailParam.setSubject("templateTest");
        //接收邮件
        String[] to = new String[2];
        to[0] = "dai_youcheng@Hoperun.com";
        to[1] = "mao_yejun@hoperun.com";
        mailParam.setMailTo(to);
        //抄送邮件
        String[] cc = new String[2];
        cc[0] = "zhang_jian3@hoperun.com";
        cc[1] = "zhu_kai1@hoperun.com";
        mailParam.setMailCC(cc);
        //模板数据
        Map<String,String> templateData = new HashMap<>();
        templateData.put("username","hello");
        mailParam.setTemplateData(templateData);
        mailParam.setTemplateName("template.vm");
        templateMailService.templateMailSend(mailParam);
    }

    @Test
    public void MailTestWithAttach() throws Exception{
        MailParam mailParam = new MailParam();
        //主题
        mailParam.setSubject("templateTest");
        //接收邮件
        String[] to = new String[2];
        to[0] = "dai_youcheng@Hoperun.com";
        to[1] = "mao_yejun@hoperun.com";
        mailParam.setMailTo(to);
        //抄送邮件
        String[] cc = new String[2];
        cc[0] = "zhang_jian3@hoperun.com";
        cc[1] = "zhu_kai1@hoperun.com";
        mailParam.setMailCC(cc);
        mailParam.setContent("测试附件22");
        Map<String ,InputStream> attachment = new HashMap<>();
        File file = new File("C:\\Users\\zhu_kai1.HOPERUN-DOMAIN\\Desktop\\temp\\common.js");
        InputStream inputStream = new FileInputStream(file);
        attachment.put("common.txt",inputStream);
        mailParam.setAttachment(attachment);
       htmlMailService.sentHtmlMail(mailParam);
    }
}

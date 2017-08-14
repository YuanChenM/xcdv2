package com.bms.template;

import com.bms.constant.ThirdPartSys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mao_yejun on 2017/5/8.
 */
@Service
public class TemplateFactory {
    @Autowired
    private FmsTemplate fmsTemplate;

    public AbstractTemplate getTemplete(String sys) {
        if (sys.equals(ThirdPartSys.FMS.name())) {
            return fmsTemplate;
        }
        return null;
    }


}

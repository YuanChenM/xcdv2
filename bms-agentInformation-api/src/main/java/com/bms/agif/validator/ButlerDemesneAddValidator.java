package com.bms.agif.validator;

import com.bms.agif.bean.param.ButlerDemesneRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.ArrayList;

/**
 * Created by tao_zhifa on 2017/3/10.
 */
public class ButlerDemesneAddValidator extends DefaultCustomValidator<ArrayList<ButlerDemesneRsParam>> {

    @Override
    public void validator(ArrayList<ButlerDemesneRsParam> butlerDemesneRsList) {
        if(!CollectionUtils.isEmpty(butlerDemesneRsList)){
            for(int i=0,size = butlerDemesneRsList.size();i<size;i++){
                if (butlerDemesneRsList.get(i) != null) {
                    this.validatorLong(i+1,"AGIF.L02033", butlerDemesneRsList.get(i).getAgentDemesneId(), true, Long.MAX_VALUE, 0L, 4);
                    this.validatorMaxLength(i+1,"AGIF.L02012", butlerDemesneRsList.get(i).getButlerId(), true, 36);
                } else {
                    this.validatorRequired("error.20002", null);
                }
            }
        }else {
            this.validatorRequired("error.20002", null);
        }


    }
}

package com.framework.number.generate;

import com.framework.number.generate.bean.param.GenerateParam;
import com.framework.number.generate.impl.UUIDGenerate;
import com.framework.number.generate.bean.param.SequenceParam;
import com.framework.number.generate.bean.param.TimestampParam;
import com.framework.number.generate.impl.SequencesGenerate;
import com.framework.number.generate.impl.TimestampGenerate;

/**
 * Created by zhu_kai1 on 2016/11/14.
 */
public class GenerateContext {

    private NumberGenerate numberGenerate;

    public String generateNumber(GenerateParam generateParam){
        if(generateParam instanceof SequenceParam){
            numberGenerate = new SequencesGenerate();
        }else if(generateParam instanceof TimestampParam){
            numberGenerate = new TimestampGenerate();
        }else{
            this.numberGenerate = new UUIDGenerate();
        }
        return numberGenerate.generateNumber(generateParam);
    }

}

package com.framework.number.generate.impl;

import java.util.UUID;

import com.framework.number.generate.NumberGenerate;
import com.framework.number.generate.bean.param.GenerateParam;

/**
 * Created by zhu_kai1 on 2016/11/14.
 */
public class UUIDGenerate implements NumberGenerate<GenerateParam> {
    @Override
    public String generateNumber(GenerateParam param) {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}

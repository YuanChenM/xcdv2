package com.framework.number.generate.impl;

import com.framework.core.utils.DateUtils;
import com.framework.number.generate.NumberGenerate;
import com.framework.number.generate.bean.param.TimestampParam;

import java.util.Date;

public class TimestampGenerate implements NumberGenerate<TimestampParam> {
    @Override
    public String generateNumber(TimestampParam param) {
        Date currentDate = DateUtils.getCurrent();
        return DateUtils.format(param.getFormat(),currentDate);
    }
}

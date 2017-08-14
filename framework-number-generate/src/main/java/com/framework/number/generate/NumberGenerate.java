package com.framework.number.generate;

import com.framework.number.generate.bean.param.GenerateParam;

/**
 * 单据生成接口,不同的单据类型生成不同的字符串规则
 * @author jiang_nan
 * @version 1.0
 * @see com.framework.number.generate.impl.SequencesGenerate
 * @see com.framework.number.generate.impl.TimestampGenerate
 * @see com.framework.number.generate.impl.UUIDGenerate
 * @param <T> 单据参数
 */
public interface NumberGenerate<T extends GenerateParam> {
    /**
     * 根据不同的Param生成不同的单据号
     * @param param 单据生成规则参数
     * @return 单据号
     */
    String generateNumber(T param);
}

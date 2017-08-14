package com.framework.number.generate.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.framework.base.consts.DateFormatDef;
import com.framework.base.consts.NumberConst;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.number.generate.NumberGenerate;
import com.framework.number.generate.database.BaseDao;
import com.framework.number.generate.database.DaoFactory;
import com.framework.number.generate.bean.param.SequenceParam;
import com.framework.number.generate.bean.result.SequenceResult;
import com.framework.number.generate.enums.ResetType;

/**
 * Created by jackjiang on 16/11/21.
 */
public class SequencesGenerate implements NumberGenerate<SequenceParam> {
    private BaseDao baseDao;
    public SequencesGenerate() {
        this.baseDao = DaoFactory.getBaseDao();
    }

    /**
     *
     * @param param 单据生成规则参数
     * @return
     */
    @Override
    public String generateNumber(SequenceParam param) {
        String prefix = param.getPrefix();
        int length = param.getLength();
        SequenceResult sequenceResult = baseDao.get(prefix);
        //获得最新的Sequence
        long sequence = baseDao.sequence(prefix);
        if (!this.isInit(sequenceResult)) {
            String updateTime = sequenceResult.getCreateDate();
            ResetType resetType = sequenceResult.getResetType();
            if (this.isReset(updateTime, resetType)) {
                baseDao.backUp(prefix);
                baseDao.reset(prefix);
            }
        } else {
            Map<String, String> sequencesMap = this.createSequencesParam();
            sequencesMap.put(BaseDao.INDEX_KEY, String.valueOf(sequence));
            baseDao.set(prefix, sequencesMap);
        }

        StringBuffer strSequence = new StringBuffer();
        if (param.isPlaceholder()) {
            //补位符
            String padChar = param.getPadChar();
            strSequence.append(this.placeholder(sequence, length, padChar));
        } else {
            strSequence.append(sequence);
        }
        this.baseDao.put(prefix, sequence);
        baseDao.close();
        return strSequence.toString();
    }

    public void initSequencesDatabase(String[] keyArray) {
        Map<String, String> sequencesMap = this.createSequencesParam();
        for (String key : keyArray) {
            if (baseDao.get(key) != null) {
                continue;
            }
            baseDao.set(key, sequencesMap);
        }
        baseDao.close();
    }

    private boolean isInit(SequenceResult sequenceResult){
        return (sequenceResult == null || sequenceResult.getIndex() == NumberConst.IntDef.INT_ZERO);
    }

    private Map<String, String> createSequencesParam() {
        String currentDate = DateUtils.fmtCurrent();
        Map<String, String> sequencesMap = new HashMap<>();
        sequencesMap.put(BaseDao.CREATE_TIME_KEY, currentDate);
        sequencesMap.put(BaseDao.UPDATE_TIME_KEY, currentDate);
        sequencesMap.put(BaseDao.RESET_KEY, "Day");
        sequencesMap.put(BaseDao.INDEX_KEY, "0");
        return sequencesMap;
    }


    private boolean isReset(String createTime, ResetType resetType) {
        Date updateDate = null;
        Date currentDate = null;
        if (resetType.equals(ResetType.Day)) {
            updateDate = DateUtils.parse(DateFormatDef.FORMAT_DATE_YYYYMMDD, createTime);
            currentDate = DateUtils.getToday();
        }

        return updateDate.before(currentDate);
    }

    private String placeholder(long sequence, int length, String padChar) {
        return StringUtils.leftPad(String.valueOf(sequence), length, padChar);
    }


}

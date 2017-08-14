/*
 * 2016/12/14 自动生成 新規作成
 * (c) 江苏润和.
 */
package com.bms.bymt.services.impl;

import com.bms.bymt.bean.entity.BymtTermGradeResult;
import com.bms.bymt.bean.entity.BymtTerminalMarketBasic;
import com.bms.bymt.bean.param.BaseBean;
import com.bms.bymt.bean.param.TermGradeResultParam;
import com.bms.bymt.bean.param.TerminalMarketBasicRsParam;
import com.bms.bymt.dao.BymtTermGradeResultDao;
import com.bms.bymt.services.BymtTermGradeResultService;
import com.bms.bymt.services.BymtTerminalMarketBasicService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * BymtTermGradeResultService接口实现类。
 * </p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class BymtTermGradeResultServiceImpl extends BaseServiceImpl implements BymtTermGradeResultService {

    @Autowired
    private BymtTermGradeResultDao bymtTermGradeResultDao;

    @Autowired
    private BymtTerminalMarketBasicService bymtTerminalMarketBasicService;

    @Override
    public BaseDao getBaseDao() {
        return bymtTermGradeResultDao;
    }

    @Override
    public long addTermGradeResult(TermGradeResultParam reqParam) {
        // 判断详情ID是否存在 == 0表示存在 不存在直接新增 否则先删除在新增
        if (reqParam.getGradeResultId() != null && reqParam.getGradeInfoId() != null && NumberUtils.compare(reqParam.getGradeInfoId().longValue(), 0L) == 1) {
            BymtTermGradeResult bymtTermGradeResult = new BymtTermGradeResult();
            bymtTermGradeResult.setGradeInfoId(reqParam.getGradeInfoId());
            bymtTermGradeResult.setDelFlg(true);
            this.modify(bymtTermGradeResult);
        }
        BymtTermGradeResult filter = BeanUtils.toBean(reqParam, BymtTermGradeResult.class);
        Long gradeResultId = this.maxId("BYMT_TERM_GRADE_RESULT");
        filter.setGradeResultId(gradeResultId);
        filter.setCrtId(getLoginUserId());
        filter.setUpdId(getLoginUserId());
        filter.setUpdTime(DateUtils.getCurrent());
        filter.setCrtTime(DateUtils.getCurrent());
        // 修改编码
        BymtTerminalMarketBasic basic = this.getTerminalMarketInfo(reqParam.getTermMarketId(),reqParam.getTermMarketLevel());
        if(basic != null){
            List<BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam>> list = new ArrayList<>();
            BaseBean<TerminalMarketBasicRsParam, TerminalMarketBasicRsParam> bean = new BaseBean<>();
            TerminalMarketBasicRsParam terFilter = new TerminalMarketBasicRsParam();
            terFilter.setTermMarketId(basic.getTermMarketId());
            TerminalMarketBasicRsParam terTarget = BeanUtils.toBean(basic,TerminalMarketBasicRsParam.class);
            bean.setTarget(terTarget);
            bean.setFilter(terFilter);
            list.add(bean);
            bymtTerminalMarketBasicService.updateTerminalMarketBasic(list);
        }
         this.save(filter);

         return gradeResultId;
    }

    // 用与判定批发市场级别是否变动
    public BymtTerminalMarketBasic getTerminalMarketInfo(String terminalMarketId,String termMarketLevel){
        BymtTerminalMarketBasic basic = new BymtTerminalMarketBasic();
        basic.setTermMarketId(terminalMarketId);
        BymtTerminalMarketBasic resutl = bymtTerminalMarketBasicService.findOne(basic);
        if(resutl != null && !termMarketLevel.equals(resutl.getTermMarketLevel())){
            resutl.setTermMarketLevel(termMarketLevel);
            return resutl;
        }
        return null;
    }
}
/*
 * 2016/12/14 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.bymt.dao;

import com.bms.bymt.bean.param.TermGradeInfoParam;
import com.bms.bymt.bean.result.TerminalModuleDefGradeResult;
import com.framework.boot.base.BaseDao;

/**
 * <p>BymtTermGradeInfoDao接口。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
public interface BymtTermGradeInfoDao extends BaseDao {

    TerminalModuleDefGradeResult getDefineGrade(TermGradeInfoParam gradeInfoParam);
}
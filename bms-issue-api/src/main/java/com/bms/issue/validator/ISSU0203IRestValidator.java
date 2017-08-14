package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0203IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;

import java.util.List;

/**
 * 问题订单问题修改接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0203IRestValidator extends IssueValidator<BusinessRestParam<ISSU0203IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0203IBean> param) {
        RestOperator restOperator = param.getOperator();
        this.validateOperator(restOperator);
        List<ISSU0203IBean> list = param.getBeans();
        this.validateBeans(list);
        if (CollectionUtils.isNotEmpty(list)) {
            for (ISSU0203IBean bean : list) {
                Long questionId = bean.getQuestionId();
                this.validateQuestionId(questionId, true);
                Long issueId = bean.getIssueId();
                this.validateIssueId(issueId, true);
                Long orderDetailId = bean.getOrderDetailId();
                this.validateOrderDetailId(orderDetailId, false);
                String questionCatagory1 = bean.getQuestionCatagory1();
                this.validateQuestionCatagory1(questionCatagory1, false);
                String questionCatagory2 = bean.getQuestionCatagory2();
                this.validateQuestionCatagory2(questionCatagory2, false);
                String questionCatagory3 = bean.getQuestionCatagory3();
                this.validateQuestionCatagory3(questionCatagory3, false);
                String questionKeyword = bean.getQuestionKeyword();
                this.validateQuestionKeyword(questionKeyword, false);
                String questionDesc = bean.getQuestionDesc();
                this.validateIssueDesc(questionDesc, false);
                String questionStartTime = bean.getQuestionStartTime();
                this.validateQuestionStartTime(questionStartTime, false);
                String questionStartUid = bean.getQuestionStartUid();
                this.validateQuestionStartUid(questionStartUid, false);
                String questionStartUname = bean.getQuestionStartUname();
                this.validateQuestionStartUname(questionStartUname, false);
                Integer version = bean.getVersion();
                this.validateVersion(version, true);
                List<ISSU0203IBean.ISSU0203Accessory> accessorys = bean.getAccessorys();
                if (CollectionUtils.isNotEmpty(accessorys)) {
                    for (ISSU0203IBean.ISSU0203Accessory accessory : accessorys) {
                        this.validateQuestionId(accessory.getQuestionId(), true);
                        Boolean removeFlag = null;
                        Boolean delFlg = accessory.getDelFlg();//0:false 不删除  1:true 删除
                        if (delFlg != null && delFlg) {// 删除
                            removeFlag = true;
                        } else {// 新增
                            removeFlag = false;
                        }
                        this.validateAccessoryId(accessory.getAccessoryId(), removeFlag);
                        this.validateVersion(accessory.getVersion(), removeFlag);
                        this.validateDelFlg(accessory.getDelFlg(),removeFlag);
                        this.validateFileId(accessory.getFileId(),! removeFlag);
                        this.validateFileName(accessory.getFileName(),! removeFlag);
                        this.validateFileType(accessory.getFileType(),! removeFlag);

                    }
                }
            }
        }
    }
}

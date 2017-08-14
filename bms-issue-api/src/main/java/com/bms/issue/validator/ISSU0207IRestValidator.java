package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0203IBean;
import com.bms.issue.bean.param.ISSU0207IBean;
import com.bms.issue.common.rest.BusinessRestParam;
import com.bms.issue.common.rest.param.RestOperator;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.StringUtils;

import java.util.List;

/**
 * 问题点编辑接口Validator
 *
 * @author li_huiqian
 */
public class ISSU0207IRestValidator extends IssueValidator<BusinessRestParam<ISSU0207IBean>> {
    @Override
    public void validator(BusinessRestParam<ISSU0207IBean> param) {
        RestOperator restOperator = param.getOperator();
        this.validateOperator(restOperator);
        List<ISSU0207IBean> list = param.getBeans();
        this.validateBeans(list);
        if (CollectionUtils.isNotEmpty(list)) {
            for (ISSU0207IBean bean : list) {
                Long itemId = bean.getItemId();
                this.validateItemId(itemId, true);
                Long questionId = bean.getQuestionId();
                this.validateQuestionId(questionId, true);
                String itemDesc = bean.getItemDesc();
                this.validateItemDesc(itemDesc, false);
                String itemSolution = bean.getItemSolution();
                this.validateItemSolution(itemSolution, false);
                String itemExcutor = bean.getItemExcutor();
                this.validateItemExcutor(itemExcutor, false);
                String itemStartTime = bean.getItemStartTime();
                this.validateItemStartTime(itemStartTime, false);
                String itemEndTime = bean.getItemEndTime();
                this.validateItemEndTime(itemEndTime, false);
                String itemResult = bean.getItemResult();
                this.validateItemResult(itemResult, false);
                String itemFeedBack = bean.getItemFeedBack();
                this.validateItemFeedback(itemFeedBack, false);
                String itemCloser = bean.getItemCloser();
                this.validateItemCloser(itemCloser, false);
                String itemCloseTime = bean.getItemCloseTime();
                this.validateCloseTime(itemCloseTime, false);
                Integer version = bean.getVersion();
                this.validateVersion(version, true);
                List<ISSU0207IBean.ISSU0207Accessory> accessorys = bean.getAccessorys();
                if (CollectionUtils.isNotEmpty(accessorys)) {
                    for (ISSU0207IBean.ISSU0207Accessory accessory : accessorys) {
                        this.validateQuestionId(accessory.getQuestionId(), true);
                        this.validateItemId(accessory.getItemId(), true);
                        Boolean removeFlag = null;
                        Boolean delFlg = accessory.getDelFlg();//0:false 不删除  1:true 删除
                        if (delFlg != null && delFlg) {// 删除
                            removeFlag = true;
                        } else {// 新增
                            removeFlag = false;
                        }
                        this.validateAccessoryId(accessory.getAccessoryId(), removeFlag);
                        this.validateVersion(accessory.getVersion(), removeFlag);
                        this.validateDelFlg(accessory.getDelFlg(), removeFlag);
                        this.validateFileId(accessory.getFileId(), !removeFlag);
                        this.validateFileName(accessory.getFileName(), !removeFlag);
                        this.validateFileType(accessory.getFileType(), !removeFlag);
                    }
                }

            }
        }
    }
}

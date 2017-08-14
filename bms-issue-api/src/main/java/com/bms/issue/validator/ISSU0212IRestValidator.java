package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0212IFilter;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.constant.ValidatorConst;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0212IRestValidator extends IssueValidator<SearchRestParam<ISSU0212IFilter>>{

    @Override
    public void validator(SearchRestParam<ISSU0212IFilter> param) {

        this.validateOperator(param.getOperator());

        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ISSU0212I_MAX_VALUE_PAGING_LEVEL);

        ISSU0212IFilter filter = param.getFilter();

        if(null != filter){
            if(null != filter.getQuestionId()){
                for(Long questionId : filter.getQuestionId()){
                    this.validateQuestionId(questionId,true);
                }
            }

            if(null != filter.getHandlingId()){
                for(Long handlingId : filter.getHandlingId()){
                    this.validateHandlingId(handlingId,true);
                }
            }

            if(null != filter.getHandlingType()){
                for(String handlingType : filter.getHandlingType()){
                    this.validateHandlingType(handlingType,true);
                }
            }

            if(null != filter.getHandlingUid()){
                for(String handlingUid : filter.getHandlingUid()){
                    this.validateHandlingUid(handlingUid,true);
                }
            }

            this.validateHandlingContent(filter.getHandlingContent(),false);

            this.validateHandlingTimeFrom(filter.getHandlingTimeFrom(),false);

            this.validateHandlingTimeTo(filter.getHandlingTimeTo(),false);

            this.validateHandlingUname(filter.getHandlingUname(),false);

            this.validateHandlingResult(filter.getHandlingResult(),false);

            this.validateHandlingResultReason(filter.getHandlingResultReason(),false);
        }
    }
}

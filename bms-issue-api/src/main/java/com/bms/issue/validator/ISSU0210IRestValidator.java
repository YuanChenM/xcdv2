package com.bms.issue.validator;


import com.bms.issue.bean.param.ISSU0210IFilter;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.constant.ValidatorConst;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ISSU0210IRestValidator extends IssueValidator<SearchRestParam<ISSU0210IFilter>>{

    @Override
    public void validator(SearchRestParam<ISSU0210IFilter> param) {

        this.validateOperator(param.getOperator());

        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ISSU0210I_MAX_VALUE_PAGING_LEVEL);

        ISSU0210IFilter filter = param.getFilter();

        if(null != filter){
            if(null != filter.getIssueId()){
                for(Long issueId : filter.getIssueId()){
                    this.validateIssueId(issueId,true);
                }
            }

            if(null != filter.getQuestionId()){
                for(Long questionId : filter.getQuestionId()){
                    this.validateQuestionId(questionId,true);
                }
            }

            if(null != filter.getAccessoryId()){
                for(Long accessoryId : filter.getAccessoryId()){
                    this.validateAccessoryId(accessoryId,true);
                }
            }

            //这里需要共同代码修改
            if(null != filter.getFileId()){
                for(String fileId : filter.getFileId()){
                    this.validateFileId(fileId,true);
                }
            }

            this.validateQuestionCode(filter.getQuestionCode(),false);

            this.validateQuestionKeyword(filter.getQuestionKeyword(),false);

            this.validateQuestionStartUname(filter.getQuestionStartUname(),false);

            this.validateQuestionCloseUname(filter.getQuestionCloseUname(),false);

            this.validateQuestionStartTimeFrom(filter.getQuestionStartTimeFrom(),false);

            this.validateQuestionStartTimeTo(filter.getQuestionStartTimeTo(),false);

            this.validateQuestionIsClose(filter.getQuestionIsClose(),false);

            this.validateQuestionCloseTimeFrom(filter.getQuestionCloseTimeFrom(),false);

            this.validateQuestionCloseTimeTo(filter.getQuestionCloseTimeTo(),false);

            this.validateOrderCode(filter.getOrderCode(),false);
        }
    }
}

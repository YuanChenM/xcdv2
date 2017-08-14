package com.bms.issue.validator;

import com.bms.issue.bean.param.ISSU0211IFilter;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.constant.ValidatorConst;

/**
 * Created by Administrator on 2017/2/21.
 */
public class ISSU0211IRestValidator extends IssueValidator<SearchRestParam<ISSU0211IFilter>> {

    @Override
    public void validator(SearchRestParam<ISSU0211IFilter> param) {

        this.validateOperator(param.getOperator());

        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ISSU0211I_MAX_VALUE_PAGING_LEVEL);

        ISSU0211IFilter filter = param.getFilter();

        if(null != filter){
            if(null != filter.getQuestionId()){
                for(Long questionId : filter.getQuestionId()){
                    this.validateQuestionId(questionId,true);
                }
            }

            if(null != filter.getItemId()){
                for(Long itemId : filter.getItemId()){
                    this.validateItemId(itemId,true);
                }
            }

            if(null != filter.getAccessoryId()){
                for(Long accessoryId : filter.getAccessoryId()){
                    this.validateAccessoryId(accessoryId,true);
                }
            }

            if(null != filter.getFileId()){
                for(String fileId : filter.getFileId()){
                    this.validateFileId(fileId,true);
                }
            }

            this.validateItemDesc(filter.getItemDesc(),false);

            this.validateItemSolution(filter.getItemSolution(),false);

            this.validateItemExcutor(filter.getItemExcutor(),false);

            this.validateItemStartTimeFrom(filter.getItemStartTimeFrom(),false);

            this.validateItemStartTimeTo(filter.getItemStartTimeTo(),false);

            this.validateItemEndTimeFrom(filter.getItemEndTimeFrom(),false);

            this.validateItemEndTimeTo(filter.getItemEndTimeTo(),false);

            this.validateItemResult(filter.getItemResult(),false);

            this.validateItemFeedback(filter.getItemFeedBack(),false);

            this.validateItemCloser(filter.getItemCloser(),false);

            this.validateItemCloseTimeFrom(filter.getItemCloseTimeFrom(),false);

            this.validateItemCloseTimeTo(filter.getItemCloseTimeTo(),false);
        }
    }
}

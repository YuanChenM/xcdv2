package com.bms.issue.validator;

import com.bms.issue.archive.impl.Operator;
import com.bms.issue.bean.param.ISSU0105IFilter;
import com.bms.issue.common.rest.SearchRestParam;
import com.bms.issue.constant.ValidatorConst;

/**
 * 问题订单查询接口Validator
 * 
 * @author li_huiqian
 */
public class ISSU0105IRestValidator extends IssueValidator<SearchRestParam<ISSU0105IFilter>> {
    @Override
    public void validator(SearchRestParam<ISSU0105IFilter> param) {
        this.validateOperator(param.getOperator());
        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ISSU0105I_MAX_VALUE_PAGING_LEVEL);
        ISSU0105IFilter filter = param.getFilter();
        if(null != filter){
            if(null != filter.getIssueId()){
                for(Long issueId : filter.getIssueId()){
                    this.validateIssueId(issueId,true);
                }
            }

            this.validateIssueCode(filter.getIssueCode(),false);

            if(null != filter.getInitiatorType()){
                for(String initiatorType : filter.getInitiatorType()){
                    this.validateInitiatorType(initiatorType,true);
                }
            }

            this.validateInitiatorName(filter.getInitiatorName(),false);

            this.validateInitiateTimeFrom(filter.getInitiatorTimeFrom(),false);

            this.validateInitiateTimeTo(filter.getInitiatorTimeTo(),false);

            this.validateCloseTimeFrom(filter.getCloseTimeFrom(),false);

            this.validateCloseTimeTo(filter.getCloseTimeTo(),false);

            this.validateIssueDesc(filter.getIssueDesc(),false);

            if(null != filter.getIssueStatus()){
                for(String issueStatus : filter.getIssueStatus()){
                    this.validateIssueStatus(issueStatus,true);
                }
            }

            this.validateOrderCode(filter.getOrderCode(),false);

            if(null != filter.getOrderId()){
                for(Long orderId : filter.getOrderId()){
                    this.validateOrderId(orderId,true);
                }
            }

            if(null != filter.getBuyerId()){
                for(String buyerId : filter.getBuyerId()){
                    this.validateBuyerId(buyerId,true);
                }
            }

            this.validateBuyerCode(filter.getBuyerCode(),false);

            if(null != filter.getLogisticsZoneId()){
                for(Long logisticsZoneId : filter.getLogisticsZoneId()){
                    this.validateLogisticsZoneId(logisticsZoneId,true);
                }
            }
        }
    }
}

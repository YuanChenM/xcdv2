package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0807IFilter;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.constant.ValidatorConst;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * 买家退货信息查询接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0807IRestValidator extends OrderValidator<SearchRestParam<ORDR0807IFilter>> {

    @Override
    public void validator(SearchRestParam<ORDR0807IFilter> param) {
        this.validateOperator(param.getOperator());
        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ORDR0807I_MAX_VALUE_PAGING_LEVEL);

        ORDR0807IFilter filter = param.getFilter();

        if(null != filter){
            if(null != filter.getReturnId()){
                for(Long returnId : filter.getReturnId()){
                    this.validateReturnId(returnId,false);
                }
            }

            this.validateReturnCode(filter.getReturnCode(),false);

            this.validateOrderId(filter.getOrderId(),false);

            this.validateBuyerOrderCode(filter.getOrderCode(),false);

            if(null != filter.getLogisticsZoneId()){
                for(Long logisticsZoneId : filter.getLogisticsZoneId()){
                    this.validateLogisticsZoneId(logisticsZoneId,false);
                }
            }

            this.validateLogisticsZoneCode(filter.getLogisticsZoneCode(),false);

            if(null != filter.getBuyerId()){
                for(String buyerId : filter.getBuyerId()){
                    this.validateBuyerId(buyerId,false);
                }
            }

            this.validateBuyerCode(filter.getBuyerCode(),false);

            this.validateBuyerName(filter.getBuyerName(),false);

            if(!StringUtils.isEmpty(filter.getApplyUserType())){
                this.validateBuyerApplyUserType(filter.getApplyUserType(),false);
            }

            this.validateApplyUid(filter.getApplyUserId(),false);

            this.validateApplyUname(filter.getApplyUserName(),false);

            this.validateApplyTimeFrom(filter.getApplyTimeFrom(),false);

            this.validateApplyTimeTo(filter.getApplyTimeTo(),false);

            if(!StringUtils.isEmpty(filter.getReturnType())){
                this.validateBuyerReturnType(filter.getReturnType(),false);
            }

            if(!StringUtils.isEmpty(filter.getReturnStatus())){
                this.validateBuyerReturnStatus(filter.getReturnStatus(),false);
            }
        }
    }
}

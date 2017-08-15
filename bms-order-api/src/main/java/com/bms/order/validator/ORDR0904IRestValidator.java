package com.bms.order.validator;

import com.bms.order.bean.param.ORDR0904IFilter;
import com.bms.order.common.rest.SearchRestParam;
import com.bms.order.constant.ValidatorConst;
import com.framework.core.utils.StringUtils;
import com.framework.validator.DefaultCustomValidator;

/**
 * 买手退货信息查询接口Validator
 * 
 * @author li_huiqian
 */
public class ORDR0904IRestValidator extends OrderValidator<SearchRestParam<ORDR0904IFilter>> {
    @Override
    public void validator(SearchRestParam<ORDR0904IFilter> param) {

        this.validateOperator(param.getOperator());
        this.validatorPagination(param.getPagination(),param.getPagingLevel(), ValidatorConst.ORDR0904I_MAX_VALUE_PAGING_LEVEL);

        ORDR0904IFilter filter = param.getFilter();
        if(null != filter){
            if(null != filter.getReturnId()){
                for(Long returnId : filter.getReturnId()){
                    this.validateReturnId(returnId,false);
                }
            }

            this.validateReturnCode(filter.getReturnCode(),false);

            this.validateOrderId(filter.getOrderId(),false);

            this.validateBsOrderCode(filter.getOrderCode(),false);

            if(null != filter.getLogisticsZoneId()){
                for(Long logisticsZoneId : filter.getLogisticsZoneId()){
                    this.validateLogisticsZoneId(logisticsZoneId,false);
                }
            }

            this.validateLogisticsZoneCode(filter.getLogisticsZoneCode(),false);

            if(null != filter.getBsId()){
                for(String bsId : filter.getBsId()){
                    this.validateBsId(bsId,false);
                }
            }

            this.validateBsCode(filter.getBsCode(),false);

            this.validateBsName(filter.getBsName(),false);

            this.validateApplyUid(filter.getApplyUserId(),false);

            this.validateApplyUname(filter.getApplyUserName(),false);

            this.validateApplyTimeFrom(filter.getApplyTimeFrom(),false);

            this.validateApplyTimeTo(filter.getApplyTimeTo(),false);

            if(!StringUtils.isEmpty(filter.getReturnType())){
                this.validateBsReturnType(filter.getReturnType(),false);
            }

            if(!StringUtils.isEmpty(filter.getReturnStatus())){
                this.validateBsReturnStu(filter.getReturnStatus(),false);
            }
        }
    }
}

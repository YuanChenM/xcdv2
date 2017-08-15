package com.bms.order.external.archive;

import com.alibaba.fastjson.TypeReference;
import com.bms.order.constant.UrlConst;
import com.bms.order.constant.enumeration.AgentType;
import com.bms.order.constant.enumeration.SellSideType;
import com.bms.order.constant.enumeration.SellerSideRoleType;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.external.bean.entity.BsDemesneEntity;
import com.bms.order.external.bean.entity.SellerSideEntity;
import com.bms.order.external.bean.param.AGIF0205IRestParam;
import com.bms.order.external.bean.param.AGIF0209IRestParam;
import com.bms.order.external.bean.param.AGIF0212IRestParam;
import com.bms.order.external.bean.param.AGIF0401IRestParam;
import com.bms.order.external.bean.result.AGIF0205IRestResult;
import com.bms.order.external.bean.result.AGIF0209IRestResult;
import com.bms.order.external.bean.result.AGIF0212IRestResult;
import com.bms.order.external.bean.result.AGIF0401IRestResult;
import com.framework.base.rest.result.BaseRestPaginationResult;
import com.framework.core.utils.CollectionUtils;
import com.framework.exception.BusinessException;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 买手
 * Created by ni_shaotang on 2017/3/15.
 */
public class SellerSide extends AbstractExternalArchive {
    private SellerSideEntity entity;

    public SellerSideEntity getEntity() {
        return entity;
    }

    //禁止外部构建
    private SellerSide() {

    }

    /**
     * 根据买家ID获取买手及上级合伙人信息
     *
     * @return
     */
    public static List<SellerSideEntity> getSellerSideListByBuyer(String buyerId) {
        Assert.notNull(buyerId);
        SellerSideEntity sellerSideEntity = new SellerSideEntity();

        // 获取URL
        String url = UrlConst.API_AGIF_URL + UrlConst.ACTION_AGIF0212I;
        AGIF0212IRestParam param = new AGIF0212IRestParam();
        param.setAgentId(buyerId);
        SellerSide sellerSide = new SellerSide();
        List<SellerSideEntity> sellerSideList = new ArrayList<>();
        // 返回值类型
        TypeReference<ArrayList<AGIF0212IRestResult>> typeReference = new TypeReference<ArrayList<AGIF0212IRestResult>>() {
        };
        List<AGIF0212IRestResult> result = sellerSide.getRestClient().post(url, param, typeReference);

        if (CollectionUtils.isEmpty(result))
            return sellerSideList;

        // 设定卖方信息（买手及合伙人）
        for(AGIF0212IRestResult agif0212IRestResult : result) {
            if(SellerSideRoleType.AGENT.getCode().equals(agif0212IRestResult.getRoleType())
                    || SellerSideRoleType.PARTNER.getCode().equals(agif0212IRestResult.getRoleType())) {
                sellerSideEntity.setSellerSideId(agif0212IRestResult.getAgentId());
                sellerSideEntity.setSellerSideCode(agif0212IRestResult.getAgentcode());
                sellerSideEntity.setSellerSideName(agif0212IRestResult.getAgentname());
                sellerSideEntity.setSellerSideRole(SellSideType.AGENT_TYPE.getCode());

                sellerSide.entity = sellerSideEntity;
                sellerSideList.add(sellerSideEntity);
            }
        }
        return sellerSideList;
    }
}

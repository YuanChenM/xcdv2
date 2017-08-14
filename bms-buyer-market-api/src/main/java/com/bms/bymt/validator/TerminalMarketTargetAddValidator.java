package com.bms.bymt.validator;

import com.bms.bymt.bean.param.TerminalMarketTargetRsParam;
import com.framework.validator.DefaultCustomValidator;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tao_zhifa on 2016/12/15.
 */
public class TerminalMarketTargetAddValidator extends DefaultCustomValidator<ArrayList<TerminalMarketTargetRsParam>> {

    @Override
    public void validator(ArrayList<TerminalMarketTargetRsParam> marketTargetRsParams) {

        if (!CollectionUtils.isEmpty(marketTargetRsParams)) {
            List<TerminalMarketTargetRsParam> paramList = marketTargetRsParams;
            for (int i = 0, size = paramList.size(); i < size; i++) {
                this.validatorMaxLength(i + 1, "BYMT.L00019", paramList.get(i).getTermMarketId(), true, 36);
                this.validatorMaxLength(i + 1, "BYMT.L00014", paramList.get(i).getBuyerName(), true, 16);
                this.validatorMaxLength(i + 1, "BYMT.L00015", paramList.get(i).getProName(), true, 16);
                if (paramList.get(i).getBuyerNum() != null) {
                    this.validatorInteger(i + 1, "BYMT.L00016", paramList.get(i).getBuyerNum(), true, 2147483647, 0, 5);
                }
                if (paramList.get(i).getTradeAmount() != null) {
                    this.validatorDecimal(i + 1, "BYMT.L00017", paramList.get(i).getTradeAmount(), true, 15, 2, 5);
                }

            }
        } else {
            this.validatorRequired("error.20002", null);
        }

    }
}

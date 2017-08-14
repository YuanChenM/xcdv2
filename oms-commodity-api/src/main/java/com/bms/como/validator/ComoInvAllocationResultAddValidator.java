package com.bms.como.validator;

import com.bms.como.bean.param.AllocationResultRsParam;
import com.bms.como.bean.param.BatchStorageRsParam;
import com.bms.como.bean.param.ProductParam;
import com.bms.como.bean.param.WarehouseRsParam;
import com.framework.core.utils.CollectionUtils;
import com.framework.validator.DefaultCustomValidator;

import java.util.List;

/**
 * Created by yuan_zhifei on 2017/4/13.
 */
public class ComoInvAllocationResultAddValidator extends DefaultCustomValidator<AllocationResultRsParam> {
    @Override
    public void validator(AllocationResultRsParam rsParam) {
        if (rsParam != null) {
            this.validatorRequired("产品标签设置结果", rsParam.getSetLabelResult());
            this.validatorRequired("销售标签单据编号", rsParam.getOrderId());
            List<ProductParam> productList = rsParam.getProductList();
            if (CollectionUtils.isNotEmpty(productList)) {
                ProductParam productParam = null;
                for (int i = 0; i < productList.size(); i++) {
                    productParam = productList.get(i);
                    this.validatorRequired("货主编码", productParam.getSlCode());
                    this.validatorRequired("物流区编码", productParam.getLgcsCode());
                    this.validatorRequired("供应商编码", productParam.getSupplierCode());
                    this.validatorRequired("SKU编码", productParam.getSkuCode());
                    this.validatorRequired("产品单位（箱或者包）", productParam.getUnit());
                    this.validatorRequired("原销售标签", productParam.getOldLabel());
                    this.validatorRequired("新销售标签", productParam.getNewLabel());
                    List<WarehouseRsParam> whList = productParam.getWhList();
                    if (CollectionUtils.isNotEmpty(whList)) {
                        WarehouseRsParam warehouseRsParam = null;
                        for (int j = 0; j < whList.size(); j++) {
                            warehouseRsParam = whList.get(j);
                            this.validatorRequired("仓库编码", warehouseRsParam.getWhCode());
                            this.validatorRequired("仓库名称", warehouseRsParam.getWhName());
                            List<BatchStorageRsParam> lotList = warehouseRsParam.getLotList();
                            if (CollectionUtils.isNotEmpty(lotList)) {
                                BatchStorageRsParam batchStorageRsParam = null;
                                for (int k = 0; k < lotList.size(); k++) {
                                    batchStorageRsParam = lotList.get(k);
                                    this.validatorRequired("入库批次", batchStorageRsParam.getLotNo());
                                    this.validatorRequired("产品数量（对应单位箱或者包）", batchStorageRsParam.getAdjustQty());
                                }
                            } else {
                                this.validatorRequired("批次列表", null);
                            }
                        }
                    } else {
                        this.validatorRequired("仓库列表", null);
                    }
                }
            } else {
                this.validatorRequired("产品数据", null);
            }
        }
    }
}

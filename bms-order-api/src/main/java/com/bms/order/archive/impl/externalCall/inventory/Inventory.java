package com.bms.order.archive.impl.externalCall.inventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.springframework.util.CollectionUtils;

import com.bms.order.archive.impl.BsOrderDetail;
import com.bms.order.archive.impl.BuyerBatchOrderDetail;
import com.bms.order.archive.impl.BuyerForcastDeliverDetail;
import com.bms.order.archive.impl.list.BsOrderDetailList;
import com.bms.order.archive.impl.list.BsStockpileSplitDetailList;
import com.bms.order.archive.impl.list.BuyerBatchOrderDetailList;
import com.bms.order.archive.impl.list.BuyerForcastDeliverDetailList;
import com.bms.order.bean.externalCall.inventory.entity.InventoryAllocationEntity;
import com.bms.order.bean.externalCall.inventory.entity.InventoryQueryEntity;
import com.bms.order.bean.externalCall.inventory.param.AllocationSupplierInventoryRestParam;
import com.bms.order.bean.externalCall.inventory.param.QuerySupplierInvRestParam;
import com.bms.order.bean.externalCall.inventory.result.AllocationSupplierInventoryRestResult;
import com.bms.order.bean.externalCall.inventory.result.QuerySupplierInvRestResult;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.util.ExternalCallUtil;
import com.framework.exception.BusinessException;

/**
 * Created by zhang_qiang1 on 2017/1/6.
 */
public class Inventory {

    /**
     * 库存查询 平台 或是 卖家
     *
     * @param buyerBatchOrderDetailList
     * @return
     */
    public InventoryQueryEntity queryInventoryByBuyerOrderDetailList(
            BuyerBatchOrderDetailList buyerBatchOrderDetailList, boolean isPlatForm) {
        List<BuyerBatchOrderDetail> archives = buyerBatchOrderDetailList.getArchives();
        InventoryQueryEntity inventoryQueryEntity = new InventoryQueryEntity();
        if (CollectionUtils.isEmpty(archives)) {
            throw new BusinessException(ModuleCode.ORDR, "buyerBatchOrderDetailList 不能为空");
        }
        List<InventoryQueryEntity.InventoryQuery> inventoryQueryList = new ArrayList<>();
        for (BuyerBatchOrderDetail batchOrderDetail : archives) {
            InventoryQueryEntity.InventoryQuery inventoryQuery = (InventoryQueryEntity.InventoryQuery) ExternalCallUtil
                    .setEntityParam(InventoryQueryEntity.InventoryQuery.class, 0);
            inventoryQuery.setAvailableQty(new BigDecimal(1000000000));
            inventoryQuery.setPartId(batchOrderDetail.getEntity().getGoodsId().toString());
            inventoryQueryList.add(inventoryQuery);
        }
        inventoryQueryEntity.setInventoryQueryList(inventoryQueryList);
        return inventoryQueryEntity;
    }

    /**
     * 库存查询 卖家
     *
     * @param buyerForcastDeliverDetailList
     * @return
     */
    public InventoryQueryEntity queryInventoryByBuyerOrderDetailList(
            BuyerForcastDeliverDetailList buyerForcastDeliverDetailList, boolean isPlatForm) {
        List<BuyerForcastDeliverDetail> archives = buyerForcastDeliverDetailList.getArchives();
        InventoryQueryEntity inventoryQueryEntity = new InventoryQueryEntity();
        if (CollectionUtils.isEmpty(archives)) {
            throw new BusinessException(ModuleCode.ORDR, "buyerForcastDeliverDetailList 不能为空");
        }
        List<InventoryQueryEntity.InventoryQuery> inventoryQueryList = new ArrayList<>();
        for (BuyerForcastDeliverDetail buyerForcastDeliverDetail : archives) {
            InventoryQueryEntity.InventoryQuery inventoryQuery = (InventoryQueryEntity.InventoryQuery) ExternalCallUtil
                    .setEntityParam(InventoryQueryEntity.InventoryQuery.class, 0);
            inventoryQuery.setAvailableQty(new BigDecimal(1000000000));
            inventoryQuery.setPartId(buyerForcastDeliverDetail.getEntity().getGoodsId().toString());
            inventoryQueryList.add(inventoryQuery);
        }
        inventoryQueryEntity.setInventoryQueryList(inventoryQueryList);
        return inventoryQueryEntity;
    }

    /**
     * 库存查询 平台 或是 买手
     *
     * @param bsOrderDetailList
     * @return
     */
    public InventoryQueryEntity queryInventoryByBsOrderDetailList(BsOrderDetailList bsOrderDetailList,
            boolean isPlatForm) {
        List<BsOrderDetail> archives = bsOrderDetailList.getArchives();
        InventoryQueryEntity inventoryQueryEntity = new InventoryQueryEntity();
        if (CollectionUtils.isEmpty(archives)) {
            throw new BusinessException(ModuleCode.ORDR, "buyerBatchOrderDetailList 不能为空");
        }
        List<InventoryQueryEntity.InventoryQuery> inventoryQueryList = new ArrayList<>();
        for (BsOrderDetail bsOrderDetail : archives) {
            InventoryQueryEntity.InventoryQuery inventoryQuery = (InventoryQueryEntity.InventoryQuery) ExternalCallUtil
                    .setEntityParam(InventoryQueryEntity.InventoryQuery.class, 0);
            inventoryQuery.setAvailableQty(new BigDecimal(1000000000));
            inventoryQuery.setPartId(bsOrderDetail.getEntity().getGoodsId().toString());
            inventoryQueryList.add(inventoryQuery);
        }
        inventoryQueryEntity.setInventoryQueryList(inventoryQueryList);
        return inventoryQueryEntity;
    }

    /**
     * 买手囤实物 货权
     *
     * @param bsStockpileSplitDetailList
     * @return
     */
    public Boolean addInventory(BsStockpileSplitDetailList bsStockpileSplitDetailList) {
        return true;
    }

    /**
     * 买家订单 平台，卖家 库存占用
     *
     * @param buyerBatchOrderDetailList
     * @return
     */
    public InventoryAllocationEntity allocationByBatchDetailList(BuyerBatchOrderDetailList buyerBatchOrderDetailList,
            Boolean isPlatform) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买家订单 平台，卖家 库存占用取消
     *
     * @param buyerBatchOrderDetailList
     * @return
     */
    public InventoryAllocationEntity allocationCancelByBatchDetailList(
            BuyerBatchOrderDetailList buyerBatchOrderDetailList, Boolean isPlatform) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买家订单 卖家 库存占用 拆分明细用
     *
     * @param buyerForcastDeliverDetailList
     * @return
     */
    public InventoryAllocationEntity allocationByBuyerForcastDeliverDetailList(
            BuyerForcastDeliverDetailList buyerForcastDeliverDetailList) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买家订单 卖家 库存占用取消
     *
     * @param buyerForcastDeliverDetailList
     * @return
     */
    public InventoryAllocationEntity allocationCancelByBuyerForcastDeliverDetailList(
            BuyerForcastDeliverDetailList buyerForcastDeliverDetailList) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买手订单 平台库 卖家 存占用
     *
     * @param bsOrderDetailList
     * @return
     */
    public InventoryAllocationEntity allocationByBsOrderDetailList(BsOrderDetailList bsOrderDetailList) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买手订单 平台库存 卖家 占用取消
     *
     * @param bsOrderDetailList
     * @return
     */
    public InventoryAllocationEntity allocationCancelByBsOrderDetailList(BsOrderDetailList bsOrderDetailList) {
        return new InventoryAllocationEntity();
    }

    // 、BsStockpileSplitDetail

    /**
     * 买手订单 卖家 存占用
     *
     * @param bsStockpileSplitDetailList
     * @return
     */
    public InventoryAllocationEntity allocationByBsStockpileSplitDetailList(
            BsStockpileSplitDetailList bsStockpileSplitDetailList) {
        return new InventoryAllocationEntity();
    }

    /**
     * 买手订单 卖家 占用取消
     *
     * @param bsStockpileSplitDetailList
     * @return
     */
    public InventoryAllocationEntity allocationCancelByBsStockpileSplitDetailList(
            BsStockpileSplitDetailList bsStockpileSplitDetailList) {
        return new InventoryAllocationEntity();
    }

    /**
     * 供应商库存占用接口
     *
     * @param param
     * @return
     */

    public AllocationSupplierInventoryRestResult allocationSupplierInventory(
            AllocationSupplierInventoryRestParam param) {
        return new AllocationSupplierInventoryRestResult();
    }

    /**
     * 刘涛用 库存查询接口
     *
     * @param param
     * @return
     */
    public QuerySupplierInvRestResult querySupplierInv(QuerySupplierInvRestParam param) {
        QuerySupplierInvRestResult restResult = new QuerySupplierInvRestResult();
        List<QuerySupplierInvRestResult.Inventory> inventoryList = new ArrayList<>();
        String[] commodityId = param.getCommodityId();
        if (commodityId != null) {
            for (String goodsId : commodityId) {
                if ("1111001".equals(goodsId)) {
                    QuerySupplierInvRestResult.Inventory inventoryResult1 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult1.setCommodityId(goodsId);
                    String s = UUID.randomUUID().toString();
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult1.setSupplierId("1100011");
                    inventoryResult1.setProducerId("110001");
                    inventoryResult1.setAvailableQty(new BigDecimal(1000));
                    inventoryResult1.setOwnerId("0000000");
                    inventoryResult1.setOwnerType("H01");
                    inventoryResult1.setIvType("I01");
                    inventoryList.add(inventoryResult1);

                    QuerySupplierInvRestResult.Inventory inventoryResult2 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult2.setCommodityId(goodsId);
                    inventoryResult2.setSupplierId("1100021");
                    inventoryResult2.setProducerId("110002");
                    inventoryResult2.setAvailableQty(new BigDecimal(5000));
                    inventoryResult2.setOwnerId("0000000");
                    inventoryResult2.setOwnerType("H01");
                    inventoryResult2.setIvType("I01");
                    inventoryList.add(inventoryResult2);

                    QuerySupplierInvRestResult.Inventory inventoryResult3 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult3.setCommodityId(goodsId);
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult3.setSupplierId("1100061");
                    inventoryResult3.setProducerId("110006");
                    inventoryResult3.setAvailableQty(new BigDecimal(1000));
                    inventoryResult3.setOwnerId("880122");
                    inventoryResult3.setOwnerType("H02");
                    inventoryResult3.setIvType("I01");
                    inventoryList.add(inventoryResult3);
                } else if ("1111002".equals(goodsId)) {
                    QuerySupplierInvRestResult.Inventory inventoryResult = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult.setCommodityId(goodsId);
                    String s = UUID.randomUUID().toString();
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult.setSupplierId("1100011");
                    inventoryResult.setProducerId("110001");
                    inventoryResult.setAvailableQty(new BigDecimal(200));
                    inventoryResult.setOwnerId("0000000");
                    inventoryResult.setOwnerType("H01");
                    inventoryResult.setIvType("I01");
                    inventoryList.add(inventoryResult);

                    QuerySupplierInvRestResult.Inventory inventoryResult2 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult2.setCommodityId(goodsId);
                    inventoryResult2.setSupplierId("1100021");
                    inventoryResult2.setProducerId("110002");
                    inventoryResult2.setAvailableQty(new BigDecimal(500));
                    inventoryResult2.setOwnerId("0000000");
                    inventoryResult2.setOwnerType("H01");
                    inventoryResult2.setIvType("I01");
                    inventoryList.add(inventoryResult2);

                    QuerySupplierInvRestResult.Inventory inventoryResult3 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult3.setCommodityId(goodsId);
                    inventoryResult3.setSupplierId("1100031");
                    inventoryResult3.setProducerId("110003");
                    inventoryResult3.setAvailableQty(new BigDecimal(3000));
                    inventoryResult3.setOwnerId("0000000");
                    inventoryResult3.setOwnerType("H01");
                    inventoryResult3.setIvType("I01");
                    inventoryList.add(inventoryResult3);

                    QuerySupplierInvRestResult.Inventory inventoryResult4 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult4.setCommodityId(goodsId);
                    inventoryResult4.setSupplierId("1100041");
                    inventoryResult4.setProducerId("110004");
                    inventoryResult4.setAvailableQty(new BigDecimal(3000));
                    inventoryResult4.setOwnerId("880122");
                    inventoryResult4.setOwnerType("H02");
                    inventoryResult4.setIvType("I01");
                    inventoryList.add(inventoryResult4);

                    QuerySupplierInvRestResult.Inventory inventoryResult5 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult5.setCommodityId(goodsId);
                    inventoryResult5.setSupplierId("1100061");
                    inventoryResult5.setProducerId("110006");
                    inventoryResult5.setAvailableQty(new BigDecimal(900));
                    inventoryResult5.setOwnerId("880122");
                    inventoryResult5.setOwnerType("H02");
                    inventoryResult5.setIvType("I01");
                    inventoryList.add(inventoryResult5);
                } else if ("1111003".equals(goodsId)) {
                    QuerySupplierInvRestResult.Inventory inventoryResult1 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult1.setCommodityId(goodsId);
                    String s = UUID.randomUUID().toString();
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult1.setSupplierId("1100021");
                    inventoryResult1.setProducerId("110002");
                    inventoryResult1.setAvailableQty(new BigDecimal(800));
                    inventoryResult1.setOwnerId("0000000");
                    inventoryResult1.setOwnerType("H01");
                    inventoryResult1.setIvType("I01");
                    inventoryList.add(inventoryResult1);

                    QuerySupplierInvRestResult.Inventory inventoryResult2 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult2.setCommodityId(goodsId);
                    inventoryResult2.setSupplierId("1100051");
                    inventoryResult2.setProducerId("110005");
                    inventoryResult2.setAvailableQty(new BigDecimal(200));
                    inventoryResult2.setOwnerId("880122");
                    inventoryResult2.setOwnerType("H02");
                    inventoryResult2.setIvType("I01");
                    inventoryList.add(inventoryResult2);

                    QuerySupplierInvRestResult.Inventory inventoryResult3 = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult3.setCommodityId(goodsId);
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult3.setSupplierId("1100061");
                    inventoryResult3.setProducerId("110006");
                    inventoryResult3.setAvailableQty(new BigDecimal(2000));
                    inventoryResult3.setOwnerId("880122");
                    inventoryResult3.setOwnerType("H02");
                    inventoryResult3.setIvType("I01");
                    inventoryList.add(inventoryResult3);
                } else if ("1111004".equals(goodsId)) {
                    QuerySupplierInvRestResult.Inventory inventoryResult = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult.setCommodityId(goodsId);
                    String s = UUID.randomUUID().toString();
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult.setSupplierId("1100071");
                    inventoryResult.setProducerId("110007");
                    inventoryResult.setAvailableQty(new BigDecimal(4000));
                    inventoryResult.setOwnerId("88012");
                    inventoryResult.setOwnerType("H02");
                    inventoryResult.setIvType("I01");
                    inventoryList.add(inventoryResult);
                } else {
                    QuerySupplierInvRestResult.Inventory inventoryResult = (QuerySupplierInvRestResult.Inventory) ExternalCallUtil
                            .setEntityParam(QuerySupplierInvRestResult.Inventory.class, 0);
                    inventoryResult.setCommodityId(goodsId);
                    String s = UUID.randomUUID().toString();
                    s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23)
                            + s.substring(24);
                    inventoryResult.setSupplierId(s);
                    inventoryList.add(inventoryResult);
                }

            }

        }

        restResult.setInvList(inventoryList);
        return restResult;
    }

    @Test
    public void test() {
        InventoryQueryEntity.InventoryQuery inventoryQuery = (InventoryQueryEntity.InventoryQuery) ExternalCallUtil
                .setEntityParam(InventoryQueryEntity.InventoryQuery.class, 0);
        System.out.println(inventoryQuery);
    }
}

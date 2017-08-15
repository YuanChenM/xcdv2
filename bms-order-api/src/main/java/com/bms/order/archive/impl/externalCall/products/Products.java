package com.bms.order.archive.impl.externalCall.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.bms.order.bean.externalCall.products.entity.ProductListEntity;
import com.bms.order.bean.externalCall.products.entity.SingleManufacturerEntity;
import com.bms.order.bean.externalCall.products.entity.SingleProductEntity;
import com.bms.order.bean.externalCall.products.entity.SingleSellerEntity;
import com.bms.order.bean.externalCall.products.param.ManufacturerRestParam;
import com.bms.order.bean.externalCall.products.param.ProductsRestParam;
import com.bms.order.bean.externalCall.products.param.SellerRestParam;
import com.bms.order.bean.externalCall.products.result.ManufacturerRestResult;
import com.bms.order.bean.externalCall.products.result.ProductsRestResult;
import com.bms.order.bean.externalCall.products.result.SellerRestResult;
import com.bms.order.util.ExternalCallUtil;
import com.framework.exception.BusinessException;

/**
 * Created by zhang_qiang1 on 2017/1/6.
 */
public class Products {


/*    *//**
     * 买手创建订单时  获取商品信息
     *
     * @param bsOrder
     * @return
     *//*
    public Map<String, ProductEntity> getProductsByBsOrder(BsOrder bsOrder) {
        Map<String, ProductEntity> map = new HashMap<>();
        List<BsOrderDetail> bsOrderDetails = bsOrder.getBsOrderDetails();
        for (BsOrderDetail bsOrderDetail : bsOrderDetails) {
            String goodsId = bsOrderDetail.getEntity().getGoodsId().toString();
            ProductEntity productEntity = (ProductEntity) ExternalCallUtil.setEntityParam(ProductEntity.class, 0);
            productEntity.setGoodsId(bsOrderDetail.getEntity().getGoodsId());
            map.put(goodsId, productEntity);
        }
        return map;
    }*/


   /* *//**
     *  根据 买手订单明细 查询
     * @param bsOrderDetail
     * @return
     *//*
    public  ProductEntity getProductsByBsOrderDetail(BsOrderDetail bsOrderDetail) {
        ProductEntity productEntity = (ProductEntity) ExternalCallUtil.setEntityParam(ProductEntity.class, 0);
        productEntity.setGoodsId(bsOrderDetail.getEntity().getGoodsId());

        return productEntity;
    }*/


/*
    *//**
     * 买家创建订单时  获取商品信息
     *
     * @param buyerOrder
     * @return
     *//*
    public Map<String, ProductEntity> getProductsByBuyerOrder(BuyerOrder buyerOrder) {
        Map<String, ProductEntity> map = new HashMap<>();
        List<BuyerBatchOrderDetail> buyerBatchOrderDetails = buyerOrder.getBuyerBatchOrderDetails();
        for (BuyerBatchOrderDetail batchOrderDetail : buyerBatchOrderDetails) {
            String goodsId = batchOrderDetail.getEntity().getGoodsId().toString();
            ProductEntity productEntity = (ProductEntity) ExternalCallUtil.setEntityParam(ProductEntity.class, 0);
            productEntity.setGoodsId(batchOrderDetail.getEntity().getGoodsId());
            map.put(goodsId, productEntity);
        }
        return map;
    }*/


    /**
     * 页面查询使用
     *
     * @return
     */
    public ProductListEntity getAllProductEntityList() {
        return (ProductListEntity) ExternalCallUtil.setEntityParam(ProductListEntity.class, 100);
    }


  /*  *//**
     * 通过配送明细 中的（生产商，商品id,商品卖家）
     *
     * @param deliverDetail
     * @return
     *//*
    public ProductEntity getProductEntityByBuyerForcastDeliverDetail(BuyerForcastDeliverDetail deliverDetail) {
        ProductEntity productEntity = (ProductEntity) ExternalCallUtil.setEntityParam(ProductEntity.class, 0);
        productEntity.setGoodsId(deliverDetail.getEntity().getGoodsId());
        productEntity.setManufacturerId(deliverDetail.getEntity().getManufacturerId());
        productEntity.setSellerId(deliverDetail.getEntity().getSellerId());
        return productEntity;
    }*/


    /**
     * @param goodsIds
     * @return
     */
    public List<SingleProductEntity> getProductListAndSellersAndManufacturers(List<String> goodsIds) {
        List<SingleProductEntity> singleProductEntityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodsIds)) {
            for (String goodsId : goodsIds) {
                SingleProductEntity entity = this.getProductAndSellersAndManufacturers(goodsId);
                singleProductEntityList.add(entity);
            }
        }
        return singleProductEntityList;
    }


    /**
     * @param goodsId
     * @return
     */
    public SingleProductEntity getProductAndSellersAndManufacturers(String goodsId) {
        SingleProductEntity entity = (SingleProductEntity) ExternalCallUtil.setEntityParam(SingleProductEntity.class, 10);
        entity.setGoodsId(goodsId);
        return entity;
    }


    /**
     * 根据卖家id 获取卖家信息
     *
     * @param sellersId
     * @return
     */
    public SingleSellerEntity getSellerBySellId(Long sellersId) {
        SingleSellerEntity entity = (SingleSellerEntity) ExternalCallUtil.setEntityParam(SingleSellerEntity.class, 10);
        entity.setSellerId(sellersId);
        return entity;
    }


    /**
     * 根据生成商id 获取 生产商信息
     *
     * @param manufacturerId
     * @return
     */
    public SingleManufacturerEntity getManufacturerByManufacturerId  (Long manufacturerId) {
        SingleManufacturerEntity entity = (SingleManufacturerEntity) ExternalCallUtil.setEntityParam(SingleManufacturerEntity.class, 10);
        entity.setManufacturerId(manufacturerId);
        return entity;
    }


    //=====================================================================================================================


    /**
     * 刘涛用
     * 查询 商品信息
     *
     * @param param
     * @return
     */
    public ProductsRestResult getFindProductsByGoodsIds(ProductsRestParam param) {
        ProductsRestResult restResult = new ProductsRestResult();
        List<String> goodsIds = param.getGoodsIds();
        if (param == null || CollectionUtils.isEmpty(goodsIds)) {
            throw new BusinessException("", "");
        }
        List<ProductsRestResult.Product> productList = new ArrayList<>();
        for (String goodsId : goodsIds) {
            ProductsRestResult.Product product = (ProductsRestResult.Product) ExternalCallUtil.setEntityParam(ProductsRestResult.Product.class, 0);
            product.setGoodsId(goodsId);
            productList.add(product);
        }
        restResult.setProductList(productList);
        return restResult;
    }


    /**
     * 刘涛用
     * 查询 卖家
     *
     * @param param
     * @return
     */
    public SellerRestResult getFindSellers(SellerRestParam param) {
        SellerRestResult restResult = new SellerRestResult();
        List<Long> sellerIds = param.getSellerIds();
        if (param == null || CollectionUtils.isEmpty(sellerIds)) {
            throw new BusinessException("", "");
        }
        List<SellerRestResult.Seller> sellerList = new ArrayList<>();
        for (Long sellerId : sellerIds) {
            SellerRestResult.Seller seller = (SellerRestResult.Seller) ExternalCallUtil.setEntityParam(SellerRestResult.Seller.class, 0);
            seller.setSellerId(sellerId);
            sellerList.add(seller);
        }
        restResult.setSellers(sellerList);
        return restResult;
    }

    /**
     * 刘涛用
     * 获取生产商
     *
     * @param param
     * @return
     */

    public ManufacturerRestResult getFindManufactures(ManufacturerRestParam param) {
        ManufacturerRestResult restResult = new ManufacturerRestResult();
        List<Long> manufacturerIds = param.getManufacturerIds();
        if (param == null || CollectionUtils.isEmpty(manufacturerIds)) {
            throw new BusinessException("", "");
        }
        List<ManufacturerRestResult.Manufacturer> manufacturerList = new ArrayList<>();
        for (Long manufacturerId : manufacturerIds) {
            ManufacturerRestResult.Manufacturer manufacturer = (ManufacturerRestResult.Manufacturer) ExternalCallUtil.setEntityParam(ManufacturerRestResult.Manufacturer.class, 0);
            manufacturer.setManufacturerId(manufacturerId);
            manufacturerList.add(manufacturer);
        }
        restResult.setManufacturerList(manufacturerList);
        return restResult;
    }


    //  @Test
    public void test() {
        System.out.println(this.getManufacturerByManufacturerId(1L));
       /* List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);

        SellerRestParam sellerRestParam = new SellerRestParam();
        sellerRestParam.setSellerIds(list);
        System.out.println(this.getFindSellers(sellerRestParam));*/

     /*   ManufacturerRestParam manufacturerRestParam=new ManufacturerRestParam();
        manufacturerRestParam.setManufacturerIds(list);
        System.out.println(this.getFindManufactures(manufacturerRestParam));*/
       /* ProductsRestParam param=new ProductsRestParam();
        param.setGoodsIds(goodsIds);
        this.getFindProductsByGoodsIds(param);
        System.out.println( this.getFindProductsByGoodsIds(param));*/



        /*SingleProductEntity singleProductEntity = new Products().getProductAndSellersAndManufacturers("5");
        System.out.println(singleProductEntity.getSingleManufacturerEntityList());
        System.out.println(singleProductEntity.getSingleSellerEntityList());
        System.out.println(singleProductEntity.getSingleSellerEntityList().size());*/
    }


}

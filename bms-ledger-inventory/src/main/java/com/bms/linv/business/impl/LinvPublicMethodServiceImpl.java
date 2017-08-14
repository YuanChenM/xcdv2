package com.bms.linv.business.impl;

import com.alibaba.fastjson.TypeReference;
import com.bms.common.rest.apiclient.RestApiClient;
import com.bms.common.rest.apiclient.RestApiClientFactory;
import com.bms.linv.bean.entity.*;
import com.bms.linv.business.LinvPublicMethodService;
import com.bms.linv.common.NumberGenerator;
import com.bms.linv.common.ResponseDataReader;
import com.bms.linv.constant.LinvApiUrlConstant;
import com.bms.linv.dao.*;
import com.framework.base.web.result.BaseWebPaginationResult;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.boot.plugin.configserver.properties.ConfigServerUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zheng_xu on 2017/4/18.
 */
@Service
public class LinvPublicMethodServiceImpl extends BaseServiceImpl implements LinvPublicMethodService {
    @Autowired
    private BaseRedisDao baseRedisDao;
    @Autowired
    private InvmLoadDao invmLoadDao;
    @Autowired
    private InvmComoInventoryDao invmComoInventoryDao;
    @Autowired
    private InvmLoadDealDetailDao invmLoadDealDetailDao;
    @Autowired
    private InvmComoDealDetailDao invmComoDealDetailDao;
    @Autowired
    private InvmComoBalanceInventoryDao invmComoBalanceInventoryDao;
    @Autowired
    private InvmComoBalanceDealDetailDao invmComoBalanceDealDetailDao;
    @Autowired
    private InvmLoadAlocInventoryDao invmLoadAlocInventoryDao;
    @Autowired
    private InvmLoadAlocDealDetailDao invmLoadAlocDealDetailDao;
    @Autowired
    private InvmComoAlocInventoryDao invmComoAlocInventoryDao;
    @Autowired
    private InvmComoAlocDealDetailDao invmComoAlocDealDetailDao;
    @Autowired
    private InvmCommInfoDao invmCommInfoDao;
    @Autowired
    private RestApiClientFactory restApiClientFactory;

    /**
     * 产品库存增加
     * 
     * @param invmLoad
     * @param loadDealDetail
     */
    public void addProductInv(InvmLoad invmLoad, InvmLoadDealDetail loadDealDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、增加产品库存记录，若存在则修改数量，不存在则新增记录
        // 查询产品库存
        InvmLoad loadResult = invmLoadDao.findOne(invmLoad);
        String loadNo = "";// 库存身份
        if (null == loadResult) {
            // 新增
            loadNo = NumberGenerator.getNewLoadNumber();
            invmLoad.setLoadNo(loadNo);
            invmLoad.setCrtId(sign);
            invmLoad.setCrtTime(time);
            invmLoadDao.save(invmLoad);
        } else {
            loadNo = loadResult.getLoadNo();
            // 修改
            loadResult.setIvQty(invmLoad.getIvQty());
            loadResult.setUpdId(sign);
            loadResult.setUpdTime(time);
            invmLoadDao.modify(loadResult);
        }
        // 2、增加产品库存交易明细记录
        loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
        loadDealDetail.setLoadNo(loadNo);
        loadDealDetail.setCrtId(sign);
        loadDealDetail.setCrtTime(time);
        invmLoadDealDetailDao.save(loadDealDetail);
    }

    /**
     * 产品库存减少
     * 
     * @param invmLoad
     * @param loadDealDetail
     */
    @Override
    public void reduceProductInv(InvmLoad invmLoad, InvmLoadDealDetail loadDealDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、根据参数查询产品库存，无则报错
        List<InvmLoad> invmLoadResult = invmLoadDao.findAll(invmLoad);
        if (invmLoadResult.size() > 0) {

            BigDecimal reduceQty = BigDecimal.valueOf(0).subtract(invmLoad.getIvQty());// 减少数量
            for (InvmLoad load : invmLoadResult) {
                BigDecimal loadQty = load.getIvQty();
                if (reduceQty.compareTo(loadQty) > 0) {
                    String loadNo = load.getLoadNo();
            // 2、根据alocNo，修改占用库存数量
                    load.setIvQty(BigDecimal.valueOf(0).subtract(loadQty));
                    load.setUpdId(sign);
                    load.setUpdTime(time);
                    invmLoadDao.modify(load);
                    reduceQty = reduceQty.subtract(loadQty);

                    // 3、新增产品库存交易明细
                    loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
                    loadDealDetail.setLoadNo(loadNo);
                    loadDealDetail.setCrtId(sign);
                    loadDealDetail.setCrtTime(time);
                    loadDealDetail.setSaleStatusId(load.getSaleStatusId());
                    invmLoadDealDetailDao.save(loadDealDetail);
                }else{
                    String loadNo = load.getLoadNo();
                    // 2、根据alocNo，修改占用库存数量
                    load.setIvQty(BigDecimal.valueOf(0).subtract(reduceQty));
                    load.setUpdId(sign);
                    load.setUpdTime(time);
                    invmLoadDao.modify(load);

            // 3、新增产品库存交易明细
            loadDealDetail.setLoadDealId(baseRedisDao.getTablePrimaryKey("invm_load_deal_detail", 1));// 自增ID
            loadDealDetail.setLoadNo(loadNo);
            loadDealDetail.setCrtId(sign);
            loadDealDetail.setCrtTime(time);
            loadDealDetail.setSaleStatusId(load.getSaleStatusId());
            invmLoadDealDetailDao.save(loadDealDetail);
                    break;
                }
            }
        } else {
            throw new BusinessException("LINV.REDUCE_P_INV", "未查询到当前产品库存！");
        }
    }

    /**
     * 产品库存占用
     *
     * @param loadAlocInv 产品占用库存对象
     * @param loadAlocDetail 产品占用明细对象
     */
    @Override
    public void alocProduct(InvmLoadAlocInventory loadAlocInv, InvmLoadAlocDealDetail loadAlocDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、查询产品库存，不存在则报错
        InvmLoad invmLoad = new InvmLoad();
        invmLoad.setLaId(loadAlocInv.getLaId());
        invmLoad.setSplatCode(loadAlocInv.getSplatCode());
        invmLoad.setOwnerId(loadAlocInv.getOwnerId());
        invmLoad.setOwnerCode(loadAlocInv.getOwnerCode());
        invmLoad.setOwnerType(loadAlocInv.getOwnerType());
        invmLoad.setSkuCode(loadAlocInv.getSkuCode());
        invmLoad.setIvType(loadAlocInv.getIvType());
        invmLoad.setSaleStatusId(loadAlocInv.getSaleStatusId());
        invmLoad.setUom(loadAlocInv.getUom());
        InvmLoad invmLoadResult = invmLoadDao.querySumQty(invmLoad);
        if (null == invmLoadResult) {
            throw new BusinessException("LINV.P_ALLOCATED", "未查询到当前产品库存！");
        }
        if (loadAlocInv.getAlocQty().compareTo(invmLoadResult.getIvQty()) > 0) {
            throw new BusinessException("LINV.P_ALLOCATED", "产品占用数量大于当前产品库存数量！");
        }
        // 2、增加SKU占用记录，存在则修改数量，不存在则新增一条
        InvmLoadAlocInventory loadAloc = invmLoadAlocInventoryDao.findOne(loadAlocInv);
        String alocNo = "";// 占用身份
        if (null == loadAloc) {
            // 新增
            alocNo = NumberGenerator.getNewProductAllocationNumber();
            loadAlocInv.setAlocNo(alocNo);
            loadAlocInv.setCrtId(sign);
            loadAlocInv.setCrtTime(time);
            invmLoadAlocInventoryDao.save(loadAlocInv);
        } else {
            alocNo = loadAloc.getAlocNo();
            // 修改
            loadAloc.setAlocQty(loadAlocInv.getAlocQty());
            loadAloc.setUpdId(sign);
            loadAloc.setUpdTime(time);
            invmLoadAlocInventoryDao.modify(loadAloc);
        }
        // 3、增加SKU占用交易明细记录
        loadAlocDetail.setAlDealId(baseRedisDao.getTablePrimaryKey("invm_load_aloc_deal_detail", 1));// 自增ID
        loadAlocDetail.setAlocNo(alocNo);
        loadAlocDetail.setCrtId(sign);
        loadAlocDetail.setCrtTime(time);
        invmLoadAlocDealDetailDao.save(loadAlocDetail);
    }

    /**
     * 产品库存占用释放
     *
     * @param loadAlocInv
     * @param loadAlocDetail
     */
    @Override
    public void cancelProcductAloc(InvmLoadAlocInventory loadAlocInv, InvmLoadAlocDealDetail loadAlocDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、根据参数查询产品占用表，无则报错
        InvmLoadAlocInventory loadAlocInvResult = invmLoadAlocInventoryDao.findOne(loadAlocInv);
        if (loadAlocInvResult != null) {
            // check数量
            BigDecimal qty = loadAlocInvResult.getAlocQty();
            BigDecimal reduceQty = BigDecimal.valueOf(0).subtract(loadAlocInv.getAlocQty());
            if (reduceQty.compareTo(qty) > 0) {
                throw new BusinessException("LINV.RELEASE_P_ALOC", "产品占用库存减少数量大于产品占用库存占用数量！");
            }
            String alocNo = loadAlocInvResult.getAlocNo();
            // 2、根据alocNo，修改占用库存数量
            loadAlocInvResult.setAlocQty(loadAlocInv.getAlocQty());
            loadAlocInvResult.setUpdId(sign);
            loadAlocInvResult.setUpdTime(time);
            invmLoadAlocInventoryDao.modify(loadAlocInvResult);
            // 3、增加货权人商品占用明细记录
            loadAlocDetail.setAlDealId(baseRedisDao.getTablePrimaryKey("invm_load_aloc_deal_detail", 1));// 自增ID
            loadAlocDetail.setAlocNo(alocNo);
            loadAlocDetail.setCrtId(sign);
            loadAlocDetail.setCrtTime(time);
            invmLoadAlocDealDetailDao.save(loadAlocDetail);
        } else {
            throw new BusinessException("LINV.RELEASE_P_ALOC", "未查询到当前产品占用库存！");
        }
    }

    /**
     * 插入商品信息表
     *
     * @param tempCom
     */
    private void saveCommInfo(Map tempCom, String sign, Date time) {
        InvmCommInfo tCom = new InvmCommInfo();
        tCom.setInfoId(baseRedisDao.getTablePrimaryKey("invm_comm_info", 1));
        tCom.setCommodityId(String.valueOf(tempCom.get("commodityId")));
        tCom.setCommodityName(String.valueOf(tempCom.get("commodityName")));
        tCom.setPdId(String.valueOf(tempCom.get("productId")));
        tCom.setSaleStatusId(Long.valueOf(String.valueOf(tempCom.get("saleStatusId"))));
        tCom.setSaleStatusCode(String.valueOf(tempCom.get("saleStatusCode")));
        tCom.setSaleStatusName(String.valueOf(tempCom.get("saleStatusName")));
        tCom.setDelFlg(false);
        tCom.setCrtId(sign);
        tCom.setCrtTime(time);
        invmCommInfoDao.save(tCom);
    }

    /**
     * 商品库存增加
     * 
     * @param comoInv
     * @param comoDealDetail
     * @param comoBalanceInv
     */
    public void addComoInv(InvmComoInventory comoInv, InvmComoDealDetail comoDealDetail,
        InvmComoBalanceInventory comoBalanceInv) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、新增商品库存记录，先查询是否存在，存在则更改数量，否则新增
        // 查询商品库存
        InvmComoInventory comoInvResult = invmComoInventoryDao.findOne(comoInv);
        String storeNo = "";// 商品身份
        if (null == comoInvResult) {
            // 判断是否存在como_info基础信息
            InvmCommInfo invmCommParam = new InvmCommInfo();
            invmCommParam.setCommodityId(comoInv.getCommodityId());
            InvmCommInfo invmCommInfo = invmCommInfoDao.findOne(invmCommParam);
            if (invmCommInfo == null) {
                // 通过获取到的产品id拿商品信息（调用商品查询接口）
                String comUrl = ConfigServerUtils.getAPIUrl(LinvApiUrlConstant.COMO.CODE,
                    LinvApiUrlConstant.COMO.URIS.COMM_INFO_SEARCH);
                HashMap requestCom = new HashMap();
                List<Long> arryLsParam = new ArrayList<Long>();
                arryLsParam.add(Long.valueOf(comoInv.getCommodityId()));
                requestCom.put("commodityIds", arryLsParam.toArray(new Long[arryLsParam.size()]));
                RestApiClient restClient = restApiClientFactory.newApiRestClient();
                BaseWebPaginationResult<HashMap> comResult = restClient.post(comUrl, requestCom,
                    new TypeReference<BaseWebPaginationResult<HashMap>>() {});
                if (comResult.getData() != null) {
                    Map tempCom = (HashMap) comResult.getData().get(0);
                    saveCommInfo(tempCom, sign, time);//保存新商品信息
                } else {
                    throw new BusinessException("LINV_COMOIDITY", "commodityId未找到商品信息");
                }
            }

            // 新增
            storeNo = NumberGenerator.getNewCommodityNumber();// 商品身份
            comoInv.setStoreNo(storeNo);
            comoInv.setCrtId(sign);
            comoInv.setCrtTime(time);
            invmComoInventoryDao.save(comoInv);

        } else {
            storeNo = comoInvResult.getStoreNo();
            // 修改
            comoInvResult.setIvQty(comoInv.getIvQty());
            comoInvResult.setUpdId(sign);
            comoInvResult.setUpdTime(time);
            invmComoInventoryDao.modify(comoInvResult);
        }
        // 2、新增商品库存明细记录
        Long storeDealId = baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1);
        comoDealDetail.setStoreDealId(storeDealId);// 自增ID
        comoDealDetail.setStoreNo(storeNo);
        comoDealDetail.setCrtTime(time);
        comoDealDetail.setCrtId(sign);
        invmComoDealDetailDao.save(comoDealDetail);
        // 3、新增商品库存余量记录
        comoBalanceInv.setInvId(baseRedisDao.getTablePrimaryKey("invm_como_balance_inventory", 1));
        comoBalanceInv.setStoreDealId(storeDealId);
        comoBalanceInv.setStoreNo(storeNo);
        comoBalanceInv.setCrtId(sign);
        comoBalanceInv.setCrtTime(time);
        invmComoBalanceInventoryDao.save(comoBalanceInv);
    }

    /**
     * 商品库存减少
     * 
     * @param comoInv
     * @param comoDealDetail
     */
    @Override
    public void reduceComoInv(InvmComoInventory comoInv, InvmComoDealDetail comoDealDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、查询商品库存，无则报错
        InvmComoInventory comoInventory = invmComoInventoryDao.findOne(comoInv);
        if (null != comoInventory) {
            // check数量
            BigDecimal qty = comoInventory.getIvQty();
            BigDecimal reduceQty = BigDecimal.valueOf(0).subtract(comoInv.getIvQty());
            if (reduceQty.compareTo(qty) > 0) {
                throw new BusinessException("LINV.REDUCE_C_INV", "商品库存减少数量大于商品库存数量！");
            }
            // 2、根据alocNo，修改占用库存数量
            String storeNo = comoInventory.getStoreNo();
            comoInventory.setIvQty(comoInv.getIvQty());
            comoInventory.setUpdId(sign);
            comoInventory.setUpdTime(time);
            invmComoInventoryDao.modify(comoInventory);
            // 3、新增商品库存交易明细
            Long storeDealId = baseRedisDao.getTablePrimaryKey("invm_como_deal_detail", 1);
            comoDealDetail.setStoreDealId(storeDealId);
            comoDealDetail.setStoreNo(storeNo);
            comoDealDetail.setCrtId(sign);
            comoDealDetail.setCrtTime(time);
            invmComoDealDetailDao.save(comoDealDetail);
            // 4、修改商品库存余量记录
            // 通过StoreNo查询多条余量明细单 按照时间排序
            InvmComoBalanceInventory invmComoBalanceInventory = new InvmComoBalanceInventory();
            invmComoBalanceInventory.setStoreNo(storeNo);
            List<InvmComoBalanceInventory> comBalanList = invmComoBalanceInventoryDao.findAll(invmComoBalanceInventory);
            BigDecimal dealQty = BigDecimal.valueOf(0).subtract(comoInv.getIvQty());// 对传过来的负参数转变为正数
            // 先进先出的规则进行余量的扣减
            for (int i = 0; i < comBalanList.size(); i++) {
                invmComoBalanceInventory.setInvId(comBalanList.get(i).getInvId());
                invmComoBalanceInventory.setUpdId(sign);
                invmComoBalanceInventory.setUpdTime(time);
                BigDecimal availableQty = (comBalanList.get(i).getInboundQty())
                    .subtract(comBalanList.get(i).getOutboundQty());
                if (dealQty.compareTo(availableQty) > 0) {
                    invmComoBalanceInventory.setOutboundQty(availableQty);
                    invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                    // 插入余量变动记录表
                    InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                    invmComoBalanceDealDetail
                        .setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                    invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                    invmComoBalanceDealDetail.setOwnerId(comoInv.getOwnerId());
                    invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                    invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                    invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                    invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                    invmComoBalanceDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(availableQty));
                    invmComoBalanceDealDetail.setCrtId(sign);
                    invmComoBalanceDealDetail.setCrtTime(time);
                    invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);

                    dealQty = dealQty.subtract(availableQty);
                } else {
                    invmComoBalanceInventory.setOutboundQty(dealQty);
                    invmComoBalanceInventoryDao.modify(invmComoBalanceInventory);

                    // 插入余量变动记录表
                    InvmComoBalanceDealDetail invmComoBalanceDealDetail = new InvmComoBalanceDealDetail();
                    invmComoBalanceDealDetail
                        .setDetailId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));
                    invmComoBalanceDealDetail.setStoreDealId(storeDealId);
                    invmComoBalanceDealDetail.setOwnerId(comoInv.getOwnerId());
                    invmComoBalanceDealDetail.setBalanceInvId(comBalanList.get(i).getInvId());
                    invmComoBalanceDealDetail.setSrcTransactionId(comBalanList.get(i).getTransactionId());
                    invmComoBalanceDealDetail.setSrcTransactionNo(comBalanList.get(i).getTransactionNo());
                    invmComoBalanceDealDetail.setSrcTransactionDetailId(comBalanList.get(i).getTransactionDetailId());
                    invmComoBalanceDealDetail.setDealQty(BigDecimal.valueOf(0).subtract(dealQty));
                    invmComoBalanceDealDetail.setCrtId(sign);
                    invmComoBalanceDealDetail.setCrtTime(time);
                    invmComoBalanceDealDetailDao.save(invmComoBalanceDealDetail);
                    break;
                }
            }
        } else {
            throw new BusinessException("LINV.REDUCE_C_INV", "未查询到当前货权人商品库存！");
        }
    }

    /**
     * 商品库存占用
     * 
     * @param comoAlocInv 商品占用对象
     * @param comoAlocDetail 商品占用明细对象
     */
    @Override
    public void alocOwComm(InvmComoAlocInventory comoAlocInv, InvmComoAlocDealDetail comoAlocDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、查询商品库存，不存在则报错
        InvmComoInventory comoInv = new InvmComoInventory();
        comoInv.setLaId(comoAlocInv.getLaId());
        comoInv.setSplatCode(comoAlocInv.getSplatCode());
        comoInv.setOwnerId(comoAlocInv.getOwnerId());
        comoInv.setOwnerCode(comoAlocInv.getOwnerCode());
        comoInv.setOwnerType(comoAlocInv.getOwnerType());
        comoInv.setCommodityId(comoAlocInv.getCommodityId());
        comoInv.setComoIvType(comoAlocInv.getComoIvType());
        comoInv.setIvType(comoAlocInv.getIvType());
        InvmComoInventory comoInvResult = invmComoInventoryDao.findOne(comoInv);
        if (null == comoInvResult) {
            throw new BusinessException("LINV.C_ALLOCATED", "未查询到当前货权人商品库存！");
        }
        if (comoAlocInv.getAlocQty().compareTo(comoInvResult.getIvQty()) > 0) {
            throw new BusinessException("LINV.C_ALLOCATED", "商品占用数量大于当前商品库存数量！");
        }
        // 2、增加货权人商品占用记录，存在则更改数量，不存在则新增
        // 查询货权人商品占用库存
        InvmComoAlocInventory comoAlocResult = invmComoAlocInventoryDao.findOne(comoAlocInv);
        String alocNo = "";// 占用身份
        if (null == comoAlocResult) {
            // 新增
            alocNo = NumberGenerator.getNewCommAllocationNumber();
            comoAlocInv.setAlocNo(alocNo);
            comoAlocInv.setCrtId(sign);
            comoAlocInv.setCrtTime(time);
            invmComoAlocInventoryDao.save(comoAlocInv);
        } else {
            alocNo = comoAlocResult.getAlocNo();
            // 修改
            comoAlocResult.setAlocQty(comoAlocInv.getAlocQty());
            comoAlocResult.setUpdId(sign);
            comoAlocResult.setUpdTime(time);
            invmComoAlocInventoryDao.modify(comoAlocResult);
        }
        // 3、增加货权人商品占用明细记录
        comoAlocDetail.setAlDealId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));// 自增ID
        comoAlocDetail.setAlocNo(alocNo);
        comoAlocDetail.setCrtId(sign);
        comoAlocDetail.setCrtTime(time);
        invmComoAlocDealDetailDao.save(comoAlocDetail);
    }

    /**
     * 商品库存占用释放
     * 
     * @param comoAlocDetail
     */
    @Override
    public void cancelOwComAloc(InvmComoAlocInventory comoAlocInv, InvmComoAlocDealDetail comoAlocDetail) {
        Date time = DateUtils.getCurrent();
        String sign = "WMS";
        // 1、根据参数查询商品占用表，无则报错
        InvmComoAlocInventory comoAlocInventory = invmComoAlocInventoryDao.findOne(comoAlocInv);
        if (comoAlocInventory != null) {
            // check 数量
            BigDecimal alocQty = comoAlocInventory.getAlocQty();
            BigDecimal releaseQty = BigDecimal.valueOf(0).subtract(comoAlocInv.getAlocQty());
            if (releaseQty.compareTo(alocQty) > 0) {
                throw new BusinessException("LINV.RELEASE_C_ALOC", "商品占用库存释放数量大于商品占用库存占用数量！");
            }

            String alocNo = comoAlocInventory.getAlocNo();
            // 2、根据alocNo，修改占用库存数量
            comoAlocInventory.setAlocQty(comoAlocInv.getAlocQty());
            comoAlocInventory.setUpdId(sign);
            comoAlocInventory.setUpdTime(time);
            invmComoAlocInventoryDao.modify(comoAlocInventory);
            // 3、增加货权人商品占用明细记录
            comoAlocDetail.setAlDealId(baseRedisDao.getTablePrimaryKey("invm_como_aloc_deal_detail", 1));// 自增ID
            comoAlocDetail.setAlocNo(alocNo);
            comoAlocDetail.setCrtId(sign);
            comoAlocDetail.setCrtTime(time);
            invmComoAlocDealDetailDao.save(comoAlocDetail);
        } else {
            throw new BusinessException("LINV.RELEASE_C_ALOC", "未查询到当前货权人商品占用库存！");
        }
    }

    @Override
    public BaseDao getBaseDao() {
        return null;
    }
}

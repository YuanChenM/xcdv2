package com.bms.slpd.services.impl;

import com.bms.slpd.bean.entity.SlpdBreed;
import com.bms.slpd.bean.entity.SlpdItem;
import com.bms.slpd.bean.param.wrapper.SLPD0302IItemParam;
import com.bms.slpd.bean.result.SLPD0302IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.constant.TableConstant;
import com.bms.slpd.dao.SLPD0302IDao;
import com.bms.slpd.services.CodeGenerateService;
import com.bms.slpd.services.SLPD0302IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.CollectionUtils;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD0302IServiceImpl extends BaseServiceImpl implements SLPD0302IService {

    @Autowired
    private SLPD0302IDao slpd0302IDao;
    @Autowired
    private CodeGenerateService codeGenerateService;

    @Override
    public BaseDao getBaseDao() {
        return slpd0302IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0302IResult saveItems(List<SLPD0302IItemParam> insertList) {
        Date crtTime = DateUtils.getCurrent();
        List<SlpdItem> itemList = new ArrayList<>();
        List<Long> itemIds = new ArrayList<>();
        SlpdItem item = null;

        //获取breedSku
        Map<Long, String> breedSkuMap = getBreedSku(insertList);

        //新增排他
        List<SlpdItem> slpdItemList = slpd0302IDao.findItemName(insertList);
        StringBuilder featureNameStr = new StringBuilder();
        if (CollectionUtils.isNotEmpty(slpdItemList)) {
            for (SlpdItem slpdFeature : slpdItemList) {
                //featureNameStr.append(slpdFeature.getBreedId() + "~").append(slpdFeature.getItemName()).append(",");
                featureNameStr.append(slpdFeature.getItemName()).append(",");
            }
        }
        if (!ObjectUtils.isEmpty(featureNameStr)) {
            SLPD0302IResult result = new SLPD0302IResult();
            /*String[] message = new String[]{MessageConstant.FAILURE, "单品breedId~itemName:"
                    + featureNameStr.toString() + "已经存在,不能重复添加"};*/
            String[] message = new String[]{featureNameStr.toString() + "已经存在,不能重复添加"};
            result.setMessage(message);
            return result;
        }
        Map<Long,String> itemSkuMap = this.getItemSkuMap(insertList);
        //新增单品
        String itemCode = this.codeGenerateService.getMaxItemCode();
        String itemSku = null;
        for (SLPD0302IItemParam param : insertList) {
            //单品信息
            item = BeanUtils.toBean(param, SlpdItem.class);
            item.setItemId(this.maxId(TableConstant.Name.SLPD_ITEM));
            itemCode = String.format("%06d",Long.valueOf(itemCode) + NumberConst.IntDef.INT_ONE);
            item.setItemCode(itemCode);
            item.setAuditStu(false);        //TODO 审核状态暂定false
            item.setCrtTime(crtTime);
            item.setUpdTime(crtTime);
            item.setUpdId(super.getLoginUserId());
            item.setCrtId(super.getLoginUserId());
            String breedSku = breedSkuMap.get(param.getBreedId());
            if (StringUtils.isNotEmpty(breedSku)) {
                itemSku = itemSkuMap.get(param.getBreedId());
                if (StringUtils.isEmpty(itemSku)){
                    itemSku = breedSku + "001";
                    itemSkuMap.put(param.getBreedId(),itemSku);
                } else {
                    itemSku = String.format("%09d",Long.valueOf(itemSku) + NumberConst.IntDef.INT_ONE);
                    itemSkuMap.put(param.getBreedId(), itemSku);
                }
                item.setItemSku(itemSku);
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_EN, param.getBreedId().toString() + "对应的breedSku不存在,请联系管理员");
            }
            itemList.add(item);
            itemIds.add(item.getItemId());
        }

        int count = slpd0302IDao.saveItems(itemList);
        SLPD0302IResult result = new SLPD0302IResult();
        result.setCount(count);
        result.setItemIds(itemIds);
        return result;
    }

    /**
     * 获取breedSku
     */
    private Map<Long, String> getBreedSku(List<SLPD0302IItemParam> updateParam) {
        List<Long> breedIdList = new ArrayList<>();
        for (SLPD0302IItemParam param : updateParam) {
            breedIdList.add(param.getBreedId());
        }

        List<SlpdBreed> breedList = null;
        if (CollectionUtils.isNotEmpty(breedIdList)) {
            breedList = slpd0302IDao.findBreedSku(breedIdList);
        }

        Map<Long, String> result = new HashMap<>();
        if (CollectionUtils.isNotEmpty(breedIdList)) {
            for (SlpdBreed breed : breedList) {
                result.put(breed.getBreedId(), breed.getBreedSku());
            }
        }
        return result;
    }

    /**
     * 特征编码自增长(+1)
     * ITEM_CODE: 001
     */
    private Map<String,String> setItemCodeMap(Map<String,String> itemCodeMap,SLPD0302IItemParam param){
        String code = itemCodeMap.get(param.getClassesId()+"-"+param.getMachiningId()+"-"+param.getBreedId());
        int value = Integer.parseInt(code) + 1;
        String itemCode = String.format("%03d", value);
//        itemCodeMap.replace(param.getClassesId()+"-"+param.getMachiningId()+"-"+param.getBreedId(),itemCode);
        itemCodeMap.remove(param.getClassesId()+"-"+param.getMachiningId()+"-"+param.getBreedId());
        itemCodeMap.put(param.getClassesId()+"-"+param.getMachiningId()+"-"+param.getBreedId(),itemCode);
        return itemCodeMap;
    }

    /**
     * 根据一级分类、二级分类、品种ID，获取特征编码
     * ITEM_CODE: 001
     */
    private Map<Long,String> getItemSkuMap(List<SLPD0302IItemParam> insertList){
        Map<Long,String> itemCodeMap = new HashMap<>();
        List<SlpdItem> slpdItemList2 = slpd0302IDao.findItmeCode(insertList);
        if(CollectionUtils.isNotEmpty(slpdItemList2)){
            for (SlpdItem param : slpdItemList2) {
                itemCodeMap.put(param.getBreedId(),param.getItemSku());
            }
        }
        return itemCodeMap;
    }

}

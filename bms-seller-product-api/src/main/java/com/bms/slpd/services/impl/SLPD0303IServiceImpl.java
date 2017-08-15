package com.bms.slpd.services.impl;


import com.bms.slpd.bean.UpdateEntity;
import com.bms.slpd.bean.entity.SlpdItem;
import com.bms.slpd.bean.entity.SlpdProduct;
import com.bms.slpd.bean.entity.target.SlpdItemTarget;
import com.bms.slpd.bean.param.SLPD030301IParam;
import com.bms.slpd.bean.param.SLPD0303IParam;
import com.bms.slpd.bean.result.SLPD0303IResult;
import com.bms.slpd.constant.MessageConstant;
import com.bms.slpd.dao.SLPD0303IDao;
import com.bms.slpd.services.SLPD0303IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class SLPD0303IServiceImpl extends BaseServiceImpl implements SLPD0303IService {

    @Autowired
    private SLPD0303IDao slpd0303IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0303IDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SLPD0303IResult updateFeature(SLPD0303IParam requestParam) {
        SLPD0303IResult result = new SLPD0303IResult();
        Date updTime = DateUtils.getCurrent();
        SlpdItemTarget target = setTarget(requestParam);
        List<UpdateEntity<SlpdItem, SlpdItemTarget>> updateList = new ArrayList<>();
        List<SLPD030301IParam> updateBreed = requestParam.getUpdItemParams();
        StringBuilder exitStr = checkItemName(updateBreed);
        if (!ObjectUtils.isEmpty(exitStr)) {
            String[] msg = new String[]{exitStr.toString() + "已经存在,请更换要修改的单品名称"};
            result.setMessage(msg);
            return result;
        }
        SlpdItem feature = null;

        for (SLPD030301IParam param : updateBreed) {
            UpdateEntity<SlpdItem, SlpdItemTarget> updateEntity = new UpdateEntity<>();
            feature = BeanUtils.toBean(param, SlpdItem.class);
            feature.setUpdTime(updTime);
            feature.setUpdId(super.getLoginUserId());
            updateEntity.setEntity(feature);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> featureIds = new ArrayList<>();
        SlpdProduct product = new SlpdProduct();
        for (UpdateEntity<SlpdItem, SlpdItemTarget> updateEntity : updateList) {
            int featureCount = slpd0303IDao.updateFeature(updateEntity);
            if(target.isItemNameFlg()){
                product.setItemId(updateEntity.getEntity().getItemId());
                product.setItemName(updateEntity.getEntity().getItemName());
                product.setSpecification(updateEntity.getEntity().getSpecification());
                product.setUpdId(updateEntity.getEntity().getUpdId());
                product.setUpdTime(updateEntity.getEntity().getUpdTime());
                slpd0303IDao.updateProduct(product);
            }
            if (NumberConst.IntDef.INT_ZERO < featureCount) {
                count += featureCount;
                featureIds.add(updateEntity.getEntity().getItemId());
            } else {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH,
                        "单品修改失败,请刷新页面重试!");
            }
        }

        result.setCount(count);
        result.setFeatureIds(featureIds);
        result.setMessage(new String[]{MessageConstant.SUCCESS});
        return result;
    }

    public SlpdItemTarget setTarget(SLPD0303IParam requestParam) {
        String[] targets = requestParam.getTargets();
        StringBuilder builder = new StringBuilder();
        SlpdItemTarget featureTarget = new SlpdItemTarget();

        for (String str : targets) {
            if ("itemName".equals(str)) {
                featureTarget.setItemNameFlg(true);
            } else if ("specification".equals(str)) {
                featureTarget.setSpecificationFlg(true);
            } else if ("processingMethod".equals(str)) {
                featureTarget.setProcessingMethodFlg(true);
            } else if ("taste".equals(str)) {
                featureTarget.setTasteFlg(true);
            } else if ("delFlg".equals(str)) {
                featureTarget.setDelFlgFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }

        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.append("target指定有误").toString());
        }
        return featureTarget;
    }

    /**
     * 单品名唯一性check
     */
    private StringBuilder checkItemName(List<SLPD030301IParam> updItems) {
        List<SlpdItem> exitItems = slpd0303IDao.findBreedIdsAndItemNames(updItems);
        Map<Long, SlpdItem> exitItemMap = new HashMap<>();
        Map<Long, List<String>> exitItemInBreedMap = new HashMap<>();
        List<String> exitItemNameList = null;
        Long breedId = null;
        for (SlpdItem exitItem : exitItems) {
            exitItemMap.put(exitItem.getItemId(), exitItem);

            breedId = exitItem.getBreedId();
            if (!exitItemInBreedMap.containsKey(breedId)) {
                exitItemNameList = new ArrayList<>();
                exitItemNameList.add(exitItem.getItemName());
                exitItemInBreedMap.put(breedId, exitItemNameList);
            } else {
                exitItemInBreedMap.get(breedId).add(exitItem.getItemName());
            }
        }

        String updItemName = null;
        List<String> exitItemNames = null;
        SlpdItem sourceItem = null;
        StringBuilder exitStr = new StringBuilder();
        for (SLPD030301IParam updItem : updItems) {
            updItemName = updItem.getItemName();
            sourceItem = exitItemMap.get(updItem.getItemId());
            if (null == sourceItem) {
                throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "要修改的单品不存在!");
            }
            exitItemNames = exitItemInBreedMap.get(sourceItem.getBreedId());
            if (!sourceItem.getItemName().equals(updItemName) && exitItemNames.contains(updItemName)) {
                exitStr.append(updItemName).append(",");
            }
        }
        return exitStr;
    }

}

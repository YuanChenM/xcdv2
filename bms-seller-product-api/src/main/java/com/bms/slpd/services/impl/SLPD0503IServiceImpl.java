package com.bms.slpd.services.impl;

import com.bms.slpd.dao.SLPD0503IDao;
import com.bms.slpd.services.SLPD0503IService;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLPD0503IServiceImpl extends BaseServiceImpl implements SLPD0503IService {

    @Autowired
    private SLPD0503IDao slpd0503IDao;

    @Override
    public BaseDao getBaseDao() {
        return slpd0503IDao;
    }

    /**
     * {@inheritDoc}
     */
    /*@Override
    public SLPD0503IResult modifyBrandItems(UpdateRestRequest<SLPD0503IParam> requestParam) {
        List<UpdateEntity<SlpdBrandItem, SlpdBrandItemTarget>> updateList = new ArrayList<>();
        List<SLPD0503IParam> list = requestParam.getBeans();
        SlpdBrandItemTarget target = setTarget(requestParam);
        Date now = DateUtils.getCurrent();

        for (SLPD0503IParam param : list) {
            //排他处理
            updateVersion("SLPD_BRAND_ITEM", new String[]{"BRAND_ITEM_ID"}, new Long[]{param.getBrandItemId()}, param.getVersion());

            UpdateEntity<SlpdBrandItem, SlpdBrandItemTarget> updateEntity = new UpdateEntity<>();
            SlpdBrandItem brandItem = BeanUtils.toBean(param, SlpdBrandItem.class);
            brandItem.setUpdTime(now);
            updateEntity.setEntity(brandItem);
            updateEntity.setTarget(target);
            updateList.add(updateEntity);
        }

        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> brandItemIds = new ArrayList<>();
        for (UpdateEntity<SlpdBrandItem, SlpdBrandItemTarget> updateEntity : updateList) {
            int brandItemCount = slpd0503IDao.batchModify(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < brandItemCount) {
                count += brandItemCount;
                brandItemIds.add(updateEntity.getEntity().getBrandItemId());
            } else {
                throw new BusinessException("", "");
            }
        }

        SLPD0503IResult result = new SLPD0503IResult();
        result.setCount(count);
        result.setBrandItemIds(brandItemIds);

        return result;
    }*/

    /*public SlpdBrandItemTarget setTarget(UpdateRestRequest<SLPD0503IParam> requestParam) {
        String[] targets = requestParam.getTargets();
        if (targets == null) {
            throw new BusinessException("SLPD", MessageConstant.Info.I000005);
        }

        SlpdBrandItemTarget brandItemTarget = new SlpdBrandItemTarget();
        List<String> invalid = new ArrayList<>();
        for (String str : targets) {
            if ("itemId".equals(str)) {
                brandItemTarget.setItemIdFlg(true);
            } else if ("brandId".equals(str)) {
                brandItemTarget.setBrandIdFlg(true);
            } else if ("delFlg".equals(str)) {
                brandItemTarget.setDelFlgFlg(true);
            } else {
                invalid.add(str);
            }
        }

        if (invalid.size() > 0) {
            StringBuilder builder = new StringBuilder();
            for (String str : invalid) {
                builder.append(str).append(",");
            }
            throw new BusinessException("SLPD", MessageConstant.Error.E000010, builder.toString());
        }

        return brandItemTarget;
    }*/


}
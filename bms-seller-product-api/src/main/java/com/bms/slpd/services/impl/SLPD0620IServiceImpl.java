 package com.bms.slpd.services.impl;

 import com.bms.slpd.bean.UpdateEntity;
 import com.bms.slpd.bean.entity.SlpdTspStd;
 import com.bms.slpd.bean.entity.target.SlpdTspStdTarget;
 import com.bms.slpd.bean.param.SLPD0620IParam;
 import com.bms.slpd.bean.param.field.SLPD0619ITspStdParam;
 import com.bms.slpd.bean.result.SLPD0620IResult;
 import com.bms.slpd.constant.MessageConstant;
 import com.bms.slpd.dao.SLPD0620IDao;
 import com.bms.slpd.services.SLPD0620IService;
 import com.framework.boot.base.BaseDao;
 import com.framework.boot.base.BaseServiceImpl;
 import com.framework.core.utils.BeanUtils;
 import com.framework.core.utils.DateUtils;
 import com.framework.exception.BusinessException;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;

 import java.util.ArrayList;
 import java.util.List;

 @Service
 public class SLPD0620IServiceImpl extends BaseServiceImpl implements SLPD0620IService {

    @Autowired
    private SLPD0620IDao slpd0620IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0620IDao;
    }

     /**
      * {@inheritDoc}
      */
     @Override
     public SLPD0620IResult modifyTspStds(SLPD0620IParam requestParam) {
         SLPD0620IResult result = new SLPD0620IResult();
         List<Long> tncStdIds = new ArrayList<>();
         List<SLPD0619ITspStdParam> list = requestParam.getTspStdParams();
         SlpdTspStdTarget target = setTarget(requestParam);
         List<UpdateEntity<SlpdTspStd, SlpdTspStdTarget>> updateList = new ArrayList<>();
         int count = 0;
         for (SLPD0619ITspStdParam param : list) {
             UpdateEntity<SlpdTspStd, SlpdTspStdTarget> updateEntity = new UpdateEntity<>();
             SlpdTspStd tncStd = BeanUtils.toBean(param, SlpdTspStd.class);
             tncStd.setUpdTime(DateUtils.getCurrent());
             tncStd.setUpdId(super.getLoginUserId());
             updateEntity.setEntity(tncStd);
             updateEntity.setTarget(target);
             updateList.add(updateEntity);
         }

         StringBuilder builder;
         for (UpdateEntity<SlpdTspStd, SlpdTspStdTarget> updateEntity : updateList) {
             int num = slpd0620IDao.batchModify(updateEntity);
             if (0 < num) {
                 count += num;
                 tncStdIds.add(updateEntity.getEntity().getTspStdId());
             }else {
                 builder = new StringBuilder()
                         .append("修改存储运输:")
                         .append(updateEntity.getEntity().getTspStdId())
                         .append("失败，请刷新页面重试");
                 throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
             }
         }
         result.setCount(count);
         result.setTspStdIds(tncStdIds);

         return result;
     }

     public SlpdTspStdTarget setTarget(SLPD0620IParam requestParam) {
         String[] targets = requestParam.getTargets();
         if (targets == null) {
             throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
         }

         SlpdTspStdTarget tspStdTarget = new SlpdTspStdTarget();
         List<String> invalid = new ArrayList<>();
         for (String str : targets) {
             if ("tspOkVal".equals(str)) {
                 tspStdTarget.setTspOkValFlg(true);
             } else if ("tspNgVal".equals(str)) {
                 tspStdTarget.setTspNgValFlg(true);
             } else if ("remark".equals(str)) {
                 tspStdTarget.setRemarkFlg(true);
             } else if ("delFlg".equals(str)) {
                 tspStdTarget.setDelFlgFlg(true);
             } else {
                 invalid.add(str);
             }
         }

         if (invalid.size() > 0) {
             StringBuilder builder = new StringBuilder();
             for (String str : invalid) {
                 builder.append(str).append(",");
             }
             throw new BusinessException(MessageConstant.MODULE_NAME_ZH, builder.toString());
         }

         return tspStdTarget;
     }

 }
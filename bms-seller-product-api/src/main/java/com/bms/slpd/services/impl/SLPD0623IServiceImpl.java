 package com.bms.slpd.services.impl;

 import com.bms.slpd.bean.UpdateEntity;
 import com.bms.slpd.bean.entity.SlpdPkgStd;
 import com.bms.slpd.bean.entity.target.SlpdPkgStdTarget;
 import com.bms.slpd.bean.param.SLPD0623IParam;
 import com.bms.slpd.bean.param.field.SLPD0622IPkgStdParam;
 import com.bms.slpd.bean.result.SLPD0623IResult;
 import com.bms.slpd.constant.MessageConstant;
 import com.bms.slpd.dao.SLPD0623IDao;
 import com.bms.slpd.services.SLPD0623IService;
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
 public class SLPD0623IServiceImpl extends BaseServiceImpl implements SLPD0623IService {

    @Autowired
    private SLPD0623IDao slpd0623IDao;

    @Override
    public BaseDao getBaseDao() {
      return slpd0623IDao;
    }

     /**
      * {@inheritDoc}
      */
     @Override
     public SLPD0623IResult modifyPkgStds(SLPD0623IParam requestParam) {
         SLPD0623IResult result = new SLPD0623IResult();
         List<Long> pkgStdIds = new ArrayList<>();
         List<SLPD0622IPkgStdParam> list = requestParam.getPkgStdParams();
         SlpdPkgStdTarget target = setTarget(requestParam);
         List<UpdateEntity<SlpdPkgStd, SlpdPkgStdTarget>> updateList = new ArrayList<>();
         int count = 0;
         for (SLPD0622IPkgStdParam param : list) {
             UpdateEntity<SlpdPkgStd, SlpdPkgStdTarget> updateEntity = new UpdateEntity<>();
             SlpdPkgStd pkgStd = BeanUtils.toBean(param, SlpdPkgStd.class);
             pkgStd.setUpdTime(DateUtils.getCurrent());
             pkgStd.setUpdId(super.getLoginUserId());
             updateEntity.setEntity(pkgStd);
             updateEntity.setTarget(target);
             updateList.add(updateEntity);
         }

         StringBuilder builder;
         for (UpdateEntity<SlpdPkgStd, SlpdPkgStdTarget> updateEntity : updateList) {
             int num = slpd0623IDao.batchModify(updateEntity);
             if (0 < num) {
                 count += num;
                 pkgStdIds.add(updateEntity.getEntity().getPkgStdId());
             }else {
                 builder = new StringBuilder()
                         .append("修改包装:")
                         .append(updateEntity.getEntity().getPkgStdId())
                         .append("失败，请刷新页面重试");
                 throw new BusinessException(MessageConstant.MODULE_NAME_ZH,builder.toString());
             }
         }
         result.setCount(count);
         result.setPkgStdIds(pkgStdIds);

         return result;
     }

     public SlpdPkgStdTarget setTarget(SLPD0623IParam requestParam) {
         String[] targets = requestParam.getTargets();
         if (targets == null) {
             throw new BusinessException(MessageConstant.MODULE_NAME_ZH, "缺少targets");
         }

         SlpdPkgStdTarget pkgStdTarget = new SlpdPkgStdTarget();
         List<String> invalid = new ArrayList<>();

         for (String str : targets) {
             if ("pkgInSuttle".equals(str)) {
                 pkgStdTarget.setPkgInSuttleFlg(true);
             } else if ("pkgInError".equals(str)) {
                 pkgStdTarget.setPkgInErrorFlg(true);
             } else if("pkgInNumber".equals(str)){
                 pkgStdTarget.setPkgInNumberFlg(true);
             }else if ("pkgInSize".equals(str)){
                 pkgStdTarget.setPkgInSizeFlg(true);
             }else if("pkgInTexture".equals(str)){
                 pkgStdTarget.setPkgInTextureFlg(true);
             }else if ("pkgOutError".equals(str)){
                 pkgStdTarget.setPkgOutErrorFlg(true);
             }else if ("pkgOutNumber".equals(str)){
                 pkgStdTarget.setPkgOutNumberFlg(true);
             }else if ("pkgOutSize".equals(str)){
                 pkgStdTarget.setPkgOutSizeFlg(true);
             }else if ("pkgOutTexture".equals(str)){
                 pkgStdTarget.setPkgOutTextureFlg(true);
             }else if ("remark".equals(str)) {
                 pkgStdTarget.setRemarkFlg(true);
             } else if ("delFlg".equals(str)) {
                 pkgStdTarget.setDelFlgFlg(true);
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

         return pkgStdTarget;
     }

 }
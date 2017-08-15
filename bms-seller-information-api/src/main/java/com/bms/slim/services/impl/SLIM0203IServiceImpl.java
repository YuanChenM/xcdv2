package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.bms.slim.bean.entity.SlimSellerProducer;
import com.bms.slim.bean.entity.target.SlimProducerTarget;
import com.bms.slim.bean.param.SLIM0203IParam;
import com.bms.slim.bean.param.wrapper.SlimContactParam;
import com.bms.slim.bean.param.wrapper.SlimSellerProducerParam;
import com.bms.slim.bean.result.SLIM0203IResult;
import com.bms.slim.dao.SLIM0203IDao;
import com.bms.slim.services.SLIM0203IService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import com.framework.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SLIM0203IServiceImpl extends BaseServiceImpl implements SLIM0203IService {

    private final static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SLIM0201IServiceImpl.class);

    @Autowired
    private SLIM0203IDao slim0203IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0203IDao;
    }

    @Override
    public SLIM0203IResult updateSellerProducers(SLIM0203IParam slim0203IParam) {
        logger.debug("修改卖家生产商开始:参数---------------->" + slim0203IParam);
        BaseTarget baseTarget = setTarget(slim0203IParam);
        SLIM0203IResult result;
        //修改生产商联系人信息
        //this.updateContactInfo(slim0203IParam, baseTarget);
        //解绑卖家生产商
        if (baseTarget.isDelFlgFlg()) {//TODO 此处需判断角色 若卖家删除则解绑，若平台删除需判断该生产商是否有关联的卖家，有则解绑，没有则直接删除,将下边的注释解开
            //if(卖家角色)
            result = this.updateSellerProducerRelation(slim0203IParam);
            //TODO
            /*if(平台角色){
                  //查询生产商是否有关联卖家
                if(findProducersBySellerIds(slim0203IParam) == NumberConst.IntDef.INT_ZERO){
                    result = this.updateSellerProducerRelation(slim0203IParam);//解绑卖家生产商
                }else{
                    result = this.updateProducers(slim0203IParam);
                }
            }*/
        }else{
            result = updateProducers(slim0203IParam, baseTarget);
        }
        logger.debug("修改卖家生产商开始:参数---------------->" + slim0203IParam);
        return result;
    }

    /**
     * 查询卖家生产商关联信息
     * @param slim0203IParam
     * @return
     */
    private int findProducersBySellerIds(SLIM0203IParam slim0203IParam) {
        return slim0203IDao.findSellerProducerRelation(slim0203IParam);
    }

    @Override
    public SLIM0203IResult updateSellerProducerRelation(SLIM0203IParam slim0203IParam) {
        logger.debug("解绑卖家生产商开始:参数---------------->" + slim0203IParam);
        BaseTarget baseTarget = setTarget(slim0203IParam);
        SLIM0203IResult result = unbindSellerProducer(slim0203IParam, baseTarget);
        logger.debug("解绑卖家生产商开始:参数---------------->" + slim0203IParam);
        return result;
    }

    /**
     * 修改生产商联系人
     * @param slim0203IParam
     * @param contactTarget
     * @return
     */
    private SLIM0203IResult updateContactInfo(SLIM0203IParam slim0203IParam, BaseTarget contactTarget) {
        List<UpdateEntity<SlimContact, BaseTarget>> updateList = new ArrayList<>();
        logger.debug("修改生产商联系人信息---------------->" + contactTarget);
        List<SlimSellerProducerParam> params = slim0203IParam.getBeans();
        Date updTime = DateUtils.getCurrent();
        for (SlimSellerProducerParam param : params) {
            SlimContactParam contactParam = new SlimContactParam();
            contactParam.setContactName(param.getContactName());
            contactParam.setMobile(param.getMobile());
            contactParam.setEmail(param.getEmail());
            contactParam.setQq(param.getQq());
            contactParam.setWechat(param.getWechat());
            contactParam.setContactId(param.getContactId());
            contactParam.setUpdTime(updTime);
            contactParam.setUpdId(param.getUpdId());
            contactParam.setDelFlg(param.getDelFlg());
            contactParam.setVersion(param.getVersion());
            SlimContact slimContact = BeanUtils.toBean(contactParam, SlimContact.class);
            UpdateEntity<SlimContact, BaseTarget> updateProducer = new UpdateEntity<>();
            updateProducer.setEntity(slimContact);
            updateProducer.setTarget(contactTarget);
            updateList.add(updateProducer);
        }
        SLIM0203IResult result = updateProducerContacts(updateList);
        return result;
    }

    /**
     * 修改卖家生产商
     * @param slim0203IParam
     * @param baseTarget
     * @return
     */
    private SLIM0203IResult updateProducers(SLIM0203IParam slim0203IParam, BaseTarget baseTarget) {
        List<UpdateEntity<SlimProducer, BaseTarget>> updateList = new ArrayList<>();
        logger.debug("修改生产商信息---------------->" + baseTarget);
        SlimProducer slimProducer;
        List<SlimSellerProducerParam> params = slim0203IParam.getBeans();
        Date updTime = DateUtils.getCurrent();
        for (SlimSellerProducerParam param : params) {
            slimProducer = BeanUtils.toBean(param, SlimProducer.class);
            slimProducer.setUpdTime(updTime);
            UpdateEntity<SlimProducer, BaseTarget> updateProducer = new UpdateEntity<>();
            updateProducer.setEntity(slimProducer);
            updateProducer.setTarget(baseTarget);
            updateList.add(updateProducer);
        }
        SLIM0203IResult result = updateProducers(updateList);
        return result;
    }

    /**
     * 解绑卖家生产商
     * @param slim0203IParam
     * @param baseTarget
     * @return
     */
    private SLIM0203IResult unbindSellerProducer(SLIM0203IParam slim0203IParam, BaseTarget baseTarget) {
        List<UpdateEntity<SlimSellerProducer, BaseTarget>> updateRelationList = new ArrayList<>();
        logger.debug("解绑卖家生产商---------------->" + baseTarget);
        SlimSellerProducer slimProducer;
        List<SlimSellerProducerParam> params = slim0203IParam.getBeans();
        Date updTime = DateUtils.getCurrent();
        for (SlimSellerProducerParam param : params) {
            param.setVersion(param.getVersionC());
            slimProducer = BeanUtils.toBean(param, SlimSellerProducer.class);
            slimProducer.setUpdTime(updTime);
            UpdateEntity<SlimSellerProducer, BaseTarget> updateProducer = new UpdateEntity<>();
            updateProducer.setEntity(slimProducer);
            updateProducer.setTarget(baseTarget);
            updateRelationList.add(updateProducer);
        }
        SLIM0203IResult result = unBindSellerProducer(updateRelationList);
        return result;
    }

    /**
     * 修改生产商信息
     *
     * @param updateList
     * @return
     */
    private SLIM0203IResult updateProducers(List<UpdateEntity<SlimProducer, BaseTarget>> updateList) {
        SLIM0203IResult result = new SLIM0203IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        for (UpdateEntity<SlimProducer, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0203IDao.udpateSellerProducer(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                producerIds.add(updateEntity.getEntity().getProducerId());
            } else {
                throw new BusinessException("SLIM", "producerId:" + updateEntity.getEntity().getProducerId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setProducerIds(producerIds);
        return result;
    }

    /**
     * 修改生产商联系人信息
     *
     * @param updateList
     * @return
     */
    private SLIM0203IResult updateProducerContacts(List<UpdateEntity<SlimContact, BaseTarget>> updateList) {
        SLIM0203IResult result = new SLIM0203IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        for (UpdateEntity<SlimContact, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0203IDao.updateProducerContact(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                producerIds.add(updateEntity.getEntity().getContactId());
            } else {
                throw new BusinessException("SLIM", "contactId:" + updateEntity.getEntity().getContactId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setProducerIds(producerIds);
        return result;
    }

    /**
     * 解绑卖家生产商信息
     *
     * @param updateList
     * @return
     */
    private SLIM0203IResult unBindSellerProducer(List<UpdateEntity<SlimSellerProducer, BaseTarget>> updateList) {
        SLIM0203IResult result = new SLIM0203IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        for (UpdateEntity<SlimSellerProducer, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0203IDao.updateSellerProducerRelation(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                producerIds.add(updateEntity.getEntity().getProducerId());
            } else {
                throw new BusinessException("SLIM", "producerId:" + updateEntity.getEntity().getProducerId() + "不存在,修改失败");
            }
        }
        result.setCount(count);
        result.setProducerIds(producerIds);
        return result;
    }

    /**
     * 设置生产商target
     */
    private BaseTarget setTarget(SLIM0203IParam requestParam) {
        BaseTarget baseTarget;
        String[] targets = requestParam.getTargets();
        if (targets.length == NumberConst.IntDef.INT_ZERO)
            throw new BusinessException("SLIM", "请在targets指定要修改的字段名称", targets);
        StringBuilder builder = new StringBuilder();
        SlimProducerTarget slimProducerTarget = new SlimProducerTarget();
        for (String str : targets) {
            if ("fullName".equals(str)) {
                slimProducerTarget.setFullNameFlg(true);
            } else if ("shortName".equals(str)) {
                slimProducerTarget.setShortNameFlg(true);
            } else if ("countryCode".equals(str)) {
                slimProducerTarget.setCountryCodeFlg(true);
            } else if ("countryName".equals(str)) {
                slimProducerTarget.setCountryNameFlg(true);
            } else if ("provinceCode".equals(str)) {
                slimProducerTarget.setProvinceCodeFlg(true);
            } else if ("provinceName".equals(str)) {
                slimProducerTarget.setProvinceNameFlg(true);
            } else if ("cityCode".equals(str)) {
                slimProducerTarget.setCityCodeFlg(true);
            } else if ("cityName".equals(str)) {
                slimProducerTarget.setCityNameFlg(true);
            } else if ("address".equals(str)) {
                slimProducerTarget.setAddressFlg(true);
            } else if ("tel".equals(str)) {
                slimProducerTarget.setTelFlg(true);
            } else if ("fax".equals(str)) {
                slimProducerTarget.setFaxFlg(true);
            } else if ("mediaPlatform".equals(str)) {
                slimProducerTarget.setMediaPlatformFlg(true);
            } else if ("delFlg".equals(str)) {
                slimProducerTarget.setDelFlgFlg(true);
            } else if ("contactName".equals(str)) {
                slimProducerTarget.setContactNameFlg(true);
            } else if ("email".equals(str)) {
                slimProducerTarget.setEmailFlg(true);
            } else if ("qq".equals(str)) {
                slimProducerTarget.setQqFlg(true);
            } else if ("mobile".equals(str)) {
                slimProducerTarget.setMobileFlg(true);
            } else if ("wechat".equals(str)) {
                slimProducerTarget.setWechatFlg(true);
            } else {
                builder.append(str).append(",");
            }
        }
        baseTarget = slimProducerTarget;
        if (!ObjectUtils.isEmpty(builder)) {
            throw new BusinessException("SLIM", "指定的target字段" + builder.toString() + "有误");
        }
        return baseTarget;
    }

}

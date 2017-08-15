package com.bms.slim.services.impl;

import com.bms.slim.bean.BaseTarget;
import com.bms.slim.bean.UpdateEntity;
import com.bms.slim.bean.entity.SlimContact;
import com.bms.slim.bean.entity.SlimProducer;
import com.bms.slim.bean.entity.target.SlimProducerTarget;
import com.bms.slim.bean.param.SLIM0242IParam;
import com.bms.slim.bean.param.wrapper.SlimContactParam;
import com.bms.slim.bean.param.wrapper.SlimProducerParam;
import com.bms.slim.bean.result.SLIM0242IResult;
import com.bms.slim.dao.SLIM0242IDao;
import com.bms.slim.services.SLIM0242IService;
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
public class SLIM0242IServiceImpl extends BaseServiceImpl implements SLIM0242IService {

    @Autowired
    private SLIM0242IDao slim0242IDao;

    @Override
    public BaseDao getBaseDao() {
        return slim0242IDao;
    }

    @Override
    public SLIM0242IResult updateProducers(SLIM0242IParam slim0242IParam) {
        BaseTarget baseTarget = setTarget(slim0242IParam);
        //修改生产商信息
        SLIM0242IResult result = updateProducers(slim0242IParam, baseTarget);
        if(result.getCount() > NumberConst.IntDef.INT_ZERO){
            //修改生产商联系人信息
            this.updateContactInfo(slim0242IParam, baseTarget);
        }
        return result;
    }

    /**
     * 修改生产商联系人
     * @param slim0242IParam
     * @param contactTarget
     * @return
     */
    private SLIM0242IResult updateContactInfo(SLIM0242IParam slim0242IParam, BaseTarget contactTarget) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        List<UpdateEntity<SlimContact, BaseTarget>> updateList = new ArrayList<>();
        List<SlimProducerParam> params = slim0242IParam.getBeans();
        for (SlimProducerParam param : params) {
            SlimContactParam contactParam = new SlimContactParam();
            contactParam.setContactName(param.getContactName());
            contactParam.setMobile(param.getMobile());
            contactParam.setEmail(param.getEmail());
            contactParam.setQq(param.getQq());
            contactParam.setWechat(param.getWechat());
            contactParam.setContactId(param.getContactId());
            contactParam.setUpdTime(current);
            contactParam.setUpdId(userId);
            contactParam.setDelFlg(param.getDelFlg());
            contactParam.setVersion(param.getVersion());
            SlimContact slimContact = BeanUtils.toBean(contactParam, SlimContact.class);
            UpdateEntity<SlimContact, BaseTarget> updateProducer = new UpdateEntity<>();
            updateProducer.setEntity(slimContact);
            updateProducer.setTarget(contactTarget);
            updateList.add(updateProducer);
        }
        SLIM0242IResult result = updateProducerContacts(updateList);
        return result;
    }

    /**
     * 修改生产商
     * @param slim0242IParam
     * @param baseTarget
     * @return
     */
    private SLIM0242IResult updateProducers(SLIM0242IParam slim0242IParam, BaseTarget baseTarget) {
        final String userId = super.getLoginUserId();
        final Date current = DateUtils.getCurrent();

        List<UpdateEntity<SlimProducer, BaseTarget>> updateList = new ArrayList<>();
        SlimProducer slimProducer;
        List<SlimProducerParam> params = slim0242IParam.getBeans();
        for (SlimProducerParam param : params) {
            slimProducer = BeanUtils.toBean(param, SlimProducer.class);
            slimProducer.setUpdId(userId);
            slimProducer.setUpdTime(current);
            UpdateEntity<SlimProducer, BaseTarget> updateProducer = new UpdateEntity<>();
            updateProducer.setEntity(slimProducer);
            updateProducer.setTarget(baseTarget);
            updateList.add(updateProducer);
        }
        SLIM0242IResult result = updateProducers(updateList);
        return result;
    }


    /**
     * 修改生产商信息
     *
     * @param updateList
     * @return
     */
    private SLIM0242IResult updateProducers(List<UpdateEntity<SlimProducer, BaseTarget>> updateList) {
        SLIM0242IResult result = new SLIM0242IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        for (UpdateEntity<SlimProducer, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0242IDao.udpateProducer(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                producerIds.add(updateEntity.getEntity().getProducerId());
            } else {
                throw new BusinessException("SLIM", "producerId:" + updateEntity.getEntity().getProducerId() + "不存在或已被修改,修改失败");
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
    private SLIM0242IResult updateProducerContacts(List<UpdateEntity<SlimContact, BaseTarget>> updateList) {
        SLIM0242IResult result = new SLIM0242IResult();
        int count = NumberConst.IntDef.INT_ZERO;
        List<Long> producerIds = new ArrayList<>();
        for (UpdateEntity<SlimContact, BaseTarget> updateEntity : updateList) {
            int eachCount = slim0242IDao.updateProducerContact(updateEntity);
            if (NumberConst.IntDef.INT_ZERO < eachCount) {
                count = count + eachCount;
                producerIds.add(updateEntity.getEntity().getContactId());
            } else {
                throw new BusinessException("SLIM", "contactId:" + updateEntity.getEntity().getContactId() + "不存在或已被修改,修改失败");
            }
        }
        result.setCount(count);
        result.setProducerIds(producerIds);
        return result;
    }

    /**
     * 设置生产商target
     */
    private BaseTarget setTarget(SLIM0242IParam requestParam) {
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

package com.bms.order.services.impl;

import com.bms.order.archive.impl.Operator;
import com.bms.order.bean.entity.DistributionNotificationEntity;
import com.bms.order.bean.entity.DistributionNotificationHistoryEntity;
import com.bms.order.bean.param.ORDR0305IBeanParam;
import com.bms.order.constant.enumeration.DistributionNotificationStu;
import com.bms.order.constant.i18n.ErrorCode;
import com.bms.order.constant.i18n.ModuleCode;
import com.bms.order.dao.DistributionNotificationDao;
import com.bms.order.services.ORDR0305IService;
import com.framework.core.utils.DateUtils;
import com.framework.core.utils.StringUtils;
import com.framework.exception.BusinessException;
import com.framework.redis.dao.BaseRedisDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 配送通知单修改接口Service
 *
 * @author wu_honglei
 */
@Service
public class ORDR0305IServiceImpl implements ORDR0305IService {

    @Autowired
    private BaseRedisDao redisDao;

    @Autowired
    DistributionNotificationDao disDao;

    /**
     * 配送通知单修改
     *
     * @param operator 操作者
     * @param param    ORDR0305IBeanParam
     */
    @Transactional
    @Override
    public void execute(Operator operator, ORDR0305IBeanParam param) {
        // 数据权限验证
        checkDataAuthority(operator);
        DistributionNotificationEntity disEntity = new DistributionNotificationEntity();
        disEntity.setDistributionNotificationId(param.getDistributionNotificationId());
        disEntity.setDelFlg(false);
        // 配送通知单验证
        disEntity = disDao.findOne(disEntity);
        if (disEntity == null) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030401);
        } else if (!(disEntity.getDistributionNotificationStu().equals(DistributionNotificationStu.WAIT_FOR_WAREHOUSE.getCode())
                || disEntity.getDistributionNotificationStu().equals(DistributionNotificationStu.WAIT_FOR_WMS.getCode())) && !StringUtils.isEmpty(param.getWhCode())) {
            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E030501);
        }
        modifyDis(disEntity, param, operator);
    }


    /**
     * 数据权限验证
     *
     * @param operator
     */
    private void checkDataAuthority(Operator operator) {
        // todo
//        OperatorType operatorType = OperatorType.getInstance(operator.getOperatorType());
//        if (operatorType != OperatorType.MADE_4_NET) {
//            throw new BusinessException(ModuleCode.ORDR, ErrorCode.E000001, operatorType.getName());
//        }
    }

    /**
     * 修改配送通知单
     *
     * @param disEntity
     */
    private void modifyDis(DistributionNotificationEntity disEntity, ORDR0305IBeanParam param, Operator operator) {
        DistributionNotificationHistoryEntity historyEntity = new DistributionNotificationHistoryEntity();
        BeanUtils.copyProperties(disEntity, historyEntity);
        // 保存历史
        Long hisId = redisDao.getTablePrimaryKey("ordr_distribution_notification_history", 1);
        historyEntity.setHistoryId(hisId);
        disDao.saveHistory(historyEntity);
        // 返回参数
        disEntity.setDistributionNotificationStu(DistributionNotificationStu.WAIT_FOR_WMS.getCode());
        disEntity.setWhId(param.getWhId());
        disEntity.setWhCode(param.getWhCode());
        disEntity.setWhName(param.getWhName());
        disEntity.setUpdTime(DateUtils.getCurrent());
        disEntity.setUpdId(operator.getOperatorId());
        disDao.I0305modify(disEntity);
    }
}

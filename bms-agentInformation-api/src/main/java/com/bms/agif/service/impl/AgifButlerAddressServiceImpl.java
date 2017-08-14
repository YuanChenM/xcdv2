/*
 * 2017/03/01 自动生成 新規作成
 *
 * (c) 江苏润和.
 */
package com.bms.agif.service.impl;

import com.bms.agif.bean.entity.AgifButlerAddress;
import com.bms.agif.bean.param.ButlerAddressRsParam;
import com.bms.agif.dao.AgifButlerAddressDao;
import com.bms.agif.service.AgifButlerAddressService;
import com.framework.base.consts.NumberConst;
import com.framework.boot.base.BaseDao;
import com.framework.boot.base.BaseServiceImpl;
import com.framework.core.utils.BeanUtils;
import com.framework.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>AgifButlerAddressService接口实现类。</p>
 *
 * @author 自动生成
 * @version 1.00
 */
@Service
public class AgifButlerAddressServiceImpl extends BaseServiceImpl implements AgifButlerAddressService {

    @Autowired
    private AgifButlerAddressDao AgifButlerAddressDao;

    @Override
    public BaseDao getBaseDao() {
        return AgifButlerAddressDao;
    }

    @Override
    public int addButlerAddressList(List<ButlerAddressRsParam> butlerAddressList) {
        List<AgifButlerAddress> addressList = new ArrayList<>();
        int size = butlerAddressList.size();
        for (int i = 0; i < size; i++) {
            String loginUser = this.getLoginUserId();
            int count = this.getCount(butlerAddressList.get(i));
            if (count != NumberConst.IntDef.INT_ZERO) {
                return -1;
            }
            if (i != size - 1) {
                for (int j = i + 1; j < size; j++) {
                    if (butlerAddressList.get(i).getAddrType().equals(butlerAddressList.get(j).getAddrType())) {
                        return -1;
                    }
                }
            }

            AgifButlerAddress bean = BeanUtils.toBean(butlerAddressList.get(i), AgifButlerAddress.class);
            Date currentDate = DateUtils.getCurrent();
            Long maxId = this.maxId("AGIF_BUTLER_ADDRESS");
            bean.setUpdTime(currentDate);
            bean.setCrtTime(currentDate);
            bean.setUpdId(loginUser);
            bean.setCrtId(loginUser);
            bean.setDelFlg(false);
            bean.setVersion(1);
            bean.setAddrId(maxId);
            addressList.add(bean);
        }
        return AgifButlerAddressDao.batchInsert(addressList);
    }
}
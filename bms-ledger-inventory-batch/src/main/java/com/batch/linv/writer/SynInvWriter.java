package com.batch.linv.writer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.batch.linv.bean.entity.LinvCommInfo;
import com.batch.linv.bean.entity.LinvNameInfo;
import com.batch.linv.bean.entity.LinvSkuInfo;
import com.batch.linv.constant.ResponseDataReader;
import com.batch.linv.dao.LinvSynInvDao;
import com.framework.batch.item.database.MybatisItemWriter;

/**
 * Created by wangfan on 2017/2/21.
 */
public class SynInvWriter extends MybatisItemWriter<Map> {

    /**
     * 日志
     */
    private static final Logger logger = LoggerFactory.getLogger(SynInvWriter.class);

    @Override
    protected void doWrite(List<Map> list) throws Exception {

        LinvSynInvDao linvSynInvDao = (LinvSynInvDao) super.getBaseDao();

        if (list.size() > 0) {
            Map data = list.get(0);
            List<LinvNameInfo> nameInfoList = new ArrayList<LinvNameInfo>();
            List<LinvSkuInfo> skuInfoList = new ArrayList<LinvSkuInfo>();
            List<LinvCommInfo> commInfoList = new ArrayList<LinvCommInfo>();
            Object nameObj = data.get(ResponseDataReader.NAME);
            if (nameObj != null) {
                nameInfoList.addAll((List) nameObj);
            }

            Object skuInfoObj = data.get(ResponseDataReader.SKU);
            if (skuInfoObj != null) {
                skuInfoList.addAll((List) skuInfoObj);
            }

            Object commInfoObj = data.get(ResponseDataReader.COMM);
            if (commInfoObj != null) {
                commInfoList.addAll((List) commInfoObj);
            }

            for (int i = 0; i < skuInfoList.size(); i++) {
                linvSynInvDao.saveSkuInfo(skuInfoList.get(i));
            }
            for (int i = 0; i < nameInfoList.size(); i++) {
                linvSynInvDao.saveNameInfo(nameInfoList.get(i));
            }
            // 远程获得没有注册的商品信息
            for (int i = 0; i < commInfoList.size(); i++) {
                linvSynInvDao.saveCommInfo(commInfoList.get(i));
            }

            //1、同步生产商批次库存
            linvSynInvDao.synLotFromLoadByTran();
            //2、同步生产商供应商库存
            linvSynInvDao.synSpFromLoadByTran();
            //3、同步规格库存
            linvSynInvDao.synSpecFromLoadByTran();
            //4、同步平台商品库存
            linvSynInvDao.synPlatFromLoadByTran();
        }
    }
}

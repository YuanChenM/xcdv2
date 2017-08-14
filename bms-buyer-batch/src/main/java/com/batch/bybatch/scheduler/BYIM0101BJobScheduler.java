package com.batch.bybatch.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.batch.bybatch.configer.job.BYIM0101BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;

/**
 * Created by guan_zhongheng on 2017/2/23.
 */
@Component
public class BYIM0101BJobScheduler extends BaseJobScheduler {

    @Autowired
    private BYIM0101BJobConfiger byim0101BJobConfiger;

    @Scheduled(cron = "${BYIM0101B.job.schedulertime}")
    public void schedulerTime() throws Exception{
        super.execute(byim0101BJobConfiger.Byim0101bJob());
    }
}

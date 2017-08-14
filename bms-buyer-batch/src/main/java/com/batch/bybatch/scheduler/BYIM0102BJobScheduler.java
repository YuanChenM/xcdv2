package com.batch.bybatch.scheduler;

import com.batch.bybatch.configer.job.BYIM0102BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yuan_zhifei on 2017/5/25.
 */
@Component
public class BYIM0102BJobScheduler extends BaseJobScheduler {

    @Autowired
    private BYIM0102BJobConfiger byim0102BJobConfiger;

    @Scheduled(cron = "${BYIM0102B.job.schedulertime}")
    public void schedulerTime() throws Exception {
        super.execute(byim0102BJobConfiger.Byim0102bJob());
    }
}

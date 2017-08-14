package com.batch.order.scheduler;

import com.batch.order.configer.job.ORDR0303BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liutao on 2017/1/4.
 */
@Component
public class ORDR0303BJobScheduler extends BaseJobScheduler {
    @Autowired
    private ORDR0303BJobConfiger ordr0303BJobConfiger;

    @Scheduled(cron = "${ORDR0303B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(ordr0303BJobConfiger.ORDR0303BJob());
    }
}

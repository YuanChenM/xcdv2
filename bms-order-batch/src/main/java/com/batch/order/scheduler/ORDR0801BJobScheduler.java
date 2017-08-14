package com.batch.order.scheduler;

import com.batch.order.configer.job.ORDR0801BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liutao on 2017/1/4.
 */
@Component
public class ORDR0801BJobScheduler extends BaseJobScheduler {
    @Autowired
    private ORDR0801BJobConfiger ordr0801BJobConfiger;

    @Scheduled(cron = "${ORDR0801B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(ordr0801BJobConfiger.ORDR0801BJob());
    }
}

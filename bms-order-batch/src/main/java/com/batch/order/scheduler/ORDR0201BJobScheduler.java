package com.batch.order.scheduler;

import com.batch.order.configer.job.ORDR0201BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liutao on 2017/1/4.
 */
@Component
public class ORDR0201BJobScheduler extends BaseJobScheduler {
    @Autowired
    private ORDR0201BJobConfiger ordr0201BJobConfiger;

    @Scheduled(cron = "${ORDR0201B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(ordr0201BJobConfiger.ORDR0201BJob());
    }
}

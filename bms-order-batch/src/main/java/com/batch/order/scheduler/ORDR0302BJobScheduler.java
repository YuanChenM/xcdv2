package com.batch.order.scheduler;

import com.batch.order.configer.job.ORDR0302BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by liutao on 2017/1/4.
 */
@Component
public class ORDR0302BJobScheduler extends BaseJobScheduler {
    @Autowired
    private ORDR0302BJobConfiger ordr0302BJobConfiger;

    @Scheduled(cron = "${ORDR0302B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(ordr0302BJobConfiger.ORDR0302BJob());
    }
}

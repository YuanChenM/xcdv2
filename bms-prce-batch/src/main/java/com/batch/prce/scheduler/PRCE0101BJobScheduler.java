package com.batch.prce.scheduler;

import com.batch.prce.configer.job.PRCE0101BJobConfiger;
import com.framework.batch.core.BaseJobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by sunjiaju on 2017/2/17.
 */
@Component
public class PRCE0101BJobScheduler extends BaseJobScheduler {
    @Autowired
    private PRCE0101BJobConfiger prce0101BJobConfiger;

    @Scheduled(cron = "${PRCE0101B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(prce0101BJobConfiger.PRCE0101BJob());
    }
}

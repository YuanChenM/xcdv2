package com.batch.linv.scheduler;

import com.batch.linv.configer.job.SynInvJobConfiger;
import com.batch.linv.configer.job.SynWmsInvJobConfiger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.framework.batch.core.BaseJobScheduler;

/**
 * Created by wangfan on 2017/2/21.
 */
@Component
public class SynInvJobScheduler extends BaseJobScheduler {
//    @Autowired
//    private SynInvJobConfiger synInvJobConfiger;
//
//    @Scheduled(cron = "${Linv0001B.job.sometime}")
//    public void sometime() throws Exception {
//        super.execute(synInvJobConfiger.synInvJob());
//    }

    @Autowired
    private SynWmsInvJobConfiger synInvJobConfiger;

    @Scheduled(cron = "${Linv0001B.job.sometime}")
    public void sometime() throws Exception {
        super.execute(synInvJobConfiger.synWmsInvJob());
    }
}

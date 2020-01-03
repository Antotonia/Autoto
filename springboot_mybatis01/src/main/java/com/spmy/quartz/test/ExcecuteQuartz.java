package com.spmy.quartz.test;

import com.spmy.quartz.JobUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExcecuteQuartz {
    @Autowired
    private JobUtil jobUtil;

    public void addJob() throws Exception {
        jobUtil.addJob(ExecuteJob.class,"123","12345","0 0/1 * * * ? ");
    }
    public void delJob(String jobName,String jobgroupName) throws Exception {
        jobUtil.deleteJob(jobName,jobgroupName);
    }
}

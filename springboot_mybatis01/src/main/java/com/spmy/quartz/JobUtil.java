package com.spmy.quartz;

import com.spmy.modle.AppQuartz;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class JobUtil {
    @Autowired
    @Qualifier("scheduler")
    private Scheduler scheduler;
    private final Logger logger = LoggerFactory.getLogger(JobUtil.class);

    /**
     * 添加定时器
     * @param clazz          任务类
     * @param jobName        任务名称
     * @param jobGroupName   任务组
     * @param cronExpression 执行时间
     * @throws Exception
     */
    public void addJob(Class clazz,String jobName,String jobGroupName,String cronExpression) throws Exception  {
        try{
            //启动调度器
            scheduler.start();
            //构建job信息
            JobDetail jobDetail = JobBuilder.newJob(((Job)clazz.newInstance()).getClass()).withIdentity(jobName,jobGroupName).build();
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName,jobGroupName).withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail,trigger);
        }catch(Exception e){
            logger.info("",e);
            e.printStackTrace();
        }
    }
    /**
     * 获取Job状态
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    public String getJobState(String jobName, String jobGroup) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(jobName, jobGroup);
        return scheduler.getTriggerState(triggerKey).name();
    }

    //暂停所有任务
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    //暂停任务
    public String pauseJob(String jobName, String jobGroup) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return "fail";
        }else {
            scheduler.pauseJob(jobKey);
            return "success";
        }
    }

    //恢复所有任务
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    // 恢复某个任务
    public String resumeJob(String jobName, String jobGroup) throws SchedulerException {

        JobKey jobKey = new JobKey(jobName, jobGroup);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if (jobDetail == null) {
            return "fail";
        }else {
            scheduler.resumeJob(jobKey);
            return "success";
        }
    }

    /**
     *  删除某个定时任务
     * @param jobName       任务名称
     * @param jobgroupName  任务所在组名称
     */
    public void  deleteJob(String jobName,String jobgroupName) {
        try{
            scheduler.pauseTrigger(TriggerKey.triggerKey(jobName,jobgroupName));
            scheduler.unscheduleJob(TriggerKey.triggerKey(jobName,jobgroupName));
            scheduler.deleteJob(JobKey.jobKey(jobName,jobgroupName));
        }catch(Exception e){
            logger.info("",e);
        }

    }

    //修改任务
    public String  modifyJob(AppQuartz appQuartz) throws SchedulerException {
        if (!CronExpression.isValidExpression(appQuartz.getCronExpression())) {
            return "Illegal cron expression";
        }
        TriggerKey triggerKey = TriggerKey.triggerKey(appQuartz.getJobName(),appQuartz.getJobGroup());
        JobKey jobKey = new JobKey(appQuartz.getJobName(),appQuartz.getJobGroup());
        if (scheduler.checkExists(jobKey) && scheduler.checkExists(triggerKey)) {
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //表达式调度构建器,不立即执行
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(appQuartz.getCronExpression()).withMisfireHandlingInstructionDoNothing();
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                    .withSchedule(scheduleBuilder).build();
            //修改参数
            if(!trigger.getJobDataMap().get("invokeParam").equals(appQuartz.getInvokeParam())) {
                trigger.getJobDataMap().put("invokeParam",appQuartz.getInvokeParam());
            }
            //按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
            return "success";
        }else {
            return "job or trigger not exists";
        }

    }
}

package com.spmy.quartz;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Configuration
public class SchedulerConfig {
    @Autowired
    private JobFactory jobFactory;

    @Bean(name="schedulerFactory")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        //获取配置属性
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.setLocation(new FileSystemResource("D:\\MyProject\\quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        //创建SchedulerFactoryBean
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setQuartzProperties(propertiesFactoryBean.getObject());
        //使用数据源，自定义数据源
        factory.setQuartzProperties(propertiesFactoryBean.getObject());
        factory.setOverwriteExistingJobs(true);
        factory.setStartupDelay(60);
        factory.setJobFactory(jobFactory);
        return factory;
    }


    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }

}

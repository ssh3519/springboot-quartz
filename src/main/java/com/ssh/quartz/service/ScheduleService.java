package com.ssh.quartz.service;

import org.quartz.Job;

import java.util.Date;

/**
 * @description  Quartz定时任务操作类
 * @author: ssh
 * @Date: 2020/10/26 11:11
 */
public interface ScheduleService {
    /**
     * 通过CRON表达式调度任务
     */
    String scheduleJob(Class<? extends Job> jobBeanClass, String cron, String data);

    /**
     * 调度指定时间的任务
     */
    String scheduleFixTimeJob(Class<? extends Job> jobBeanClass, Date startTime, String data);

    /**
     * 取消定时任务
     */
    Boolean cancelScheduleJob(String jobName);
}

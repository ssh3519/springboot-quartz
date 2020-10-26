package com.ssh.quartz.controller;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import com.ssh.quartz.common.api.CommonResult;
import com.ssh.quartz.job.CronProcessJob;
import com.ssh.quartz.job.SendEmailJob;
import com.ssh.quartz.job.SendMessageJob;
import com.ssh.quartz.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @description 定时任务调度相关接口
 * @author: ssh
 * @Date: 2020/10/26 11:47
 */
@Api(tags = "ScheduleController", description = "定时任务调度相关接口")
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @ApiOperation("定时发送邮件")
    @PostMapping("/sendEmail")
    public CommonResult sendEmail(@RequestParam String startTime,@RequestParam String data) {
        Date date = DateUtil.parse(startTime, DatePattern.NORM_DATETIME_FORMAT);
        String jobName = scheduleService.scheduleFixTimeJob(SendEmailJob.class, date, data);
        return CommonResult.success(jobName);
    }

    @ApiOperation("定时发送站内信")
    @PostMapping("/sendMessage")
    public CommonResult sendMessage(@RequestParam String startTime, @RequestParam String data) {
        Date date = DateUtil.parse(startTime, DatePattern.NORM_DATETIME_FORMAT);
        String jobName = scheduleService.scheduleFixTimeJob(SendMessageJob.class, date, data);
        return CommonResult.success(jobName);
    }

    @ApiOperation("通过CRON表达式调度任务")
    @PostMapping("/scheduleJob")
    public CommonResult scheduleJob(@RequestParam String cron, @RequestParam String data) {
        String jobName = scheduleService.scheduleJob(CronProcessJob.class, cron, data);
        return CommonResult.success(jobName);
    }

    @ApiOperation("取消定时任务")
    @PostMapping("/cancelScheduleJob")
    public CommonResult cancelScheduleJob(@RequestParam String jobName) {
        Boolean success = scheduleService.cancelScheduleJob(jobName);
        return CommonResult.success(success);
    }
}

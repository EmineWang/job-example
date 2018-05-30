package com.yanming.test.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanming
 * @version 1.0.0
 * @description 兼容性测试
 **/
@Service
public class Task {
//    @Scheduled(cron = "*/5 * * * * ?")
    public void task1() throws InterruptedException {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任务一启动");
        Thread.sleep(10000);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    结束");

    }

//    @Scheduled(cron = "*/5 * * * * ?")
//    public void task2() throws InterruptedException {
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    任务二启动");
//        Thread.sleep(10000);
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "    " + Thread.currentThread().getName() + "    结束");
//    }
}

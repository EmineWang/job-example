package com.yanming.test.service;//package com.yanming.test.service;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.Executors;
//
///**
// * @author yanming
// * @version 1.0.0
// * @description
// * @date 2018/05/21 9:43
// **/
//@Configuration
//public class TestConfiguration implements SchedulingConfigurer {
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.setScheduler(TaskScheduler());
//    }
//    @Bean(destroyMethod = "shutdown")
//    public Executor TaskScheduler() {
//        return Executors.newScheduledThreadPool(10);
//    }
//
//
////
////    // 给sched用的，默认只有1个，时间太长会阻塞
////    @Bean(destroyMethod = "shutdown")
////    public Executor TesttaskScheduler222() {
////        return Executors.newScheduledThreadPool(10);
////    }
////
////    @Bean
////    public TaskScheduler taskScheduler(){
////        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
////        taskScheduler.setPoolSize(10);
////        taskScheduler.initialize();
////        return taskScheduler;
////    }
//}

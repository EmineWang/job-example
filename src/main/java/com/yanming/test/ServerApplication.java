package com.yanming.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author yanming
 * @version 1.0.0
 * @description
 * @date 2018/04/17 16:05
 **/
@SpringBootApplication
@ImportResource("classpath:spring.xml")
@EnableScheduling
public class ServerApplication {
    public static void main(String[] args) {

        //启动测试 参见readme.md
        SpringApplication.run(ServerApplication.class,args);
    }
}

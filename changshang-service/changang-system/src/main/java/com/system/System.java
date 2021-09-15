package com.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @PackageName:com.system
 * @ClassName:System
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 9:43
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.changshang.feign")
//注意 要使用通用的mapper的组件扫描
@MapperScan(basePackages = {"com.system.dao"})
public class System {
    public static void main(String[] args) {
            SpringApplication.run(System.class,args);
    }
}

package com.supper;

import entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

import javax.persistence.Id;

/**
 * @PackageName:com.supper
 * @ClassName:ChangShangSupper
 * @Description
 * @author: huangpeng
 * @date:2021/9/7 16:54
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.changshang.feign")
//注意 要使用通用的mapper的组件扫描
@MapperScan(basePackages = {"com.supper.dao"})
public class ChangShangSupper {
    public static void main(String[] args) {
        SpringApplication.run(ChangShangSupper.class,args);
    }
    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}

package com.restaurant;

import entity.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @PackageName:com.restaurant
 * @ClassName:Restaurant
 * @Description
 * @author: huangpeng
 * @date:2021/9/8 9:41
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.changshang.feign")
//注意 要使用通用的mapper的组件扫描
@MapperScan(basePackages = {"com.restaurant.dao"})
public class Restaurant {

    public static void main(String[] args) {
            SpringApplication.run(Restaurant.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return  new IdWorker();
    }
}

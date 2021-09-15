package com.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @PackageName:com.goods
 * @ClassName:ChangShangGoods
 * @Description
 * @author: huangpeng
 * @date:2021/9/7 11:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages ={"com.changshang.feign"})
//注意 要使用通用的mapper的组件扫描
@MapperScan(basePackages = {"com.goods.dao"})
public class ChangShangGoods {
    public static void main(String[] args) {
        SpringApplication.run(ChangShangGoods.class,args);
    }

}

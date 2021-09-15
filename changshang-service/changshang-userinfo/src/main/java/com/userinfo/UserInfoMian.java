package com.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @PackageName:com.userinfo
 * @ClassName:UserInfoMian
 * @Description
 * @author: huangpeng
 * @date:2021/9/13 16:24
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.userinfo.dao"})
public class UserInfoMian {
    public static void main(String[] args) {
        SpringApplication.run(UserInfoMian.class,args);
        /*PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String str = passwordEncoder.encode("hp123456");
        System.out.println(str);
        boolean b  = BCrypt.checkpw("hp12345611","");
        System.out.println(b);*/

    }

}

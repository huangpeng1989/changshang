package com.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @PackageName:com.gateway.config
 * @ClassName:BeanConfig
 * @Description
 * @author: huangpeng
 * @date:2021/9/13 15:16
 */
@Configuration
public class BeanConfig {


    //创建一个ipKeyResolver 指定用户的IP
    @Bean(name="ipKeyResolver")
    public KeyResolver keyResolver(){
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                //1.获取请求request对象
                ServerHttpRequest request = exchange.getRequest();
                //2.从request中获取ip地址
                String hostString = request.getRemoteAddress().getHostString();//Ip地址
                //3.返回
                return Mono.just(hostString);
            }
        };
    }
}

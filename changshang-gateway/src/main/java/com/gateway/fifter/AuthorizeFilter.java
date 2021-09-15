package com.gateway.fifter;

import com.alibaba.fastjson.JSON;
import com.gateway.uitl.JwtUtil;
import com.gateway.uitl.ResponseInfo;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


/**
 * 全局过滤器 :用于鉴权(获取令牌 解析 判断)
 *
 * @author www.itheima.com
 * @version 1.0
 * @package com.changgou.filter *
 * @since 1.0
 */
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "Authorization";
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //2.获取响应对象
        ServerHttpResponse response = exchange.getResponse();
        //3.判断 是否为登录的URL 如果是 放行
        if(request.getURI().getPath().startsWith("/userinfo-url/user/login")){
            return chain.filter(exchange);
        }
        //4.判断 是否为登录的URL 如果不是权限
        //4.1 从头header中获取令牌数据
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        boolean blean = true;
        if(StringUtils.isEmpty(token)){
            //4.2 从cookie中中获取令牌数据
            HttpCookie first = request.getCookies().getFirst(AUTHORIZE_TOKEN);
            if(first!=null){
                token=first.getValue();//就是令牌的数据
            }
            blean = false;
        }
        if(StringUtils.isEmpty(token)){
            //4.3 从请求参数中获取令牌数据
            token= request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        if(StringUtils.isEmpty(token)){
            //4.4. 如果没有数据 结束.
            return response.writeWith(Flux.just(buffer(response,"请登录！")));
        }
        //5 解析令牌数据 ( 判断解析是否正确,正确 就放行 ,否则 结束)
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            //解析失败
            return response.writeWith(Flux.just(buffer(response,"传递的token无效！")));
            //return response.setComplete();
        }
        if(!blean){
            request.mutate().header(AUTHORIZE_TOKEN,token);
        }
        return chain.filter(exchange);
    }

    private  DataBuffer buffer(ServerHttpResponse response,String message){
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        ResponseInfo responseInfo = new ResponseInfo();
        responseInfo.setCode("300");
        responseInfo.setData(message);
        String json = JSON.toJSONString(responseInfo);
        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer =response.bufferFactory().wrap(bytes);
        return buffer;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

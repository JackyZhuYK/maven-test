package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /*
        id相当于yml中配置的唯一标识
        当你访问http://localhost:9527/guonei
       就会跳转到http://news.baidu.com/guonei
         */
        routes.route("path_rote1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        /*
        id相当于yml中配置的唯一标识
        当你访问http://localhost:9527/guonei
       就会跳转到http://news.baidu.com/guonei
         */
        routes.route("path_rote2",
                r -> r.path("/game")
                        .uri("http://news.baidu.com/game")).build();
        return routes.build();
    }
}

package com.sharingsugar.apigateway.application.Configuration;

import com.sharingsugar.apigateway.application.Filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfiguration {
    @Autowired
    private AuthenticationFilter authenticationFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        AuthenticationFilter authenticationFilter=new
//                AuthenticationFilter();
        return builder.routes()
//                .route( r -> r.path("/api/auth/**")
//                        //.filters(f -> f.filter(authenticationFilter))
//                        .uri("lb://AUTHENTICATIONSERVICE"))
                .route(r->r.path("/api/auth/**")
                        .filters(f->f.filter(authenticationFilter))
                .uri("lb://AUTHENTICATIONSERVICE"))
                .build();
    }
}

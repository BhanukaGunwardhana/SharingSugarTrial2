package com.sharingsugar.apigateway.application.Filter;

import com.sharingsugar.apigateway.model.Beans.FeignProxy;
import com.sharingsugar.apigateway.model.Beans.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;


@Component
public class AuthenticationFilter implements GatewayFilter {
    private static final String AUTHORIZATION_HEADER = "Authorization";
//    @Autowired
//    private FeignProxy feignProxy;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private RouterValidator validator;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if(validator.isSecured.test(exchange.getRequest())){
            //System.out.println("end point called");
            //return exchange.getResponse().setComplete();
            //return chain.filter(exchange);
            String token = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION_HEADER);
            if (token == null || !token.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
                String errorMessage = "{\"message\": \"problem with token\"}";
                byte[] bytes = errorMessage.getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                return exchange.getResponse().writeWith(Mono.just(buffer));

                //System.out.println("havent any authorization header");
                //return exchange.getResponse().setComplete();
                //return chain.filter(exchange);
            }
            String authToken = token.substring(7);
            //boolean isAuthenticated = authenticationService.authenticate(authToken);
            //Boolean isValidated =feignProxy.validateToken(authToken);
            Boolean isValidated =jwtService.validateToken(authToken);
            if (!isValidated) {
                //exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                //return exchange.getResponse().setComplete();

                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
                String errorMessage = "{\"message\": \"Invalid token\"}";
                byte[] bytes = errorMessage.getBytes(StandardCharsets.UTF_8);
                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
                return exchange.getResponse().writeWith(Mono.just(buffer));
            }
        }

//        ServerHttpRequest request = exchange.getRequest().mutate()
//                .header("X-Authenticated-User", authenticationService.getUsername(authToken))
//                .build();
        //System.out.println("validate token has been recieved");
        return chain.filter(exchange);
    }
}

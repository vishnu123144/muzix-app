package com.stackroute.gateway.filter;

import com.stackroute.gateway.utils.JwtSecurityTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class CustomFilter extends AbstractGatewayFilterFactory {
    private JwtSecurityTokenUtil jwtSecurityTokenUtil;
    @Autowired
    public CustomFilter(JwtSecurityTokenUtil jwtSecurityTokenUtil){
        this.jwtSecurityTokenUtil=jwtSecurityTokenUtil;
    }
    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus)  {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            String token=exchange.getRequest().getHeaders().getFirst("token");
            if(token==null){
                return this.onError(exchange,"Token not present",HttpStatus.UNAUTHORIZED);
            }
            else if (!jwtSecurityTokenUtil.validateToken(token)){
                return this.onError(exchange,"Invalid token",HttpStatus.UNAUTHORIZED);
            }
            else if (token.isEmpty()){
                return this.onError(exchange,"Token not present",HttpStatus.UNAUTHORIZED);
            }
            return chain.filter(exchange); // Forward to route
        };
    }
}

package com.nikhilm.hourglass.gatewayservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

@Component
@Slf4j
public class RequestPreProcessorFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        Set<URI> uris = exchange.getAttributeOrDefault(GATEWAY_ORIGINAL_REQUEST_URL_ATTR, Collections.emptySet());
        String originalUri = (uris.isEmpty()) ? "Unknown" : uris.iterator().next().toString();
        Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
        URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
        log.info("Incoming request " + originalUri + " is routed to id: " + route.getId()
                + ", uri:" + routeUri);

        return exchange.getPrincipal().flatMap(principal -> {
            log.info("principal " + principal.getName());
            //exchange.getRequest().getHeaders().add("user", principal.getName());
            ServerHttpRequest request = exchange.getRequest()
                    .mutate()
                    .header("user", principal.getName())
                    .build();
            ServerWebExchange updatedExchange = exchange.mutate().request(request).build();
            return chain.filter(updatedExchange);
            //return chain.filter(exchange);
        }).switchIfEmpty(Mono.defer(()-> chain.filter(exchange)));

    }
}
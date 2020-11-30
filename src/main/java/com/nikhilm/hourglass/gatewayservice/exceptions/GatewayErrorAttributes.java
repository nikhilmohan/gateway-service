package com.nikhilm.hourglass.gatewayservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
@Slf4j
public class GatewayErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(request, includeStackTrace);


        log.info("Exception " + getError(request).getMessage() +":"+ getError(request));

        if (getError(request).getMessage().contains("Connection refused")) {
            map.put("exception", getError(request));
            map.put("message", getError(request).getMessage());
            map.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
            map.put("error", "Service unavailable. Please try after sometime!");

        }
        return map;
    }
}
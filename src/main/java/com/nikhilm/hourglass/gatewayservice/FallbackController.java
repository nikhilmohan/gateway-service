package com.nikhilm.hourglass.gatewayservice;

import com.nikhilm.hourglass.gatewayservice.fallbackutils.ResponseBuilder;
import com.nikhilm.hourglass.gatewayservice.response.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/health")
    public String health()  {
        return "ok";
    }

    @GetMapping("/movies/fallback")
    public MovieFallbackResponse movieFallbackHandler() {
        log.info("In gateway fallback!");

        return ResponseBuilder.buildMovieResponse();

    }
    @GetMapping("/trivia/fallback")
    public TriviaFallbackResponse triviaFallbackHandler() {
        log.info("In gateway fallback!");

        return ResponseBuilder.buildTriviaResponse();

    }
    @GetMapping("/dashboard/fallback")
    public DashboardFallbackResponse dashboardFallbackHandler() {
        log.info("In gateway fallback!");

        return ResponseBuilder.buildDashboardResponse();

    }
    @GetMapping("/userservice/user/fallback")
    public String dummy() {
        log.info("In gateway !");

        return "dummy response!";

    }



}

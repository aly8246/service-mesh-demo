package com.tskj365;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
public class UserInfoController {
    @Value("${user.username}")
    public String username;

    @GetMapping
    public Flux<String> getUser(Long userId){
        return Flux.just(userId+" username is "+username);
    }

    @GetMapping("/health")
    public Mono<ResponseEntity<String>> health() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return Mono.just(
                new ResponseEntity<>(
                        "{\"status\": \"Reviews is healthy\"}",
                        headers,
                        HttpStatus.OK
                )
        );
    }
}

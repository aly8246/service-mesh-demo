package com.tskj365;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class OrderController {
    private final RestTemplate restTemplate;

    @GetMapping
    public Flux<String> order(){
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://user:8000/", String.class);
        String body = forEntity.getBody();
        System.out.println(body);
        return Flux.just("user service response：{"+body+"} and order service response successful.");
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

package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class Controller {
    @Value("${test.age:0}")
    private Integer age;

    @Value("${test.email:null}")
    private String email;

    @Value("${test.webSite:null}")
    private String webSite;

    @Value("${test.password:null}")
    private String password;

    @GetMapping("/")
    public Map<String, String> getConfig() {
        Map<String, String> map = new HashMap<>();
        map.put("age", age.toString());
        map.put("email", email);
        map.put("webSite", webSite);
        map.put("password", password);
        return map;
    }


}

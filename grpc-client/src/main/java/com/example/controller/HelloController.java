package com.example.controller;

import com.example.service.HelloClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private HelloClientService clientService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return clientService.sayHello(name);
    }
}
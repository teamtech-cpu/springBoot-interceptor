package com.interceptor.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class TimerController {
    @GetMapping("/api/time")
    public LocalDateTime getTime(){
        System.out.println("Present Date"+LocalDateTime.now());
        return LocalDateTime.now();

    }
}

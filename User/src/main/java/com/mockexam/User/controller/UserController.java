package com.mockexam.User.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public ResponseEntity<String> test() throws InterruptedException {
        Thread.sleep(2000);
        return ResponseEntity.ok("User responding...");
    }
}

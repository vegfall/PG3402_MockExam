package com.mockexam.AI.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIController {
    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("AI responding...");
    }
}

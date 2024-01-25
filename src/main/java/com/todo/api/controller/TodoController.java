package com.todo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return  ResponseEntity.ok("Hi there");
    }
}

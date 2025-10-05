package com.primeiraapi.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    private List<String> tasks = new ArrayList<>();

    private ObjectMapper objectMapper;

    public ApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/tasks")
    public ResponseEntity<String> listTasks () throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(tasks));
    }

    @PostMapping(path = "/tasks")
    public ResponseEntity<Object> createTask(@RequestBody String task) {
        tasks.add(task);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/tasks")
    public ResponseEntity<Object> clearTasks() {
        tasks = new ArrayList<>();
        return ResponseEntity.ok().build();
    }
}

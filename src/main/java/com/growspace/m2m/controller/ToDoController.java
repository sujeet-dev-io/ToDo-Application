package com.growspace.m2m.controller;

import com.growspace.m2m.dto.ToDoRequest;
import com.growspace.m2m.dto.ToDoResponse;
import com.growspace.m2m.response.ApiResponse;
import com.growspace.m2m.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @PostMapping("/todo")
    public ResponseEntity<ApiResponse<ToDoResponse>> startTodo(@Valid @RequestBody ToDoRequest request) {
        ToDoResponse response = service.createToDo(request);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", response));
    }

    @GetMapping("/todo/descending/all")
    public ResponseEntity<ApiResponse<List<ToDoResponse>>> getAllTodos() {
        List<ToDoResponse> list = service.getAllToDosInDescendingOrder();
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", list));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<ApiResponse<ToDoResponse>> markCompleted(@PathVariable Long id) {
        ToDoResponse updated = service.markAsCompleted(id);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", updated));
    }

    //Extra additional feature Update toDo
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<ToDoResponse>> updateTodo(@PathVariable Long id, @Valid @RequestBody ToDoRequest request) {
        ToDoResponse response = service.updateToDo(id, request);
        return ResponseEntity.ok(new ApiResponse<>("SUCCESS", response));
    }

}

package com.growspace.m2m.service;

import com.growspace.m2m.dto.ToDoRequest;
import com.growspace.m2m.dto.ToDoResponse;

import java.util.List;

public interface ToDoService {
    ToDoResponse createToDo(ToDoRequest request);

    public List<ToDoResponse> getAllToDosInDescendingOrder();

    ToDoResponse markAsCompleted(Long id);

    ToDoResponse updateToDo(Long id, ToDoRequest request);


}

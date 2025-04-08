package com.growspace.m2m.service;

import com.growspace.m2m.dto.ToDoRequest;
import com.growspace.m2m.dto.ToDoResponse;
import com.growspace.m2m.entity.ToDo;
import com.growspace.m2m.exception.ResourceNotFoundException;
import com.growspace.m2m.repository.TodoRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToDoServiceImpl implements ToDoService{

    private final TodoRepo repository;
    private final ModelMapper modelMapper;

    @Override
    public ToDoResponse createToDo(ToDoRequest request) {
        log.info("Request received to add Todo details, req :: {}", request);
        ToDo toDo = modelMapper.map(request, ToDo.class);
            ToDo saved = repository.save(toDo);
        log.info("Todo list create successfully.. {}", request);
            return modelMapper.map(saved, ToDoResponse.class);
    }

    @Override
    public List<ToDoResponse> getAllToDosInDescendingOrder() {
        log.info("find all todolist details...");
        List<ToDo> todos = repository.findAllByOrderByCreatedAtDesc();
        return todos.stream()
                .map(todo -> modelMapper.map(todo, ToDoResponse.class))
                .collect(Collectors.toList());
    }

    //Update  todolist details
    @Override
    public ToDoResponse markAsCompleted(Long id) {
        ToDo todo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        if (!todo.getCompleted()) {
            todo.setCompleted(true);
            todo = repository.save(todo);
        }

        return modelMapper.map(todo, ToDoResponse.class);
    }

    @Override
    public ToDoResponse updateToDo(Long id, ToDoRequest request) {
        ToDo todo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ToDo not found with id: " + id));
        todo.setTitle(request.getTitle());
        todo.setDescription(request.getDescription());
        // Save updated todo
        ToDo updated = repository.save(todo);
        return modelMapper.map(updated, ToDoResponse.class);
    }

}

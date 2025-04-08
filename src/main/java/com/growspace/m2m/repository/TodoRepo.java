package com.growspace.m2m.repository;

import com.growspace.m2m.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepo extends JpaRepository<ToDo, Long> {
    List<ToDo> findAllByOrderByCreatedAtDesc();
}

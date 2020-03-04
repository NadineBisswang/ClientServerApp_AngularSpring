package com.server.todolist.repo;

import com.server.todolist.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepo extends JpaRepository<TodoItem, Long> {

}

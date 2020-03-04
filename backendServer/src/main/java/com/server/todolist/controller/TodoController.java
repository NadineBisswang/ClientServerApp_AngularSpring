package com.server.todolist.controller;

import com.server.todolist.model.TodoItem;
import com.server.todolist.repo.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
//HTTP Anfragen werden von dem Controller bearbeitet
@RestController //Spring Annotation, kennzeichnet Klasse als Controller, Objektdaten werden als JSON direkt in HTTP-Antwort geschrieben
@RequestMapping(value= "/todo")
@CrossOrigin(origins = "*")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepo.findAll();
    }

    @PostMapping
    //@NotNull lässt keine Nullwerte für eingeschränkte Felder zu
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @PutMapping //Updates the data
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);
    }
}

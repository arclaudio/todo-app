package com.arclaudio.todo.controller;

import com.arclaudio.todo.dto.TodoDTO;
import com.arclaudio.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO) {
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDTO> getTodoById(@PathVariable("id") Long todoId){
        TodoDTO todo = todoService.getTodoById(todoId);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getTodos(){
        List<TodoDTO> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoDTO> updateTodo(@PathVariable("id") Long todoId,
                                              @RequestBody TodoDTO todoDTO){
        TodoDTO updatedTodo = todoService.updateTodo(todoId, todoDTO);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Successfully deleted Todo with id: "+todoId);
    }
}

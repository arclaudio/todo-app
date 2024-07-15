package com.arclaudio.todo.service;

import com.arclaudio.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO addTodo(TodoDTO todoDTO);

    TodoDTO getTodoById(Long todoId);

    List<TodoDTO> getAllTodos();

    TodoDTO updateTodo(Long todoId, TodoDTO todoDTO);

    void deleteTodo(Long todoId);

    TodoDTO completeTodo(Long todoId);

    TodoDTO incompleteTodo(Long todoId);
}

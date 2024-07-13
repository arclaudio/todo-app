package com.arclaudio.todo.service.impl;

import com.arclaudio.todo.dto.TodoDTO;
import com.arclaudio.todo.entity.Todo;
import com.arclaudio.todo.repository.TodoRepository;
import com.arclaudio.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImp implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {
        Todo todo = modelMapper.map(todoDTO, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        return modelMapper.map(savedTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO getTodoById(Long todoId) {
        return null;
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        return List.of();
    }

    @Override
    public TodoDTO updateTodo(Long todoId, TodoDTO todoDTO) {
        return null;
    }

    @Override
    public void deleteTodo(Long todoId) {

    }
}

package com.arclaudio.todo.service.impl;

import com.arclaudio.todo.dto.TodoDTO;
import com.arclaudio.todo.entity.Todo;
import com.arclaudio.todo.exception.ResourceNotFoundException;
import com.arclaudio.todo.repository.TodoRepository;
import com.arclaudio.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + todoId));
        return modelMapper.map(todo, TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTodo(Long todoId, TodoDTO todoDTO) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + todoId));
        todo.setTitle(todoDTO.getTitle());
        todo.setDescription(todoDTO.getDescription());
        todo.setCompleted(todoDTO.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + todoId));
        todoRepository.deleteById(todoId);
    }
}

package com.example.todolist.service;


import com.example.todolist.dto.TodoDto;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private TodoRepository repository;

    // 추가
    public TodoDto save(TodoDto dto) {
        Todo todo = repository.save(new Todo(
                dto.getContent()));
        return new TodoDto(todo.getId(), todo.getContent());
    }

    // 조회
    public List<TodoDto> getAll() {
        List<Todo> todolist = repository.findAllByOrderByIdDesc();
        List<TodoDto> list = new ArrayList<>();
        for (Todo todo : todolist) {
            list.add(new TodoDto(todo.getId(), todo.getContent()
            ));
        }
        return list;
    }

    // 수정
    public TodoDto update(Long id, TodoDto dto) {
        Todo todo = repository.findById(id).orElse(null);
        if (todo != null) {
            todo.setContent(dto.getContent());

            Todo updatedTodo = repository.save(todo);
            return new TodoDto(updatedTodo.getId(), updatedTodo.getContent());
        }
        return null;
    }



    // 삭제
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
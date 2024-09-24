package com.example.todolist.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
public class TodoDto {
    private Long id;
    private String content;
    // private LocalDate createdDate;

    public TodoDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
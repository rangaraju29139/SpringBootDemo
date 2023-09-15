package com.example.springboottodo.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    static{
        todos.add(new Todo(1,"rangaraju","learn springboot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2,"rangaraju","learn devops", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3,"rangaraju","learn fullstack", LocalDate.now().plusYears(1),false));
    }

    public static List<Todo> getTodos() {
        return todos;
    }

    public static List<Todo> findByUserName(String userName) {
    return todos;
    }
}

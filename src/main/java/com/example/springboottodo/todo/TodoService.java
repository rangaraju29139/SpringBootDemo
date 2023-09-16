package com.example.springboottodo.todo;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int id=0;
    static{
        todos.add(new Todo(++id,"rangaraju","learn springboot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++id,"rangaraju","learn devops", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++id,"rangaraju","learn fullstack", LocalDate.now().plusYears(1),false));
    }

    public static List<Todo> getTodos() {
        return todos;
    }

    public static List<Todo> findByUserName(String userName) {
    return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate,boolean done){
        todos.add(new Todo(++id,username, description, targetDate, done));
    }

    public void deleteTodoById(int id){
        Predicate<? super Todo> predicate = (todo) -> todo.getId()== id;

        todos.removeIf(predicate);
    }
}

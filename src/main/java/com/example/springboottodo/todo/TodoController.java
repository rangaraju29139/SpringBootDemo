package com.example.springboottodo.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todoList = todoService.findByUserName("rangaraju");
        model.addAttribute("todos", todoList);
        return "listTodos";
    }
}

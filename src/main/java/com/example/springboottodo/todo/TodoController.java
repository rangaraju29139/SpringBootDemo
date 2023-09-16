package com.example.springboottodo.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
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

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String username = (String)model.get("username");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
       model.put("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model,Todo todo){
        String username=(String)model.get("name");
        todoService.addTodo(username,todo.getDescription(), LocalDate.now().plusYears(1),false);
        return "redirect:list-todos";
    }
}

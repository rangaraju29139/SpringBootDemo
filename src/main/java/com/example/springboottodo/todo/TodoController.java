package com.example.springboottodo.todo;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "addTodo";
        }

        String username=(String)model.get("name");
        LocalDate targetDate = todo.getTargetDate();
        todoService.addTodo(username,todo.getDescription(), targetDate,false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/delete-todo",method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
          todoService.deleteTodoById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "/update-todo",method = RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id,ModelMap model){
        Todo todo=todoService.findById(id);
        model.addAttribute("todo",todo);
        return "updateTodo";
    }
    @RequestMapping(value = "/update-todo",method = RequestMethod.POST)
    public String updateTodoById(ModelMap model,@Valid Todo todo,BindingResult result){
        if(result.hasErrors()){
            return "updateTodo";
        }
        String description = todo.getDescription();
        int id = todo.getId();
        LocalDate targetDate = todo.getTargetDate();
        todoService.updateTodoById(id,description,targetDate);
        return "redirect:list-todos";
    }
}

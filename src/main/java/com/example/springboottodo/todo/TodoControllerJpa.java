package com.example.springboottodo.todo;


import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {


    private TodoService todoService;
    private TodoRepository todoRepository;

    public TodoControllerJpa(TodoService todoService,TodoRepository todoRepository) {
        super();
        this.todoService = todoService;
        this.todoRepository = todoRepository;
    }

    private String getLoggedinUsername(){
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }




    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap model){
        String username = getLoggedinUsername();
        System.out.println(username);
       List<Todo> todoList= todoRepository.findByUserName(username);
   //    List<Todo> todoList = todoService.findByUserName(getLoggedinUsername());
        model.addAttribute("todos", todoList);
        System.out.println(todoList);
        return "listTodos";
    }

    @RequestMapping(value = "/add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){

        Todo todo = new Todo(0,getLoggedinUsername(),"",LocalDate.now().plusYears(1),false);
       model.put("todo",todo);
        return "addTodo";
    }
    @RequestMapping(value = "/add-todo",method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if(result.hasErrors()){
            return "addTodo";
        }


        todo.setUserName(getLoggedinUsername());

//        todoService.addTodo(getLoggedinUsername(),todo.getDescription(), todo.getTargetDate(),todo.isDone() );
        todoRepository.save(todo);

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

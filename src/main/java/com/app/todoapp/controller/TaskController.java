package com.app.todoapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {
    private final TaskService taskService;
    
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks"; //it will look for tasks template under resources folder.
    }

    @PostMapping
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }
}

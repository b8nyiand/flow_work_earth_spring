package hu.flow.todolist.controller;

import hu.flow.todolist.model.Todo;
import hu.flow.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/update")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @GetMapping("/list")
    public List<Todo> listTodos() {
        return todoService.findAllTodos();
    }

    @GetMapping("/findById/{id}")
    public Todo findTodoById(@PathVariable Long id) {
        return todoService.findTodoById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Todo> findTodoByName(@PathVariable String name) {
        return todoService.findAllTodosByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}

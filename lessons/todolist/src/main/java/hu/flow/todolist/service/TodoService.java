package hu.flow.todolist.service;

import hu.flow.todolist.model.Todo;
import hu.flow.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo findTodoById(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        return todoOptional.orElse(null);
    }

    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> findAllTodosByName(String name) {
        return todoRepository.findByName(name);
    }

}

package hu.flow.todolist;

import hu.flow.todolist.model.SubTask;
import hu.flow.todolist.model.Todo;
import hu.flow.todolist.repository.SubTaskRepository;
import hu.flow.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	@Autowired
	private TodoRepository todoRepository;

	@Autowired
	private SubTaskRepository subTaskRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {
			if (todoRepository.findAll().isEmpty()) {
				Todo todo = new Todo("mosogatas", 99);
				Todo todo2 = new Todo("porszivozas", 100);

				todoRepository.save(todo);
				todoRepository.save(todo2);

				SubTask task1 = new SubTask("oblites", 1, todo);
				SubTask task2 = new SubTask("surolas", 2, todo);

				subTaskRepository.save(task1);
				subTaskRepository.save(task2);
			}
		};
	}

}

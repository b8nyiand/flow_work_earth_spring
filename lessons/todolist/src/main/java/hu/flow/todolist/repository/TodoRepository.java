package hu.flow.todolist.repository;

import hu.flow.todolist.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long>{

    public List<Todo> findByName(String name);

}

package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    public List<User> findByFullName(String name);
}

package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.modell.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}

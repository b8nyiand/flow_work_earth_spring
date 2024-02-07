package hu.flowacademy.user.repository;

import hu.flowacademy.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByName(String name);

    public List<User> findByPointsGreaterThan(int points);

}

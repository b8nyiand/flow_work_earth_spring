package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
     User findByUsername(String username);

     void deleteByUsername(String username);

     List<User> findByFullNameLike(String fullName);
}

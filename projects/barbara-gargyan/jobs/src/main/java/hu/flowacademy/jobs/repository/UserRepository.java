package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    public List<User> findByFullNameContaining(String partialName);

    public List<User> findByFullName(String fullName);

    public List<User> findByUserName(String userName);
}

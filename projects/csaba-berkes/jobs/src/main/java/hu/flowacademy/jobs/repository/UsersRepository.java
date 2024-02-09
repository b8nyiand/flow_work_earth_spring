package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.modell.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findByFullname(String fullname);

}
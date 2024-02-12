package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findByFullname(String fullname);
    List<Users> findByFullnameLike(String fullname);
    List<Users> findByUsername(String username);

}

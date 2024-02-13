package hu.flowacademy.ads.repository;

import hu.flowacademy.ads.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String > {
}

package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByUserUsername(String username);

}

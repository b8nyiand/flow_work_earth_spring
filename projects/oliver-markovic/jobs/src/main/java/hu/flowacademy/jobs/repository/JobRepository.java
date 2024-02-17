package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByUserUsername(String username);

    List<Job> findBySalaryGreaterThan(int salary);

    List<Job>findBySalaryLessThan(int salary);

    List<Job>findByTitle(String title);
}

package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findBySalaryGreaterThan(int salary);
    List<Job> findBySalaryLessThan(int salary);
    List<Job> findByTitleLike(String title);

}

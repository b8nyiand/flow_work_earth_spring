package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
    public List<Jobs> findByUserName(String userName);

   public List<Jobs> findBySalaryGreaterThan(int i);
   public List<Jobs> findBySalaryLessThan(int i);
}

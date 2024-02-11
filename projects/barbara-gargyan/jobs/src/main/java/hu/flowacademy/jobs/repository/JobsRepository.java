package hu.flowacademy.jobs.repository;

import hu.flowacademy.jobs.model.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs,Long> {
}

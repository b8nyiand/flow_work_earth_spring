package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UsersService usersService;

    public void deleteJob(Job id) {
        jobRepository.delete(id);
    }

    //FIXME Add job
    public Job addJobToUser(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> findBySalary() {
        return jobRepository.findBySalaryGreaterThan(1000000);
    }

    public List<Job> findByLessSalary() {
        return jobRepository.findBySalaryLessThan(500000);
    }

    public List<Job> findByTitle() {
        return jobRepository.findByTitleLike("%Spring%");
    }

    public List<Job> findByAnySalaryGreaterThan(int salary) {
        return jobRepository.findBySalaryGreaterThan(salary);
    }

    public Job findById(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            return jobOptional.get();
        }
        throw new RuntimeException("No user found");
    }

}

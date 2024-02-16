package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UsersRepository;
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
    private UsersRepository usersRepository;

    public void deleteJob(Job id) {
        jobRepository.delete(id);
    }

    public Job addJobToUser(String username, Job job) {
        List<Users> users = usersRepository.findByUsername(username);
        if (!users.isEmpty()) {
            Users users1 = users.get(0);
            job.setUsers(users1);
            return jobRepository.save(job);
        } else {
            throw new RuntimeException("Ilyen felhasználó nincs: " + username);
        }
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
    public Job updateJob(Job job){
        return jobRepository.save(job);
    }

}

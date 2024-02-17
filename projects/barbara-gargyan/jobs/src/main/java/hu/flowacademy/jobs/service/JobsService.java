package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobsRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private UserRepository userRepository;

    public Jobs createJob(String userName, Jobs jobs) {
        List<User> users = userRepository.findByUserName(userName);
        if (!users.isEmpty()) {
            User user = users.get(0);
            jobs.setUser(user);

            return jobsRepository.save(jobs);
        } else {
            throw new RuntimeException("A felhasználó nem található: " + userName);
        }
    }

    public Jobs updateJob(String userName, Jobs updatedJob) {
        List<Jobs> jobs = jobsRepository.findByUserName(userName);
        if (!jobs.isEmpty()) {
            Jobs existingJob = jobs.get(0);
                      existingJob.setTitle(updatedJob.getTitle());
            existingJob.setSalary(updatedJob.getSalary());
            existingJob.setDescription(updatedJob.getDescription());
            return jobsRepository.save(existingJob);
        } else {
            throw new RuntimeException("A felhasználóhoz nem található munka rögzítve: " + userName);
        }
    }

    public void deleteJob(Long id) {
        jobsRepository.deleteById(id);
    }

    public List<Jobs> getJobsByUserName(String userName) {
        return jobsRepository.findByUserName(userName);
    }

    public Jobs getJobById(Long id)
    {
        return jobsRepository.findById(id).orElse(null);
    }

    public List<Jobs> getJobByTitle(String title){                  // 6. Job lekérdezése title alapján
        return jobsRepository.findJobByTitle(title);
    }

     public List<Jobs> getJobsWithSalaryGreaterThan(int salary) {
        return jobsRepository.findBySalaryGreaterThan(salary);
    }

    public List<Jobs>listAllJobs(){
        return jobsRepository.findAll();
    }
}






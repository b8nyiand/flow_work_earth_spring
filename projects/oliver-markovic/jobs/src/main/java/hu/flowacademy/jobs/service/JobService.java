package hu.flowacademy.jobs.service;


import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job addJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getUsersJobs(String userName) {
        return jobRepository.findByUserUsername(userName);
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }
}

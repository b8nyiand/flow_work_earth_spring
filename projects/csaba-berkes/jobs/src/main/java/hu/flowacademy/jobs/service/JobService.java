package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findBySalary() {
        return jobRepository.findBySalaryGreaterThan(1000000);
    }

    public List<Job> findByLessSalary() {
        return jobRepository.findBySalaryLessThan(500000);
    }
    public  List<Job> findByTitle(){
        return jobRepository.findByTitleLike("%Spring%");
    }
    public List<Job> findByAnySalaryGreaterThan(int salary){
        return jobRepository.findBySalaryGreaterThan(salary);
    }
}

package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/above-one-mill")
    public List<Job> higherThan1Mill(){
        return jobRepository.findBySalaryGreaterThan(1000000);
    }

    @GetMapping("/lowest-salaries")
    public List<Job> lowerThan500k(){
        return jobRepository.findBySalaryLessThan(500000);
    }

    @GetMapping("/get-username")
    public List<User> userName() {
        return userRepository.findByFullNameLike("Molnar%");
    }

    @GetMapping("/get-title")
    public List<Job> jobTitle() {
        return jobRepository.findByTitle("Spring");
    }

}

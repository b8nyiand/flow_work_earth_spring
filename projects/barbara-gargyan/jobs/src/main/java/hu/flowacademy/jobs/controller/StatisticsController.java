package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.repository.JobsRepository;
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
    private JobsRepository jobsRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/high-salary")
    public List<Jobs> getJobsWithHighSalary() {
        return jobsRepository.findBySalaryGreaterThan(1000000);
    }

    @GetMapping("/low-salary")
    public List<Jobs> getJobsWithLowSalary() {
        return jobsRepository.findBySalaryLessThan(500000);
    }

}

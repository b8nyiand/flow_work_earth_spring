package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobsRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import hu.flowacademy.jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private JobsService jobsService;

    @GetMapping("/high-salary")
    public List<Jobs> getJobsWithHighSalary() {
        return jobsRepository.findBySalaryGreaterThan(1000000);
    }

    @GetMapping("/low-salary")
    public List<Jobs> getJobsWithLowSalary() {
        return jobsRepository.findBySalaryLessThan(500000);
    }

    @GetMapping("/listUsersByFullName/{fullName}")
    public List<User> listUsersByFullName(@PathVariable String fullName) {
        return userRepository.findByFullName(fullName);
    }
    @GetMapping("findJobByTitle/{title}")
    public List<Jobs>listJobByTitle(@PathVariable String title){
        return jobsRepository.findJobByTitle(title);
    }

    @GetMapping("/findJobBySalary/{salary}")
    public List<Jobs> findJobsWithHigherSalaryThan(@PathVariable int salary) {
        return jobsService.getJobsWithSalaryGreaterThan(salary);
    }
    }








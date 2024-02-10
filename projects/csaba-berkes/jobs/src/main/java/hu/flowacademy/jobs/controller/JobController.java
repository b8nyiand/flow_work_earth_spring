package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobpanel")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/1M")
    private List<Job> findBySalary() {
        return jobService.findBySalary();
    }

    @GetMapping("/500K")
    private List<Job> findByLessSalary() {
        return jobService.findByLessSalary();
    }
    @GetMapping("/spring")
    private List<Job> findByTitle(){
        return jobService.findByTitle();
    }
    @GetMapping("/slarygreatherthen/{salary}")
    private List<Job> findByAnySalaryGreaterThan(@PathVariable int salary) {
        return jobService.findByAnySalaryGreaterThan(salary);
    }
}

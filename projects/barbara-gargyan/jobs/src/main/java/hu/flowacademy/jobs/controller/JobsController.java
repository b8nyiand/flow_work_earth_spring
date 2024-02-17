package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobsController {


    @Autowired
    private JobsService jobsService;

    @PostMapping("/createJob/{userName}")
    @ResponseStatus(HttpStatus.CREATED)
    public Jobs createJob(@PathVariable String userName, @RequestBody Jobs job) {
        return jobsService.createJob(userName, job);
    }

    @PutMapping("/updateJob/{userName}")
    public Jobs updateJob(@PathVariable String userName, @RequestBody Jobs job) {
        return jobsService.updateJob(userName, job);
    }

    @DeleteMapping("/deleteJobById/{id}")
    public void deleteJobById(@PathVariable Long id) {
        jobsService.deleteJob(id);
    }

    @GetMapping("/listJobsByUserName/{userName}")
    public List<Jobs> listJobsByUserName(@PathVariable String userName) {
        return jobsService.getJobsByUserName(userName);
    }

    @GetMapping("/getJobById/{id}")

    public Jobs getJobById(@PathVariable Long id) {
        return jobsService.getJobById(id);
    }

    @GetMapping("/listAllJobs")
    public List<Jobs> listAllJobs() {
        return jobsService.listAllJobs();
    }
}

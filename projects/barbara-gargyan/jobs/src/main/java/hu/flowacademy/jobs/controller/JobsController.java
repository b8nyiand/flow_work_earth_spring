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

    @PostMapping("/create/{userName}")                             // 1. Job létrehozása meglévő Userhez
    @ResponseStatus(HttpStatus.CREATED)
    public Jobs createJob(@PathVariable String userName, @RequestBody Jobs job) {
        return jobsService.createJob(userName, job);
    }

    @PutMapping("/update")                                          // 2. Job módosítása
    public Jobs updateJob(@RequestBody Jobs job) {
        return jobsService.updateJob(job);
    }

    @DeleteMapping("/delete/{id}")                                  // 3. Job törlése
    public void deleteJob(@PathVariable Long id) {
        jobsService.deleteJob(id);
    }

    @GetMapping("/user/{userName}")                                 // 4. userName alapján jobs-ok listázása
    public List<Jobs> getJobsByUserName(@PathVariable String userName) {
        return jobsService.getJobsByUserName(userName);
    }

    @GetMapping("/{id}")                                            // 5. id alapján job lekérdezése
    public Jobs getJobById(@PathVariable Long id) {
        return jobsService.getJobById(id);
    }
}

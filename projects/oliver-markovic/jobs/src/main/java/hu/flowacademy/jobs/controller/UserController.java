package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.UserRepository;
import hu.flowacademy.jobs.service.JobService;
import hu.flowacademy.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/find-by-name/{name}")
    public User findByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/find-all-users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/add-user")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/delete-user/{name}")
    public void deleteUser(@PathVariable String name) {
        userService.deleteUserByName(name);

    }

    @PutMapping("/update-user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/add-job/{username}")
    @ResponseStatus(HttpStatus.CREATED)
    public Job addJob(@PathVariable String username, @RequestBody Job job) {
        User user = userService.getUserByName(username);
        return userService.addUserWithJob(user, job);
    }

    @PutMapping("/update-job/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        Optional<Job> existingJob = jobService.getJobById(id);
        if (existingJob.isEmpty()) {
            throw new RuntimeException("Job not found with id " + id);
        }
        job.setId(id);
        return jobService.updateJob(job);
    }

    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        Optional<Job> existingJob = jobService.getJobById(id);

        if (existingJob.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-users-jobs/{username}")
    public List<Job> getJobsByUserName(@PathVariable String username) {
        return jobService.getUsersJobs(username);
    }

    @GetMapping("/get-jobs-by-id/{id}")
    public Optional<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }
}

package hu.flowacademy.jobs.controller;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.UserRepository;
import hu.flowacademy.jobs.service.JobService;
import hu.flowacademy.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/add-job")
    @ResponseStatus(HttpStatus.CREATED)
    public Job addJob(@PathVariable String username, @RequestBody Job job) {
        User user = userService.getUserByName(username);
        if(user == null) {
            userRepository.save(new User("Roland", "Hianyozta Roland", LocalDate.now()));
            user = userService.getUserByName(username);
        }
        job.setUser(user);
        return jobService.addJob(job);
    }

    @PutMapping("/update-job")
    public Job updateJob(@RequestBody Job job) {
        return jobService.updateJob(job);
    }

    @DeleteMapping("/delete-job-by-id/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
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

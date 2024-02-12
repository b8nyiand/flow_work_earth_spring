package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.model.Job;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void deleteUserByName(String userName) {
        userRepository.deleteByUsername(userName);
    }

    @Transactional
    public Job addUserWithJob(User user, Job initialJob) {
        User savedUser = userRepository.save(user);

        Job job = new Job();
        job.setTitle(initialJob.getTitle());
        job.setSalary(initialJob.getSalary());
        job.setDescription(initialJob.getDescription());
        job.setCreationDate(initialJob.getCreationDate());
        job.setUser(savedUser);

        return jobRepository.save(job);
    }

}

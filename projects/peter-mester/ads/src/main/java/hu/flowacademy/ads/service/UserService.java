package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findByName(String fullName) {
        return userRepository.findByFullName(fullName);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}

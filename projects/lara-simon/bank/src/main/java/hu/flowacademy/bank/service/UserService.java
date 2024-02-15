package hu.flowacademy.bank.service;

import hu.flowacademy.bank.model.User;
import hu.flowacademy.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        User userToDelete = userRepository.findByUserName(userName);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        } else {
            throw new RuntimeException("cannot find user");
        }
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}

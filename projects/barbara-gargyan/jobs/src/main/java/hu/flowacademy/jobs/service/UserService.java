package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {

        return userRepository.save(user);
    }

    public void deleteUser(String userName) {
        List <User> userToDelete = userRepository.findByUserName(userName);
        if (!userToDelete.isEmpty()) {
            userRepository.deleteAll(userToDelete);
        } else {
            throw new RuntimeException("A User nem található");
        }
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> listUsersByUserName(String userName) {   //userName alapján listáz
        return userRepository.findByUserName(userName);
    }

    public List<User> listAllUsers() {                    // minden Usert kilistáz
        return userRepository.findAll();
    }

}

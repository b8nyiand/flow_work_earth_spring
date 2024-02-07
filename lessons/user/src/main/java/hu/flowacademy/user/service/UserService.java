package hu.flowacademy.user.service;

import hu.flowacademy.user.model.User;
import hu.flowacademy.user.repository.UserRepository;
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

    public void deleteUSer(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUsersGreaterThanPoints(int point) {
        return userRepository.findByPointsGreaterThan(point);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

}

package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        if (user.getCreationDate() == null) {
            user.setCreationDate(LocalDate.now());
        }
        return userRepository.save(user);
    }

    public User modifyUser(User user) {
        Optional<User> validUser = userRepository.findById(user.getUserName());
        if(validUser.isPresent()){
            if (user.getCreationDate() == null) {
                user.setCreationDate(LocalDate.now());
            }
            userRepository.save(user);
        }
        return user;
    }

    public void deleteUser(String userName){
        userRepository.deleteById(userName);
    }

    public User userByUserName(String userName){
        Optional<User> userOptional = userRepository.findById(userName);
        return userOptional.orElse(null);
    }

    public List<User> listAllUser(){
        return userRepository.findAll();
    }

}

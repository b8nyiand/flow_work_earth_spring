package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        if (validUser.isPresent()) {
            if (user.getCreationDate() == null) {
                user.setCreationDate(LocalDate.now());
            }
            userRepository.save(user);
        }
        return user;
    }

    //TODO: ha nem létezik a userName, => error message: "User is not exist"
    public void deleteUser(String userName) {
        userRepository.deleteById(userName);
    }
//    public ResponseEntity<String> deleteUser(String userName){
//        boolean existUser = userRepository.existsById(userName);
//
//        if(existUser){
//            userRepository.deleteById(userName);
//            return ResponseEntity.ok("User deleted successfully.");
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User name is not exist");
//        }
//    }

    public User listUserByUserName(String userName) {
        Optional<User> userOptional = userRepository.findById(userName);
        return userOptional.orElse(null);
    }

    public List<User> listAllUser() {
        return userRepository.findAll();
    }

}

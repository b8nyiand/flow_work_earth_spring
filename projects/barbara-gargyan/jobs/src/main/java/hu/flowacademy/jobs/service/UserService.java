package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // 1. user hozzáadása:

    public User addUser(User user) {
        return userRepository.save(user);
    }

    // 2. user módosítása / update:

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // 3. user törlése id alapján:

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // 4. user lekérése teljes név alapján:

    public List<User> getUsersByName(String fullName) {
        return userRepository.findByFullName(fullName);
    }


    // 5. összes user listázása:

    public List<User> allUserList(){
        return userRepository.findAll();
    }


}

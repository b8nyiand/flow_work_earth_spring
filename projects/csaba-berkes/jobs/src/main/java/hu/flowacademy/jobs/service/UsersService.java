package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users addUser(Users users){
        return usersRepository.save(users);
    }
    public Users updateUser(Users users){
        return usersRepository.save(users);
    }

}

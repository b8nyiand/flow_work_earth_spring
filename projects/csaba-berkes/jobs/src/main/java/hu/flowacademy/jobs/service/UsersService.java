package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.modell.Job;
import hu.flowacademy.jobs.modell.Users;
import hu.flowacademy.jobs.repository.JobRepository;
import hu.flowacademy.jobs.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private JobRepository jobRepository;

    public Users addUser(Users users){
        return usersRepository.save(users);
    }
    //FIXME Update user
    public Users updateUser(Users users){
        return usersRepository.save(users);
    }
    // FIXME Delete user
    public void deleteUser(Users username){
        usersRepository.delete(username);
    }
    public List<Users> findByFullname(String fullname){
        return usersRepository.findByFullname(fullname);
    }
    public List<Users> usersList(){
        return usersRepository.findAll();
    }
    public List<Users> findByFullnameLike(){
        return usersRepository.findByFullnameLike("%Molnar%");
    }
    public  List<Users> jobByUsername(String username){
        return usersRepository.findByUsername(username);
    }

}

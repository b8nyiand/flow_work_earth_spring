package hu.flowacademy.jobs.service;

import hu.flowacademy.jobs.model.Jobs;
import hu.flowacademy.jobs.model.User;
import hu.flowacademy.jobs.repository.JobsRepository;
import hu.flowacademy.jobs.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobsService {
    @Autowired
    private JobsRepository jobsRepository;

    @Autowired
    private UserRepository userRepository;
                                                                            // 1. Job létrehozása meglévő Userhez
    public Jobs createJob(String userName, Jobs jobs) {
        List<User> users = userRepository.findByUserName(userName);
        if (!users.isEmpty()) {
            User user = users.get(0);
            jobs.setUser(user);
            return jobsRepository.save(jobs);
        } else {
            throw new RuntimeException("A felhasználó nem található: " + userName);
        }
    }

    public Jobs updateJob(Jobs job) {                               // 2. Job módosítása
        return jobsRepository.save(job);
    }

    public void deleteJob(Long id) {                                // 3. Job törlése
        jobsRepository.deleteById(id);                              // a Job id-ja alapján töröl -> itt ez a PK
    }

    public List<Jobs> getJobsByUserName(String userName) {          // 4. userName alapján jobs-ok listázása
        return jobsRepository.findByUserName(userName);
    }

    public Jobs getJobById(Long id)                                 // 5. id alapján job lekérdezése
    {
        return jobsRepository.findById(id).orElse(null);
    }
}






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
    public Jobs createJob(String userName, Jobs jobs) {             // meglévő username-hez Job létrehozása
        User user = userRepository.findByUserName(userName);        // megkeresem a usrname-et
        if (user != null) {                                         // ha talál
            jobs.setUser(user);                                     // beállítja a job-ot a user-hez
            return jobsRepository.save(jobs);                       // menti, majd visszaadja
        } else {
            throw new RuntimeException("A felhasználó nem található: " + userName); // ha nincs ilyen username -> RuntimeException + message
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

    public Jobs getJobById(Long id) {                               // 5. id alapján job lekérdezése
        return jobsRepository.findById(id).orElse(null);
    }
}






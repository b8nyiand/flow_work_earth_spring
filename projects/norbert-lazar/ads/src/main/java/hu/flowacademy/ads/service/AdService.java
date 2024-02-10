package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.AdRepository;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AdService {
    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    public Ad createAdForUser(String userName, Ad ad) {
        Optional<User> existUser = userRepository.findById(userName);

        if (existUser.isPresent()) {
            User user = existUser.get();
            ad.setUser(user);

            if (ad.getCreationDate() == null) {
                ad.setCreationDate(LocalDate.now());
            }

        }

        return adRepository.save(ad);
    }

    //TODO: ha nincs ilyen id modify-hoz?
    public Ad modifyAd(Long id, Ad ad) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if(optionalAd.isPresent()){

            Ad existAd = optionalAd.get();

            if(existAd.getCreationDate() == null){
                existAd.setCreationDate(LocalDate.now());
            }

            existAd.setTitle(ad.getTitle());
            existAd.setPrice(ad.getPrice());
            existAd.setDescription(ad.getDescription());

            return adRepository.save(existAd);
        }

        return ad;
    }

    //TODO: ha nincs ilyen id delete-hez?
    public void deleteAd(Long id){
        Optional<Ad> adOptional = adRepository.findById(id);

        if(adOptional.isPresent()){
            adRepository.deleteById(id);
        }

    }

    public List<Ad> listAdsByUserName(String userName){
        return adRepository.findByUserUserName(userName);
    }

    public Ad listAdById(Long id){
        Optional<Ad> adOptional = adRepository.findById(id);
        return adOptional.orElse(null);
    }

}

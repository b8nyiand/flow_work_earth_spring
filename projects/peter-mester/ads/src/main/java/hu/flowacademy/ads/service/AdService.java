package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public Ad addAd(Ad ad) {
        return adRepository.save(ad);
    }

    public List<Ad> findByUserName(String userName) {
        return adRepository.findByName(userName);
    }

    public Ad findById(Long id) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            return optionalAd.get();
        }
        throw new RuntimeException("No user found.");
    }
    public Ad updateUser(Ad user) {
        return adRepository.save(user);
    }

    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }

    public List<Ad> findAllAds() {
        return adRepository.findAll();
    }
}

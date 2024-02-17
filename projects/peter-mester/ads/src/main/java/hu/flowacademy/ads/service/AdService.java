package hu.flowacademy.ads.service;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.AdRepository;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private UserRepository userRepository;

    public Ad addAd(Ad ad) {
        return adRepository.save(ad);
    }

    public Ad findById(Long id) {
        Optional<Ad> optionalAd = adRepository.findById(id);
        if (optionalAd.isPresent()) {
            return optionalAd.get();
        }
        throw new RuntimeException("No user found.");
    }
    public Ad updateAd(Ad ad) {
        return adRepository.save(ad);
    }

    public Ad updateAd(String userName, Ad ad) {
        List<User> userList = userRepository.findByUserName(userName);
        if (!userList.isEmpty()) {
            User users1 = userList.get(0);
            ad.setUser(users1);
            return adRepository.save(ad);
        } else {
            throw new RuntimeException("No user found.");
        }
    }

    public void deleteAd(Long id) {
        adRepository.deleteById(id);
    }
    public List<Ad> findAdByUserName(String userName){
        return adRepository.findByUserUserName(userName);
    }

    public List<Ad> findAllAds() {
        return adRepository.findAll();
    }
    public List<Ad> findByPriceGreaterThan4000() {
        return adRepository.findByPriceGreaterThan(4000);
    }
    public List<Ad> findByPriceLessThan3000() {
        return adRepository.findByPriceLessThan(3000);
    }
    public List<Ad> findByTitleLikeBojler() {
        return adRepository.findByTitleLike("%bojler%");
    }
    public List<Ad> findByPriceGreaterThan(Integer price) {
        return adRepository.findByPriceGreaterThan(price);
    }
}

package hu.flowacademy.ads.controller;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.repository.AdRepository;
import hu.flowacademy.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statics")
public class StaticsController {

    @Autowired
    private AdRepository adRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @RequestMapping("/price-greater-than/{price}")
    public List<Ad> priceGreaterThan(@PathVariable Integer price){
        return adRepository.findByPriceGreaterThan(price);
    }

    @GetMapping
    @RequestMapping("/price-less-than/{price}")
    public List<Ad> priceLessThan(@PathVariable Integer price){
        return adRepository.findByPriceLessThan(price);
    }

    /**
     * A teljes nevet meg kell adni.
     * @param fullName
     * @return User List
     */
    @GetMapping
    @RequestMapping("/user-name/{fullName}")
    public List<User> findNameLike(@PathVariable String fullName){
        return userRepository.findByFullNameLike(fullName);
    }

    /**
     * A teljes név egy részlete alapján keres
     * @param name
     * @return User List
     */
    @GetMapping
    @RequestMapping("/user-name-contains/{name}")
    public List<User> findNameContains(@PathVariable String name){
        return userRepository.findByFullNameContaining(name);
    }

    @GetMapping
    @RequestMapping("/ad-title/{title}")
    public List<Ad> findAdByTitle(@PathVariable String title){
        return adRepository.findByTitleLike(title);
    }


}

package hu.flowacademy.ads.controller;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.model.User;
import hu.flowacademy.ads.service.AdService;
import hu.flowacademy.ads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stats")
public class StatsController {
    @Autowired
    UserService userService;
    @Autowired
    AdService adService;

    @GetMapping("/findByPriceGreaterThan4000")
    public List<Ad> findByPriceGreaterThan4000() {
        return adService.findByPriceGreaterThan4000();
    }
    @GetMapping("/findByPriceLessThan3000")
    public List<Ad> findByPriceLessThan3000() {
        return adService.findByPriceLessThan3000();
    }
    @GetMapping("/findByTitleLikeBojler")
    public List<Ad> findByTitleLikeBojler() {
        return adService.findByTitleLikeBojler();
    }
    @GetMapping("/findByFullNameLikeKovacs")
    public List<User> findByFullNameLikeKovacs() {
        return userService.findByFullNameLikeKovacs();
    }
    @GetMapping("/findByPriceGreaterThan/{price}")
    public List<Ad> findByPriceGreaterThan(@PathVariable Integer price) {
        return adService.findByPriceGreaterThan(price);
    }

}

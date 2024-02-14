package hu.flowacademy.ads.controller;

import hu.flowacademy.ads.model.Ad;
import hu.flowacademy.ads.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ad")

public class AdController {
    @Autowired
    AdService adService;

    @PostMapping("/addAd")
    @ResponseStatus(HttpStatus.CREATED)
    public Ad addAd(@RequestBody Ad ad) {
        return adService.addAd(ad);
    }

    @GetMapping("/findById/{id}")
    public Ad findById(@PathVariable Long id) {
        return adService.findById(id);
    }

    @PutMapping("/updateAd")
    public Ad updateUser(@RequestBody Ad ad) {
        return adService.updateAd(ad);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
    }

    @GetMapping("/findAllAds")
    public List<Ad> findAllAds() {
        return adService.findAllAds();
    }
}

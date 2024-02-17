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

    @PostMapping("/addAd/{userName}")
    @ResponseStatus(HttpStatus.CREATED)
    private Ad addAd(@PathVariable String userName, @RequestBody Ad ad) {
        return adService.addAd(userName, ad);
    }

    @GetMapping("/findById/{id}")
    public Ad findById(@PathVariable Long id) {
        return adService.findById(id);
    }

    @PutMapping("/updateAd/{userName}")
    private Ad updateAd(@PathVariable String userName, @RequestBody Ad ad) {
        return adService.updateAd(userName, ad);
    }

    @GetMapping
    @RequestMapping("/findAdByUserName/{userName}")
    public List<Ad> findAdByUserName(@PathVariable String userName){
        return adService.findAdByUserName(userName);
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

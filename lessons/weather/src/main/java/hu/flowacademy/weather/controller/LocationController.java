package hu.flowacademy.weather.controller;

import hu.flowacademy.weather.model.Location;
import hu.flowacademy.weather.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Location addLocation(@RequestBody Location location) {
        return locationService.add(location);
    }

    @DeleteMapping("/remove/{index}")
    public void removeLocation(@PathVariable int index) {
        locationService.remove(index);
    }

    @GetMapping("/list")
    public List<Location> listLocations() {
        return locationService.listAll();
    }

}

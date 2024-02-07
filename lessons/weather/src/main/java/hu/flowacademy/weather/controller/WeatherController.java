package hu.flowacademy.weather.controller;

import hu.flowacademy.weather.model.Location;
import hu.flowacademy.weather.model.Weather;
import hu.flowacademy.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    public WeatherService weatherService;

    @GetMapping("/getWeather")
    public Weather getWeatherByLocation(@RequestBody Location location) {
        return weatherService.getWeather(location);
    }

}

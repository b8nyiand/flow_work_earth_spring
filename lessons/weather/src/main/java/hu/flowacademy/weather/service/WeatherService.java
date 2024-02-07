package hu.flowacademy.weather.service;

import hu.flowacademy.weather.model.Location;
import hu.flowacademy.weather.model.Type;
import hu.flowacademy.weather.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WeatherService {

    @Autowired
    LocationService locationService;

    public Weather getWeather(Location location) {
        if (locationService.listAll().stream().anyMatch(element -> element.getCity().equals(location.getCity()))) {
            Random random = new Random();
            return new Weather(location, random.nextInt(-31, 50), random.nextInt(100), random.nextDouble(200), Type.SUNNY);
        }
        return null;
    }

}

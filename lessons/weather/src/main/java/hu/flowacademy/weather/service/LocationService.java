package hu.flowacademy.weather.service;

import hu.flowacademy.weather.model.Location;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    private List<Location> locationList = new ArrayList<>();

    public Location add(Location location) {
        locationList.add(location);
        return location;
    }

    public void remove(int index) {
        locationList.remove(index);
    }

    public List<Location> listAll() {
        return locationList;
    }

}

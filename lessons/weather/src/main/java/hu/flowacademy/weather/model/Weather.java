package hu.flowacademy.weather.model;

public class Weather {

    private Location location;
    private int temperature;
    private int humidity;
    private double wind;
    private Type type;

    public Weather(Location location, int temperature, int humidity, double wind, Type type) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.wind = wind;
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWind() {
        return wind;
    }

    public void setWind(double wind) {
        this.wind = wind;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", wind=" + wind +
                ", type=" + type +
                '}';
    }
}

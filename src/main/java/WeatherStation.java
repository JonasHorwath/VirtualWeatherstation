public class WeatherStation {

    String name;
    String time;
    private double temperature, humidity, pressure, latitude, longitude;

    public WeatherStation(String name, String time, double temperature, double humidity, double pressure, double latitude, double longitude) {
        this.name = name;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getTemperatureInCelsius() {
        return temperature;
    }

    public double getTemperatureInFahrenheit() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}

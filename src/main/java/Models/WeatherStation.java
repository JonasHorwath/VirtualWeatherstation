package Models;

import java.util.List;

public class WeatherStation {

    private Location location;
    private List<WeatherStationEntry> weatherStationEntries;

    public WeatherStation(Location location, List<WeatherStationEntry> weatherStationEntries) {
        this.location = location;
        this.weatherStationEntries = weatherStationEntries;
    }

    public List<WeatherStationEntry> getWeatherStationEntries() {
        return weatherStationEntries;
    }

    public void addEntry () {

    }

}

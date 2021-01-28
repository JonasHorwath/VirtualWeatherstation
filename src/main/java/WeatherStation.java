import java.util.List;

public class WeatherStation {

    private String weatherStationName;
    private List<WeatherStationEntry> weatherStationEntries;

    public WeatherStation(String weatherStationName) {
        this.weatherStationName = weatherStationName;
    }

    public WeatherStation(String weatherStationName, List<WeatherStationEntry> weatherStationEntries) {
        this.weatherStationName = weatherStationName;
        this.weatherStationEntries = weatherStationEntries;
    }

    public List<WeatherStationEntry> getWeatherStationEntries() {
        return weatherStationEntries;
    }

    public void addEntry () {

    }

}

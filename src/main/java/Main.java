import java.io.IOException;
import java.util.List;

/**
 *
 * @author Jonas Horwath
 * @version 1.0
 * @see FileCreator
 * @see FileDao
 * @see Parser
 * @see WeatherStationEntry
 *
 */

public class Main {

    public static void main(String[] args) throws IOException {

        // Working
        List<String> weatherData;
        List<WeatherStationEntry> weatherStationEntries;
        FileDao fileDao = new FileDao("src/main/Data/WeatherData.txt");
        fileDao.readData();
        weatherData = Parser.filter(fileDao.getData());
        FileCreator.writeToTextFile(Parser.filter(fileDao.getData()), "WeatherDataFiltered");
        weatherStationEntries = Parser.parseToWeatherStationList(weatherData);

        for (WeatherStationEntry s:
             weatherStationEntries) {
            System.out.println(s.toString());
        }

    }

}
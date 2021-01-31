import org.json.simple.parser.ParseException;

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

    public static void main(String[] args) throws IOException, InterruptedException, ParseException {

        // Working
        AprsClient aprsClient = new AprsClient();
        List<String> weatherData;
        List<WeatherStationEntry> weatherStationEntries;
        FileDao fileDao = new FileDao("src/main/Data/WeatherData.txt");
        fileDao.readData();
        weatherData = Parser.filter(fileDao.getData());
        FileCreator.writeToTextFile(Parser.filter(fileDao.getData()), "WeatherDataFiltered");
        weatherStationEntries = Parser.parseToWeatherStationEntryList(weatherData);

        WeatherStationEntry entry;

        for (WeatherStationEntry s:
             weatherStationEntries) {
            System.out.println(s.toString());
        }

        System.out.println(Double.parseDouble("-290.30"));


        Thread thread = new Thread(aprsClient);
        aprsClient.connect();
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
        weatherStationEntries = Parser.parseToWeatherStationEntryList(aprsClient.getData());

        for (WeatherStationEntry s :
                weatherStationEntries) {

            GeocodeApi.getLocation(s.getLatitude(), s.getLongitude());

        }

    }

}
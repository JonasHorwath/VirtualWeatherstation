package Backend;

import Connections.AprsClient;
import Connections.GeocodeApi;
import Filehandler.FileCreator;
import Filehandler.FileDao;
import Models.WeatherStationEntry;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Jonas Horwath
 * @version 1.0
 * @see FileCreator
 * @see FileDao
 * @see DataParser
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
        weatherData = DataParser.filter(fileDao.getData());
        FileCreator.writeToTextFile(DataParser.filter(fileDao.getData()), "WeatherDataFiltered");
        weatherStationEntries = DataParser.parseToWeatherStationEntryList(weatherData);

        WeatherStationEntry entry;

        for (WeatherStationEntry s:
             weatherStationEntries) {
            System.out.println(s.toString());
        }


        Thread thread = new Thread(aprsClient);
        aprsClient.connect();
        thread.start();
        Thread.sleep(10000);
        thread.interrupt();
        weatherStationEntries = DataParser.parseToWeatherStationEntryList(aprsClient.getData());

        for (WeatherStationEntry s :
                weatherStationEntries) {

            System.out.println(s.toString());
            GeocodeApi.getLocation(s.getLatitude(), s.getLongitude());

        }

    }

}
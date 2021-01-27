import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        // Working
        List<String> weatherData;
        List<WeatherStation> weatherStations;
        FileDao fileDao = new FileDao("src/main/Data/WeatherData.txt");
        fileDao.readData();
        weatherData = Parser.filter(fileDao.getData());
        FileCreator.writeToTextFile(Parser.filter(fileDao.getData()), "WeatherDataFiltered");
        weatherStations = Parser.parseToWeatherStationList(weatherData);

        System.out.println(weatherStations);

    }

}
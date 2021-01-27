import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Pattern temperaturePattern = Pattern.compile("t([0-9]+)r");
    private static Matcher matcher;

    public static List<String> filter(ArrayList<String> data) {

        data.removeIf(s -> !useRegex(s));
        return data;

    }

    public static List<WeatherStation> parseToWeatherStationList(List<String> list) {

        for (String entry :
                list) {
            matcher = temperaturePattern.matcher(entry);
            if (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }

        return null;

    }

    private static boolean useRegex(String input) {

        // Compile regular expression
        Pattern pattern = Pattern.compile("^.*:\\u0040.*N/.*W_.*t.*$");
        // Match regex against input
        Matcher matcher = pattern.matcher(input);
        // Use results...
        return matcher.find();

    }

}

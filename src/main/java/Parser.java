import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Pattern[] patterns = {
            Pattern.compile(":@([0-9]+)z"),
            Pattern.compile("E|W_([0-9]+)/"),
            Pattern.compile("/([0-9]+)g"),
            Pattern.compile("g([0-9]+)t"),
            Pattern.compile("t([0-9]+)r"),
            Pattern.compile("h([0-9]+)b"),
            Pattern.compile("b([0-9]+)"),
            Pattern.compile("[N|S]/([0-9]+.[0-9]+[E|W])_"),
            Pattern.compile("z([0-9]+.[0-9]+N|S)/"),
            Pattern.compile("r([0-9]+)p"),
            Pattern.compile("p([0-9]+)P"),
            Pattern.compile("P([0-9]+)h")};

    private static Pattern timePattern = Pattern.compile(":@([0-9]+)z");
    private static Pattern windDirectionPattern = Pattern.compile("[E|W]_([0-9]+)/");
    private static Pattern windSpeedAvgPattern = Pattern.compile("/([0-9]+)g");
    private static Pattern windSpeedMaxPattern = Pattern.compile("g([0-9]+)t");
    private static Pattern temperaturePattern = Pattern.compile("t([0-9]+)r");
    private static Pattern humidityInPercentPattern = Pattern.compile("h([0-9]+)b");
    private static Pattern pressureInTenthsOfMillibarsPattern = Pattern.compile("b([0-9]+)");
    private static Pattern latitudePattern = Pattern.compile("[N|S]/([0-9]+.[0-9]+[E|W])_");
    private static Pattern longitudePattern = Pattern.compile("z([0-9]+.[0-9]+[N|S])/");
    private static Pattern rainInHundredthsOfAnInchOneHourPattern = Pattern.compile("r([0-9]+)p");
    private static Pattern rainInHundredthsOfAnInchOneDayPattern = Pattern.compile("p([0-9]+)P");
    private static Pattern rainInHundredthsOfAnInchSinceMidnightPattern = Pattern.compile("P([0-9]+)h");
    private static Matcher matcher;

    public static List<String> filter(ArrayList<String> data) {
        data.removeIf(s -> !useRegex(s));
        return data;
    }

    public static List<WeatherStationEntry> parseToWeatherStationEntryList(List<String> list) {

        List<WeatherStationEntry> weatherStationEntry = new ArrayList<>();
        String []results = new String[12];

        for (String entry :
                list) {

            for (int i = 0; i < patterns.length; i++) {

                results[i] = useRegex(entry, patterns[i]);

            }

            weatherStationEntry.add(new WeatherStationEntry(results));

            /*System.out.println(entry);
            matcher = timePattern.matcher(entry);
            matcher.find();
            System.out.print("Time: " + matcher.group(1));
            matcher = longitudePattern.matcher(entry);
            matcher.find();
            System.out.print(" Longitude: " + matcher.group(1));
            matcher = latitudePattern.matcher(entry);
            matcher.find();
            System.out.print(" Latitude: " + matcher.group(1));
            matcher = windDirectionPattern.matcher(entry);
            matcher.find();
            System.out.print(" WindDirection: " + matcher.group(1));
            matcher = windSpeedAvgPattern.matcher(entry);
            matcher.find();
            System.out.print(" WindSpeedAvg: " + matcher.group(1));
            matcher = windSpeedMaxPattern.matcher(entry);
            matcher.find();
            System.out.print(" WindSpeedMax: " + matcher.group(1));
            matcher = temperaturePattern.matcher(entry);
            matcher.find();
            System.out.print(" Temperature: " + matcher.group(1));
            matcher = rainInHundredthsOfAnInchOneHourPattern.matcher(entry);
            matcher.find();
            System.out.print(" RainInHundredthsOfAnInchOneHour: " + matcher.group(1));
            matcher = rainInHundredthsOfAnInchOneDayPattern.matcher(entry);
            matcher.find();
            System.out.print(" RainInHundredthsOfAnInchOneDay: " + matcher.group(1));
            matcher = rainInHundredthsOfAnInchSinceMidnightPattern.matcher(entry);
            matcher.find();
            System.out.print(" RainInHundredthsOfAnInchSinceMidnight: " + matcher.group(1));
            matcher = humidityInPercentPattern.matcher(entry);
            matcher.find();
            System.out.print(" HumidityInPercent: " + matcher.group(1));
            matcher = pressureInTenthsOfMillibarsPattern.matcher(entry);
            matcher.find();
            System.out.println(" PressureInTenthsOfMillibars: " + matcher.group(1));*/

        }

        return weatherStationEntry;

    }

    public static String useRegex (String input, Pattern regex) {

        Matcher matcher = regex.matcher(input);

        if (matcher.find()) {
            return matcher.group(1);
        }

        return null;

    }

    public static boolean useRegex(String input) {

        // Compile regular expression
        Pattern pattern = Pattern.compile(".*:@[0-9]+zE|W_[0-9]+/[0-9]+g[0-9]+t.*");
        // Match regex against input
        Matcher matcher = pattern.matcher(input);
        // Use results...
        return matcher.find();

    }

}

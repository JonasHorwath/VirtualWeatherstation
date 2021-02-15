package Connections;

import Backend.Constants;
import Models.Location;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeocodeApi {

    public static Location getLocation(String latitude, String longitude) throws IOException, InterruptedException, ParseException {

        if (latitude != null && longitude != null) {
            Double latitudeInDecimal = convertToDecimal(latitude);
            Double longitudeInDecimal = convertToDecimal(longitude);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://trueway-geocoding.p.rapidapi.com/ReverseGeocode?location=" +
                            latitudeInDecimal + "%2C" +
                            longitudeInDecimal + "&language=en"))
                    .header("x-rapidapi-key", Constants.API_KEY)
                    .header("x-rapidapi-host", "trueway-geocoding.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.body());

            System.out.println(jsonObject.toJSONString());

        }

        return null;

    }

    private static Double convertToDecimal(String coordinate) {

        double convertedCoordinate = 0.0;

        if (coordinate.charAt(coordinate.length() - 1) == 'N') {
            convertedCoordinate += Double.parseDouble(coordinate.substring(0, 1));
            convertedCoordinate += (Double.parseDouble(coordinate.substring(2, 6)) / 60);
            return convertedCoordinate;
        } else if (coordinate.charAt(coordinate.length() - 1) == 'W') {
            convertedCoordinate -= Double.parseDouble(coordinate.substring(0, 2));
            convertedCoordinate -= (Double.parseDouble(coordinate.substring(3, 7)) / 60);
            return convertedCoordinate;
        }

        return null;

    }

}

public class WeatherStationEntry {

    private String time;
    private Double windDirection;
    private Double windSpeedAvg;
    private Double windSpeedMax;
    private Double temperatureInFahrenheit;
    private Double humidityInPercent;
    private Double pressureInTenthsOfMillibars;
    private Double latitude;
    private char latitudeNorthSouth;
    private Double longitude;
    private char longitudeEastWest;
    private Double rainInHundredthsOfAnInchOneHour;
    private Double rainInHundredthsOfAnInchOneDay;
    private Double rainInHundredthsOfAnInchSinceMidnight;

    public WeatherStationEntry(String []inputs) {

        this.time = inputs[0];
        this.windDirection = inputs[1] == null ? null: Double.parseDouble(inputs[1]);
        this.windSpeedAvg = inputs[2] == null ? null: Double.parseDouble(inputs[2]);
        this.windSpeedMax = inputs[3] == null ? null: Double.parseDouble(inputs[3]);
        this.temperatureInFahrenheit = inputs[4] == null ? null: Double.parseDouble(inputs[4]);
        this.humidityInPercent = inputs[5] == null ? null: Double.parseDouble(inputs[5]);
        this.pressureInTenthsOfMillibars = inputs[6] == null ? null: Double.parseDouble(inputs[6]);
        this.latitude = inputs[7] == null ? null: Double.parseDouble(inputs[7].substring(0, inputs[7].length()-2));
        this.latitudeNorthSouth = inputs[7].charAt(inputs[7].length() - 1);
        this.longitude = inputs[8] == null ? null: Double.parseDouble(inputs[8].substring(0, inputs[8].length()-2));
        this.longitudeEastWest = inputs[8].charAt(inputs[8].length() - 1);
        this.rainInHundredthsOfAnInchOneHour = inputs[9] == null ? null: Double.parseDouble(inputs[9]);
        this.rainInHundredthsOfAnInchOneDay = inputs[10] == null ? null: Double.parseDouble(inputs[10]);
        this.rainInHundredthsOfAnInchSinceMidnight = inputs[11] == null ? null: Double.parseDouble(inputs[11]);

    }

    public WeatherStationEntry(String time,
                               Double windDirection,
                               Double windSpeedAvg,
                               Double windSpeedMax,
                               Double temperatureInFahrenheit,
                               Double humidityInPercent,
                               Double pressureInTenthsOfMillibars,
                               Double latitude,
                               Double longitude,
                               Double rainInHundredthsOfAnInchOneHour,
                               Double rainInHundredthsOfAnInchOneDay,
                               Double rainInHundredthsOfAnInchSinceMidnight) {

        this.time = time;
        this.windDirection = windDirection;
        this.windSpeedAvg = windSpeedAvg;
        this.windSpeedMax = windSpeedMax;
        this.temperatureInFahrenheit = temperatureInFahrenheit;
        this.humidityInPercent = humidityInPercent;
        this.pressureInTenthsOfMillibars = pressureInTenthsOfMillibars;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rainInHundredthsOfAnInchOneHour = rainInHundredthsOfAnInchOneHour;
        this.rainInHundredthsOfAnInchOneDay = rainInHundredthsOfAnInchOneDay;
        this.rainInHundredthsOfAnInchSinceMidnight = rainInHundredthsOfAnInchSinceMidnight;

    }

    public Double getTemperatureInCelsius() {
        return (temperatureInFahrenheit - 32) / 1.8;
    }

    public Double getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }

    public Double getHumidityInPercent() {
        return humidityInPercent;
    }

    public Double getPressureInTenthsOfMillibars() {
        return pressureInTenthsOfMillibars;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getTime() {
        return time;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public Double getWindSpeedAvg() {
        return windSpeedAvg;
    }

    public Double getWindSpeedMax() {
        return windSpeedMax;
    }

    public Double getRainInHundredthsOfAnInchOneHour() {
        return rainInHundredthsOfAnInchOneHour;
    }

    public Double getRainInHundredthsOfAnInchOneDay() {
        return rainInHundredthsOfAnInchOneDay;
    }

    public Double getRainInHundredthsOfAnInchSinceMidnight() {
        return rainInHundredthsOfAnInchSinceMidnight;
    }

    @Override
    public String toString() {
        return "WeatherStationEntry{" +
                "time='" + time + '\'' +
                ", windDirection=" + windDirection +
                ", windSpeedAvg=" + windSpeedAvg +
                ", windSpeedMax=" + windSpeedMax +
                ", temperatureInFahrenheit=" + temperatureInFahrenheit +
                ", humidityInPercent=" + humidityInPercent +
                ", pressureInTenthsOfMillibars=" + pressureInTenthsOfMillibars +
                ", latitude=" + latitude +
                ", latitudeNorthSouth=" + latitudeNorthSouth +
                ", longitude=" + longitude +
                ", longitudeEastWest=" + longitudeEastWest +
                ", rainInHundredthsOfAnInchOneHour=" + rainInHundredthsOfAnInchOneHour +
                ", rainInHundredthsOfAnInchOneDay=" + rainInHundredthsOfAnInchOneDay +
                ", rainInHundredthsOfAnInchSinceMidnight=" + rainInHundredthsOfAnInchSinceMidnight +
                '}';
    }
}

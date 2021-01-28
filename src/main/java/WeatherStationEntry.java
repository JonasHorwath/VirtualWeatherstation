public class WeatherStationEntry {

    private String time;
    private double windDirection;
    private double windSpeedAvg;
    private double windSpeedMax;
    private double temperatureInFahrenheit;
    private double humidityInPercent;
    private double pressureInTenthsOfMillibars;
    private double latitude;
    private double longitude;
    private double rainInHundredthsOfAnInchOneHour;
    private double rainInHundredthsOfAnInchOneDay;
    private double rainInHundredthsOfAnInchSinceMidnight;

    public WeatherStationEntry(String time, double windDirection, double windSpeedAvg, double windSpeedMax, double temperatureInFahrenheit, double humidityInPercent, double pressureInTenthsOfMillibars, double latitude, double longitude, double rainInHundredthsOfAnInchOneHour, double rainInHundredthsOfAnInchOneDay, double rainInHundredthsOfAnInchSinceMidnight) {

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

    public double getTemperatureInCelsius() {
        return (temperatureInFahrenheit - 32) / 1.8;
    }

    public double getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }

    public double getHumidityInPercent() {
        return humidityInPercent;
    }

    public double getPressureInTenthsOfMillibars() {
        return pressureInTenthsOfMillibars;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getTime() {
        return time;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public double getWindSpeedAvg() {
        return windSpeedAvg;
    }

    public double getWindSpeedMax() {
        return windSpeedMax;
    }

    public double getRainInHundredthsOfAnInchOneHour() {
        return rainInHundredthsOfAnInchOneHour;
    }

    public double getRainInHundredthsOfAnInchOneDay() {
        return rainInHundredthsOfAnInchOneDay;
    }

    public double getRainInHundredthsOfAnInchSinceMidnight() {
        return rainInHundredthsOfAnInchSinceMidnight;
    }

}

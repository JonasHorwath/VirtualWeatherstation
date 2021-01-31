import java.io.IOException;

public class Location {

    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String postalCode;
    private String address;

    public Location(String latitude, String longitude, String country, String city, String postalCode, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

}

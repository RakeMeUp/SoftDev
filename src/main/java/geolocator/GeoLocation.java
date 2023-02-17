package geolocator;

@lombok.Data
public class GeoLocation {

    private String ip;
    private String countryCode;
    private String countryName;
    private String regionCode;
    private String regionName;
    private String city;
    private String zipCode;
    private String timeZone;
    private double latitude;
    private double longitude;
    private Integer metroCode;
}

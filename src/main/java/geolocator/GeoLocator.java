package geolocator;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;

import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

public interface GeoLocator {

    @RequestLine("GET")
    GeoLocation getGeoLocation();

    @RequestLine("GET /{ipOrHostName}")
    GeoLocation getGeoLocation(@Param("ipOrHostName") String ipOrHostName);

    static GeoLocator newInstance() {
        return Feign.builder()
            .decoder(new GsonDecoder(new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()))
            .target(GeoLocator.class, "https://reallyfreegeoip.org/json/");
    }

}

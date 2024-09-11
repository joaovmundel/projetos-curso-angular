package io.github.joaovmundel.devapimock.GeoIP;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
    private String country;
    private String region;
    private String city;
    private Double lat;
    private Double lng;
    private String postalCode;
    private String timezone;
    private long geonameId;
}

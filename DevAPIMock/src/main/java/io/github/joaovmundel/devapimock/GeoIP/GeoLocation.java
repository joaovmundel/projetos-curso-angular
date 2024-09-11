package io.github.joaovmundel.devapimock.GeoIP;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation {
    private String ip;
    private Location location;
}

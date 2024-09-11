package io.github.joaovmundel.devapimock;

import io.github.joaovmundel.devapimock.GeoIP.GeoLocation;
import io.github.joaovmundel.devapimock.GeoIP.IP;
import io.github.joaovmundel.devapimock.GeoIP.Location;
import io.github.joaovmundel.devapimock.Weather.Main;
import io.github.joaovmundel.devapimock.Weather.Weather;
import io.github.joaovmundel.devapimock.Weather.WeatherData;
import io.github.joaovmundel.devapimock.Weather.Wind;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/ip")
    public IP getIp(){
        return new IP("189.15.43.147");
    }

    @GetMapping(path = "/geolocation", params = {"apiKey", "ipAddress"})
    public GeoLocation getGeoLocation(@RequestParam String ipAddress){
        Location location = Location.builder().country("BR").region("São Paulo").city("Franca").lat(-20.53861).lng(-47.40083).postalCode("").timezone("-03:00").geonameId(3463011L).build();
        return new GeoLocation(ipAddress, location);
    }

    @GetMapping(path = "/weather", params = {"q", "units", "mode", "appid"})
    public WeatherData getWeatherData(@RequestParam String q){
        Weather weather = new Weather(800, "Clear", "clear sky", "01d");
        Main main = Main.builder().temp(306.29).feels_like(303.96).temp_min(306.29).temp_max(306.29).pressure(1015).humidity(15).sea_level(1015).grnd_level(915).build();
        Wind wind = new Wind(0.61, 41, 1.1);

        return new WeatherData(List.of(weather), "stations", main, 10000, wind, q);
    }

    @GetMapping(path = "/weather/search", params = {"q", "units", "mode", "appid"})
    public WeatherData getWeatherDataSearch(@RequestParam String q){
        WeatherData weatherData = new WeatherData();
        weatherData.generateRandom();
        weatherData.setName(q);
        return weatherData;
    }



}

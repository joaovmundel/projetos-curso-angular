package io.github.joaovmundel.devapimock.Weather;

import io.github.joaovmundel.devapimock.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {
    private List<Weather> weather;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private String name;

    public void generateRandom(){
        Weather weather = new Weather();
        weather.generateRandom();

        this.weather = List.of(weather);

        this.base = "stations";

        Main main = new Main();
        main.generateRandom(weather);

        this.main = main;

        this.visibility = Utils.generateRandomInt(500, 1000);

        Wind wind = new Wind();
        wind.generateRandom();
        this.wind = wind;
        if (weather.getMain().equalsIgnoreCase("Snowy") && main.getTemp() > 0) {
            main.setTemp(Utils.round((main.getTemp()-5) * (-1), 1));
            main.setTemp_min(Utils.round((main.getTemp() - Utils.generateRandomInt(10, 15)) + Math.random(), 1));
        }
    }
}

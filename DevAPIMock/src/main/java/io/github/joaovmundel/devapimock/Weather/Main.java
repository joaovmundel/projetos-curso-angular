package io.github.joaovmundel.devapimock.Weather;

import io.github.joaovmundel.devapimock.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Main {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Integer pressure;
    private Integer humidity;
    private Integer sea_level;
    private Integer grnd_level;

    public void generateRandom(Weather weather) {
        if(weather.getMain().equalsIgnoreCase("snowy")){
            this.temp = Utils.round(Utils.generateRandomInt(-26, 4) + Math.random(), 1);
            this.feels_like = Utils.round((temp + Utils.generateRandomInt(-2, 2)) + Math.random(), 1);
            this.temp_min = Utils.round((temp - Utils.generateRandomInt(1, 9)) + Math.random(), 1);
            this.temp_max = Utils.round((temp + Utils.generateRandomInt(2, 15)) + Math.random(), 1);
        }else{
            this.temp = Utils.round(Utils.generateRandomInt(0, 35) + Math.random(), 1);
            this.feels_like = Utils.round((temp + Utils.generateRandomInt(-2, 2)) + Math.random(), 1);
            this.temp_min = Utils.round((temp - Utils.generateRandomInt(10, 15)) + Math.random(), 1);
            this.temp_max = Utils.round((temp + Utils.generateRandomInt(0, 2)) + Math.random(), 1);
        }
        this.pressure = Utils.generateRandomInt(1015, 1200);
        this.humidity = Utils.generateRandomInt(5, 99);
        this.sea_level = Utils.generateRandomInt(-270, 5100);
        this.grnd_level = 1;

    }

}

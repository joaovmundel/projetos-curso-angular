package io.github.joaovmundel.devapimock.Weather;

import io.github.joaovmundel.devapimock.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wind {
    private Double speed;
    private Integer deg;
    private Double gust;

    public void generateRandom(){
        this.speed = Utils.round(Utils.generateRandomInt(0, 60) + Math.random(), 1);
        this.deg = Utils.generateRandomInt(0, 6) + 1;
        this.gust = Utils.round(Math.random(), 1)  ;
    }
}

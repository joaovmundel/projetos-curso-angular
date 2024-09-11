package io.github.joaovmundel.devapimock.Weather;

import io.github.joaovmundel.devapimock.util.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather {
    private Integer id;
    private String main;
    private String description;
    private String icon;

    public void generateRandom(){
        this.id = Utils.generateRandomInt(1, 900);
        List<String> climate = List.of("Cloudy;Good Day To Read a Book;d01", "Rainy;Nice Day to Drink some warm drinks;d02", "Snowy;Lets make a snowman?;d03", "Thunder;It's raining tacos!;d04", "Sunny;Beautiful day to get a beach;d05");
        int mainAndDesc = Utils.generateRandomInt(0, climate.size()-1);
        String selectedClimate = climate.get(mainAndDesc);
        this.main = selectedClimate.split(";")[0];
        this.description = selectedClimate.split(";")[1];
        this.icon = selectedClimate.split(";")[2];
    }
}

package io.github.joaovmundel.devapimock.util;

import io.github.joaovmundel.devapimock.Weather.Weather;
import io.github.joaovmundel.devapimock.Weather.WeatherData;

import java.util.Random;

public class Utils {

    public static WeatherData generateRandomWeather() {
        WeatherData weatherData = new WeatherData();
        Weather weather = new Weather();

        return null;
    }

    public static int generateRandomInt(int start, int end) {
        Random random = new Random();
        return random.nextInt((end - start) + 1) + start; // see explanation below
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}

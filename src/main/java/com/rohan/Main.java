package com.rohan;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Weather api = new Weather();
        String forecast = api.getForecast("Sarnia");

        WeatherBasedParser parser = new WeatherBasedParser();
        parser.parseAndPrint(forecast);
    }
}
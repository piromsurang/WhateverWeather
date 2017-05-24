package com.example.piromsurang.whateverweather.data;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public class Weather {

    private String cityName;
    private int temperature;
    private String description = "";
    private String details = "";

    public Weather(String name) {
        cityName = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String d) {
        details = d;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temp) {
        temperature = temp;
    }

    public void setDescription(String desc) {
        description = desc;
    }

    public String toString() {
        return String.format("%s\ntemperature: %d\n\t%s", cityName, temperature, description);
    }
}

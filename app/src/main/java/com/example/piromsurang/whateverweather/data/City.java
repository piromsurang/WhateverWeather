package com.example.piromsurang.whateverweather.data;

/**
 * Created by Piromsurang on 5/11/2017 AD.
 */

public class City {
    private String cityName;
    private String cityCountry;
    private float longtitude;
    private float latitude;

    public City(String cityName, String cityCountry, float longtitude, float latitude) {
        this.cityName = cityName;
        this.cityCountry = cityCountry;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityCountry() {
        return cityCountry;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String toString() {
        return String.format("Country: %s City: %s Longtitude: %.3f Latitude: %.3f", cityCountry, cityName, longtitude, latitude);
    }
}

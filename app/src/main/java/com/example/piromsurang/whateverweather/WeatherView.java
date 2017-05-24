package com.example.piromsurang.whateverweather;

import android.content.Context;

import com.example.piromsurang.whateverweather.data.City;

import java.util.ArrayList;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public interface WeatherView {

    void displayList(ArrayList<City> list);
    void createDialog(int b);
    Context getContext();

}

package com.example.piromsurang.whateverweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

import com.example.piromsurang.whateverweather.data.CRVReader;
import com.example.piromsurang.whateverweather.data.CityRepository;

public class MainActivity extends AppCompatActivity implements WeatherView {

    public static String WEATHER_API_KEY = "f9a98548b05522ebc556cd91b297b253";
    private CityRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = CityRepository.getInstance();
        loadDatabase();
    }

    @Override
    public void displayList() {

    }

    public void loadDatabase() {
        CRVReader crvReader = new CRVReader(this);
        crvReader.execute();
    }
}

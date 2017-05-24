package com.example.piromsurang.whateverweather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.CityRepository;
import com.example.piromsurang.whateverweather.data.Weather;

import java.util.ArrayList;

public class CityDetailActivity extends AppCompatActivity {

    private CityRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        repository = CityRepository.getInstance();
        getDetail();

    }

    public void getDetail() {
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.CITYNAME_CODE);
        City city = repository.getCityByCityName(name);
        showDetail(city);
    }

    public void showDetail(City c) {
        TextView cityName = (TextView) findViewById(R.id.city_name);
        ImageView imageView = (ImageView) findViewById(R.id.city_icon);
        TextView cityDetail = (TextView) findViewById(R.id.city_detail);
        TextView cityTemperature = (TextView) findViewById(R.id.city_temperature);

        cityName.setText(c.getCityName() + ", " + c.getCityCountry());
        imageView.setImageBitmap(c.getWeather().getIcon());
        cityDetail.setText(c.getWeather().getDescription() + "\n" + c.getWeather().getDetails());
        cityTemperature.setText(c.getWeather().getTemperature() + " ํC");
    }

    public void back(View view) {
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();

        super.onBackPressed();
    }
}

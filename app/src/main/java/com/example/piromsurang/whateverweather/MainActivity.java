package com.example.piromsurang.whateverweather;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.piromsurang.whateverweather.adapter.CustomArrayAdapter;
import com.example.piromsurang.whateverweather.data.CRVReader;
import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.CityRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements WeatherView {

    public static int REQUEST_CODE = 11111;
    private CityRepository repository;
    private WeatherPresenter presenter;
    private ListView listView;
    private CustomArrayAdapter adapter;

    public static String CITYNAME_CODE = "city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository = CityRepository.getInstance();
        presenter = new WeatherPresenter(repository, this);
        repository.addObserver(presenter);
        repository.setContext(this);
        presenter.updateWeather();
        initializeListView();
        loadDatabase();
    }

    public void initializeListView() {
        adapter = new CustomArrayAdapter(presenter, repository.getFavorites(), this);
        listView = (ListView) findViewById(R.id.favorite_listview_main);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City c = adapter.getItem(position);
                startCityDetailActivity(c);
            }

        });
    }

    public void startCityDetailActivity(City c) {
        Intent intent = new Intent(this, CityDetailActivity.class);
        intent.putExtra(CITYNAME_CODE, c.getCityName());
        startActivity(intent);
    }

    public Context getContext() {
        return this.getContext();
    }

    @Override
    public void displayList(ArrayList<City> list) {
        CustomArrayAdapter adapter = new CustomArrayAdapter(presenter, list, this);
        listView.setAdapter(adapter);
    }

    @Override
    public void createDialog(int b) {
    }

    public void loadDatabase() {
        CRVReader crvReader = new CRVReader(this);
        crvReader.addObserver(presenter);
        crvReader.start();
    }

    public void requestAdding(View view) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                presenter.displayList(repository.getFavorites());
            }
        }
    }
}

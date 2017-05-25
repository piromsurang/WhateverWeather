package com.example.piromsurang.whateverweather;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.piromsurang.whateverweather.adapter.CustomArrayAdapter;
import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.CityRepository;

import java.util.ArrayList;

import static com.example.piromsurang.whateverweather.MainActivity.CITYNAME_CODE;

public class AddActivity extends AppCompatActivity implements WeatherView {

    private WeatherPresenter presenter;
    private CityRepository repository;
    private ListView listView;
    private CustomArrayAdapter adapter;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        repository = CityRepository.getInstance();
        presenter = new WeatherPresenter(repository, this);
        initializeListview();
        initializeEditText();
    }

    public void initializeListview() {
        listView = (ListView) findViewById(R.id.search_listview_add);
        adapter = new CustomArrayAdapter(presenter, repository.getCityList(), this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                City c = adapter.getItem(position);
                presenter.addToFavorite(c);
                presenter.createDialog(0);
            }

        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                startCityDetailAcitity(repository.getCityList().get(position));
                return true;
            }
        });
    }

    public void startCityDetailAcitity(City c) {
        Intent intent = new Intent(this, CityDetailActivity.class);
        intent.putExtra(CITYNAME_CODE, c.getCityName());
        startActivity(intent);
    }

    public void initializeEditText() {
        EditText editText = (EditText) findViewById(R.id.search_edittext_add);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.searchByCityName(s.toString());
            }
        });
    }

    @Override
    public void displayList(ArrayList<City> list) {
        adapter = new CustomArrayAdapter(presenter, list, this);
        listView.setAdapter(adapter);
    }

    @Override
    public void createDialog(int b) {
        if(b == 0) {
            toast = Toast.makeText(this, "ADDED", Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @Override
    public Context getContext() {
        return this.getContext();
    }

    public void back(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        super.onBackPressed();
    }
}

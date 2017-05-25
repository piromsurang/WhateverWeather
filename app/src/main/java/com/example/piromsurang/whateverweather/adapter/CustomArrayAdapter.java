package com.example.piromsurang.whateverweather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.piromsurang.whateverweather.R;
import com.example.piromsurang.whateverweather.WeatherPresenter;
import com.example.piromsurang.whateverweather.data.City;
import com.example.piromsurang.whateverweather.data.Weather;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Piromsurang on 5/12/2017 AD.
 */

public class CustomArrayAdapter extends BaseAdapter implements ListAdapter {

    ArrayList<City> list = new ArrayList<>();
    WeatherPresenter presenter;
    Context context;

    public CustomArrayAdapter(WeatherPresenter presenter, ArrayList<City> cities, Context context) {
        this.presenter = presenter;
        this.context = context;
        list = cities;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public City getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_searching_layout, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.textview_add);
        listItemText.setText(list.get(position).getCityName() + ", " + list.get(position).getCityCountry());


        return view;
    }
}

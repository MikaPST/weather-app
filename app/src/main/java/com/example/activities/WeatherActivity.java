package com.example.activities;

import android.content.Context;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.models.City;
import com.example.models.Location;
import com.example.models.Weather;
import com.example.servicemto.R;
import com.example.services.CityService;
import com.example.services.LocationService;
import com.example.services.LocationServiceListener;
import com.example.services.WeatherService;
import com.example.services.WeatherServiceListener;

public class WeatherActivity extends AppCompatActivity implements WeatherServiceListener {

    private TextView textViewName;
    private TextView textViewTemp;
    private TextView textViewHumi;
    private TextView textViewId;
    private TextView textViewDescription;
    private EditText editText;
    private ImageView imageView;
    private Button button;
    private Button btnLocalisation;
    private WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btnSearch);
        btnLocalisation = findViewById(R.id.btnLocalisation);
        textViewName = findViewById(R.id.textViewName);
        textViewTemp = findViewById(R.id.textViewTemp);
        textViewHumi = findViewById(R.id.textViewHumi);
        textViewId = findViewById(R.id.textViewId);
        textViewDescription = findViewById(R.id.textViewDescription);
        weatherService = new WeatherService(this);
       retrieveWeather();
    }

    private void retrieveWeather () {
//        Weather weather = weatherService.get();
//        textViewDescription.setText(weather.getDescription());
//        textViewTemp.setText(Integer.toString(weather.getTemperature()));
//        textViewHumi.setText(Integer.toString(weather.getHumidity()));
//        textViewName.setText(weather.getCity().getName());
    }

    @Override
    public void onWeather(Weather weather) {
        Toast.makeText(this, weather.getCity().getLocation().getLatitude().toString()+weather.getCity().getLocation().getLongitude().toString(),Toast.LENGTH_LONG).show();
    }
}

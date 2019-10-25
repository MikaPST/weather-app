package com.example.services;

import com.example.models.City;
import com.example.models.Weather;

public class WeatherService implements CityServiceListener{

    CityService cityService;
    WeatherServiceListener weatherServiceListener;

    public WeatherService(WeatherServiceListener weatherServiceListener){
        this.weatherServiceListener = weatherServiceListener;
        new CityService(this);


//        cityService = new CityService();
//    }
//
//    public Weather get () {
//        Weather weather = new Weather();
//        weather.setDescription("Nuageux");
//        weather.setHumidity(25);
//        weather.setTemperature(30);
//        weather.setCity(cityService.get());
//        return weather;
//    }
//
//    @Override
//    public void onCity(City city) {
//
    }

    @Override
    public void onCity(City city) {
        Weather newWeather = new Weather();
        newWeather.getCity();
        weatherServiceListener.onWeather(newWeather);

    }
}
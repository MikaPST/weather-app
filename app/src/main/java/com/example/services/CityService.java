package com.example.services;

import com.example.models.City;
import com.example.models.Location;

public class CityService implements LocationServiceListener {

    LocationService locationService;
    CityServiceListener cityServiceListener;


    public CityService(CityServiceListener cityServiceListener){
        this.cityServiceListener = cityServiceListener;
     new LocationService(this);

    }

    @Override
    public void onLocation(Location location) {
        City newCity = new City();
        newCity.getName();
        newCity.getLocation();
        cityServiceListener.onCity(newCity);
    }

//    public City get() {
//        City city = new City();
//        city.setName("Paris");
//        return city;
//    }
//
//    @Override
//    public void onLocation(Location location) {
//        location.getLatitude();
//        location.getLongitude();
//        City newCity = new City();
//        newCity.setLocation(location);
//        cityServiceListener.onCity(newCity);
//
//    }
//
}
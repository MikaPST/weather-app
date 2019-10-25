package com.example.services;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;


import com.example.models.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;

import com.example.activities.WeatherActivity;

import static androidx.core.content.ContextCompat.checkSelfPermission;

public class LocationService implements LocationListener {

    LocationServiceListener locationServiceListener;

    public LocationService(LocationServiceListener locationServiceListener) {
        this.locationServiceListener = locationServiceListener;

        Context context = (Context) locationServiceListener;
        LocationManager locationManager = (LocationManager) context.getSystemService(
                Context.LOCATION_SERVICE
        );
        ActivityCompat.requestPermissions(
                (Activity) context,
                new String[]{ Manifest.permission.ACCESS_FINE_LOCATION},
                1
        );
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000,
                1,
                this
        );
    }


    @Override
    public void onLocationChanged(android.location.Location location) {
        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();
        Location newLocation = new Location();
        newLocation.setLatitude(latitude);
        newLocation.setLongitude(longitude);
        locationServiceListener.onLocation(newLocation);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
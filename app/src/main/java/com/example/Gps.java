package com.example;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;

import static java.lang.Math.*;

public class Gps {

    public Gps(double lat, double lng) throws Exception{
        setLatitude(lat);
        setLongitude(lng);
    }
    private double latitude;
    public double getLatitude() {return latitude;}
    public void setLatitude(double latitude)throws Exception {
        if(latitude<-90 || latitude>90) {
            throw new BadLatitudeException();
        }
        else {
            this.latitude = latitude;
        }
    }

    private double longitude;
    public double getLongitude() {return longitude;}
    public void setLongitude(double longitude) throws Exception {
        if(longitude<-180 || longitude>180) {
            throw new BadLongitudeException();
        }
        else {
            this.longitude = longitude;
        }
    }

    public class BadLatitudeException extends Exception {
        public BadLatitudeException() {
            super("La latitude doit être comprise entre -90° et 90°");
        }
    }
    public class BadLongitudeException extends Exception {
        public BadLongitudeException() {
            super("La longitude doit être comprise entre -180° et 180°");
        }
    }

    double calcDistanceVers(Gps lieu) {
        Double origLat = latitude * PI / 180;
        Double destLat = lieu.latitude * PI / 180;
        Double diffLng = (longitude - lieu.getLongitude()) * PI / 180;
        return acos(sin(origLat)* sin(destLat) + cos(origLat)*cos(destLat) * cos(diffLng)) * 6371;
        // ACOS(SIN(RADIANS(B2))*SIN(RADIANS(B3))+COS(RADIANS(B2))*COS(RADIANS(B3)) * COS(RADIANS(C2-C3)))*6371
    }

    public void save(Context ctxt, String fileName) throws Exception {
        File file = new File(ctxt.getExternalFilesDir(null), fileName);
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(String.valueOf(latitude).getBytes());
        stream.write(String.valueOf(longitude).getBytes());
        stream.close();
    }

}

package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.servicemto.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LocationListener {

    String API_KEY;
    String SEARCH_NAME_CITY = "http://api.openweathermap.org/data/2.5/weather?q=";
    String ICON_DESIGN = "http://openweathermap.org/img/wn/@2x.png";

    //String VAR_PARIS = "http://api.openweathermap.org/data/2.5/weather?q=Paris&APPID=28f68804c88adda2bbca8afcf894454d";


    TextView textViewName, textViewTemp, textViewHumi, textViewId, textViewDescription;
    EditText editText;
    ImageView imageView;
    Button button, btnLocalisation;

    LocationManager locationManager;
    Location location;
    Double latitude;
    Double longitude;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        API_KEY = "&" + getString(R.string.API_KEY);
        Toast.makeText(this, API_KEY, Toast.LENGTH_LONG).show();


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        String[] permission = {Manifest.permission.ACCESS_FINE_LOCATION};
        ActivityCompat.requestPermissions(this, permission, 1);

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.btnSearch);
        btnLocalisation = findViewById(R.id.btnLocalisation);
        textViewName = findViewById(R.id.textViewName);
        textViewTemp = findViewById(R.id.textViewTemp);
        textViewHumi = findViewById(R.id.textViewHumi);
        textViewId = findViewById(R.id.textViewId);
        textViewDescription = findViewById(R.id.textViewDescription);


    }

    public void search(View view) {
        try {
            String city = editText.getText().toString();
            HttpClient service = new HttpClient(SEARCH_NAME_CITY+city+"&units=metric"+API_KEY);
            //HttpClient service = new HttpClient(VAR_PARIS);
            service.start();
            service.join();
            String reponseWeb = service.getResponse();

            //on récupère l'objet JSON
            JSONObject json = new JSONObject(reponseWeb);




            JSONArray weather = json.getJSONArray("weather");
            for (int i=0; i < weather.length() ; i++ ) {
                JSONObject data = weather.getJSONObject(i);
                String description = data.getString("description");
                textViewDescription.setText(description);
            }

            //on descend d'un cran dans l'objet
            JSONObject main = json.getJSONObject("main");

            //on descend encore mais cette fois-ci on récupère la valeur
            String name = json.getString("name");
            String id = json.getString("id");
            String humidity = main.getString("humidity");
            String temp = main.getString("temp");

            textViewId.setText(id);
            textViewName.setText(name);
            textViewHumi.setText(humidity);
            textViewTemp.setText(temp);


        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void save(View view) {
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude=location.getLatitude();
        longitude=location.getLongitude();
        //String msg="Latitude: "+latitude + "\n\rLongitude: "+longitude;
        //tvLatitude.setText(latitude.toString());
        //tvLongitude.setText(longitude.toString());

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

    public void localisation(View view) {
        if(checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, this);
        }
    }
}

package com.example.brian.weather;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FusedLocationProviderClient client;




    TextView cityField, detailsField, currentTemperatureField, humidity_field, pressure_field, weatherIcon, updatedField;

    Typeface weatherFont;

    AlertDialog.Builder builder;

    private final int coarseResult=1;
    private final int fineResult=1;

    private String lat;
    private String lon;

    private String clothing_pref;
    private String gender_pref;

    private int[] casual_men = {R.drawable.casual_men_1,R.drawable.casual_men_2,
            R.drawable.casual_men_3,R.drawable.casual_men_4};
    private int[] b_casual_men = {R.drawable.b_casual_men_1,R.drawable.b_casual_men_2,
            R.drawable.b_casual_men_3,R.drawable.b_casual_men_4};
    private int[] formal_men = {R.drawable.formal_men_1,R.drawable.formal_men_2,
            R.drawable.formal_men_3,R.drawable.formal_men_4};
    private int[] casual_women = {R.drawable.casual_women_1,R.drawable.casual_women_2,
            R.drawable.casual_women_3,R.drawable.casual_women_4};
    private int[] b_casual_women = {R.drawable.b_casual_women_1,R.drawable.b_casual_women_2,
            R.drawable.b_casual_women_3,R.drawable.b_casual_women_4};
    private int[] formal_women = {R.drawable.formal_women_1,R.drawable.formal_women_2,
            R.drawable.formal_women_3,R.drawable.formal_women_4};

    private String[] opener = {"Brrr, stay inside!","Chilly! Wear a coat!",
            "You could get away with a sweater.","Nice and hot weather! Wear a T-Shirt.","Stay indoors!"};
    private double temp_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        /*permissionCheck();*/

        Intent intent = getIntent();
        clothing_pref = intent.getStringExtra("clothing_pref");
        gender_pref = intent.getStringExtra("gender_pref");

        weatherFont = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        cityField = (TextView)findViewById(R.id.city_field);
        updatedField = (TextView)findViewById(R.id.updated_field);
        detailsField = (TextView)findViewById(R.id.details_field);
        currentTemperatureField = (TextView)findViewById(R.id.current_temperature_field);
        humidity_field = (TextView)findViewById(R.id.humidity_field);
        pressure_field = (TextView)findViewById(R.id.pressure_field);
        weatherIcon = (TextView)findViewById(R.id.weather_icon);
        weatherIcon.setTypeface(weatherFont);


        Function.placeIdTask asyncTask =new Function.placeIdTask(new Function.AsyncResponse() {
            public void processFinish(String weather_city, String weather_description, String weather_temperature,
                                      String weather_humidity, String weather_pressure, String weather_updatedOn,
                                      String weather_iconText, String sun_rise,String tempNum) {

                cityField.setText(weather_city);
                updatedField.setText(weather_updatedOn);
                detailsField.setText(weather_description);
                currentTemperatureField.setText(weather_temperature);
                humidity_field.setText("Humidity: "+weather_humidity);
                pressure_field.setText("Pressure: "+weather_pressure);
                weatherIcon.setText(Html.fromHtml(weather_iconText));
                temp_num=Double.parseDouble(tempNum);

                builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Recommendations");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {}
                });
                if(temp_num<5){
                    builder.setMessage(opener[0] + " You should wear: ");
                    if(clothing_pref.equals("Casual") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_men[0]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Male")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_men[0]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_men[0]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Casual") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_women[0]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Female")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_women[0]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_women[0]);
                        builder.setView(img);
                    }

                }
                if(temp_num>=5 && temp_num<10){
                    builder.setMessage(opener[1] + " You should wear: ");
                    if(clothing_pref.equals("Casual") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_men[1]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Male")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_men[1]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_men[1]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Casual") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_women[1]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Female")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_women[1]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_women[1]);
                        builder.setView(img);
                    }
                }
                if(temp_num>=10 && temp_num<20){
                    builder.setMessage(opener[2] + " You should wear: ");
                    if(clothing_pref.equals("Casual") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_men[2]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Male")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_men[2]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_men[2]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Casual") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_women[2]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Female")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_women[2]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_women[2]);
                        builder.setView(img);
                    }
                }
                if(temp_num>=20){
                    builder.setMessage(opener[3] + " You should wear: ");
                    if(clothing_pref.equals("Casual") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_men[3]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Male")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_men[3]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Male")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_men[3]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Casual") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(casual_women[3]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Business Casual") && gender_pref.equals("Female")){
                        Log.d("test","here");
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(b_casual_women[3]);
                        builder.setView(img);
                    }
                    else if(clothing_pref.equals("Professional") && gender_pref.equals("Female")){
                        ImageView img = new ImageView(MainActivity.this);
                        img.setImageResource(formal_women[3]);
                        builder.setView(img);
                    }
                }
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        asyncTask.execute("40.7306","-73.9352"); //  asyncTask.execute("Latitude", "Longitude")
    }

        /*need device for actuated permissions testing*/
    public void permissionCheck(){
        Log.d("permissions","here");
        int coarseCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION);
        int fineCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},coarseResult);
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},fineResult);



        client = LocationServices.getFusedLocationProviderClient(this);
        client.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null){
                    Log.d("here","test");
                    lat=String.valueOf(location.getLatitude());
                    lon=String.valueOf(location.getLongitude());
                    Log.d("latitude",lat);
                    Log.d("longitude",lon);

                }
            }
        });


    }
}

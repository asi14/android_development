package com.example.brian.weather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ClothingActivity extends AppCompatActivity{
    private Spinner gender_select;
    private Spinner clothing_select;
    private Button get_weather;
    private String clothing;
    private String gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing);

        gender_select = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> gender_adapter = ArrayAdapter.createFromResource(this,R.array.gender_array,
                android.R.layout.simple_spinner_item);
        gender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender_select.setAdapter(gender_adapter);


        clothing_select = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> clothing_adapter = ArrayAdapter.createFromResource(this,R.array.clothing_array,
                android.R.layout.simple_spinner_item);
        gender_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        clothing_select.setAdapter(clothing_adapter);

        get_weather = (Button)findViewById(R.id.button2);
        get_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clothing= ((TextView)clothing_select.getSelectedView()).getText().toString();
                gender = ((TextView)gender_select.getSelectedView()).getText().toString();
                Intent start_main_activity = new Intent(ClothingActivity.this,MainActivity.class);
                start_main_activity.putExtra("clothing_pref",clothing);
                start_main_activity.putExtra("gender_pref",gender);
                startActivity(start_main_activity);
                finish();
            }
        });

    }


}

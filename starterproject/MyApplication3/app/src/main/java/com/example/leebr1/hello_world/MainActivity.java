package com.example.leebr1.hello_world;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*imports for button*/
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton(){
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, android.net.Uri.parse("http://bxscience.edu"));
                startActivity(browserIntent);
            }
        });
    }
}

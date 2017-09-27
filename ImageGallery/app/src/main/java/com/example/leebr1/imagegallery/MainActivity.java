package com.example.leebr1.imagegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView gallery;
    Integer[] ImageList = {
            R.drawable.picture1,
    R.drawable.picture2,
    R.drawable.picture3,
    R.drawable.picture4,
    R.drawable.picture5,
    R.drawable.picture6,
    R.drawable.picture7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = (ListView)findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this, ImageList));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("click","clicky");
            }
        });

    }
}

/*
*http://www.androidauthority.com/how-to-build-an-image-gallery-app-718976/
* https://developer.android.com/training/material/lists-cards.html
* */

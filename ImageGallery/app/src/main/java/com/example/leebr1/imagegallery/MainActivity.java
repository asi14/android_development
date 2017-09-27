package com.example.leebr1.imagegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    RecyclerView imageGallery;
    RecyclerView.LayoutManager layout;
    /*ArrayList<CreateList> createList;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageGallery = (RecyclerView)findViewById(R.id.imagegallery);
        imageGallery.setHasFixedSize(true);
        layout = new GridLayoutManager(getApplicationContext(),2);
        imageGallery.setLayoutManager(layout);
        /*createList = prepareData();*/
        MyAdapter adapter = new MyAdapter(getApplicationContext());
        imageGallery.setAdapter(adapter);
    }
}

/*
*http://www.androidauthority.com/how-to-build-an-image-gallery-app-718976/
* https://developer.android.com/training/material/lists-cards.html
* */

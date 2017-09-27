package com.example.leebr1.imagegallery;
/*
* Decided to remove separate image section for better user experience (esp for scrolling section)
* Also thought that separate image section was redundant considering scrolling section
* */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
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
        /*
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("testdd","feeefe");
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Alert message to be shown");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setIcon(ImageList[i]);

                alertDialog.show();
            }
        });
        */
    }
}

/*
*http://www.androidauthority.com/how-to-build-an-image-gallery-app-718976/
* https://developer.android.com/training/material/lists-cards.html
* */

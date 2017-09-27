package com.example.leebr1.imagegallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by ruthlee on 9/27/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Integer[] ImageList;
    public ImageAdapter(Context con, Integer[] list){
        context = con;
        ImageList = list;
    }
    @Override
    public int getCount(){
        return ImageList.length;
    }

    @Override
    public Object getItem(int pos){
        return ImageList[pos];
    }

    @Override
    public long getItemId(int pos){
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent){
        ImageView img = new ImageView(this.context);
        img.setImageResource(ImageList[pos]);
        return img;
    }

}

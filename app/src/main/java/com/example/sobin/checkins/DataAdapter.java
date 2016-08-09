package com.example.sobin.checkins;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sobin.checkins.Models.LocationDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sobin on 3/8/16.
 */

public class DataAdapter extends BaseAdapter {

    private Activity activity;
    ArrayList<LocationDetails> locationDetails;
    private  ImageView img;
    private static LayoutInflater inflater = null;
    public DataAdapter(Activity a, ArrayList<LocationDetails> b) {
        activity = a;
        this.locationDetails=b;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return locationDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return locationDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.adapterview_activity, null);
        TextView name = (TextView) vi.findViewById(R.id.name); // title
        String name1=locationDetails.get(i).getName();
        name.setText(name1);
        TextView addr = (TextView) vi.findViewById(R.id.address); // title
        String address = locationDetails.get(i).getAddress();
        addr.setText(address);

        TextView desc = (TextView) vi.findViewById(R.id.des); // title
        String description =locationDetails.get(i).getDescription();
        desc.setText(description);

       // ImageView title4 = (ImageView) vi.findViewById(R.id.image1); // title
        String image = locationDetails.get(i).getPhotopath();
        Bitmap bitmap = BitmapFactory.decodeFile(image);
        ImageView img = (ImageView) vi.findViewById(R.id.image1);
        img.setImageBitmap(bitmap);
        return vi;
    }
}

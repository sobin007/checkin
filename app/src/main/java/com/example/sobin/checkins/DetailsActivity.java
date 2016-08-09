package com.example.sobin.checkins;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sobin.checkins.Models.LocationDetails;

import java.io.Serializable;

public class DetailsActivity extends AppCompatActivity {


    private LocationDetails locationdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView name= (TextView) findViewById(R.id.etName);
        TextView adress= (TextView) findViewById(R.id.address);
        TextView dec= (TextView) findViewById(R.id.des);
        ImageView img= (ImageView) findViewById(R.id.image);

       locationdetails = (LocationDetails) getIntent().getExtras().getSerializable("location");

        if (locationdetails != null) {
            name.setText(locationdetails.getName());
            adress.setText(locationdetails.getAddress());
            dec.setText(locationdetails.getDescription());
            String img1 = locationdetails.getPhotopath();
            Bitmap bitmap = BitmapFactory.decodeFile(img1);
            img.setImageBitmap(bitmap);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mapmain, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.map1:
                Intent intent1=new Intent(DetailsActivity.this,MapActivity1.class);
                intent1.putExtra("location",locationdetails);
                startActivity(intent1);
        }
        return true;

    }
}

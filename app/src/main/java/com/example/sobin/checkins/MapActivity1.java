package com.example.sobin.checkins;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sobin.checkins.Models.LocationDetails;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static android.R.transition.move;
import static com.example.sobin.checkins.R.drawable.camera;

public class MapActivity1 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap,mMap1;
    LocationDetails locationDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map1);
        ListView listView = (ListView) findViewById(R.id.list_item);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map1);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
            locationDetails= (LocationDetails) getIntent().getExtras().getSerializable("location");
            LatLng location = new LatLng(locationDetails.getLat(),locationDetails.getLng());
            String name=locationDetails.getName();
            mMap.addMarker(new MarkerOptions().position(location).title("Marker in your location"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
            mMap.animateCamera(CameraUpdateFactory.zoomBy(13));


    }
}

package com.example.sobin.checkins;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.sobin.checkins.Models.LocationDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class MainActivity extends AppCompatActivity {

    private ArrayList<LocationDetails> locationDetailses;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView= (ListView) findViewById(R.id.list_item);
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext(),"cDB",null,1);
        locationDetailses=databaseHelper.getData();
        DataAdapter newadapter = new DataAdapter(MainActivity.this,locationDetailses);
        View view = getLayoutInflater() .inflate(R.layout.activity_main2, null);
        ViewGroup viewGroup= ( ViewGroup) listView.getParent();
        viewGroup.addView(view);
        listView.setEmptyView(view);
            listView.setAdapter(newadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);

                LocationDetails obj = (LocationDetails) listView.getAdapter().getItem(i);
                intent.putExtra("location", obj);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch(item.getItemId()){
            case R.id.addlocation:
                Intent intent=new Intent(MainActivity.this,AddLocation.class);
                startActivity(intent);
                break;
            case R.id.map:
                Intent intent1=new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent1);
        }
        return true;

    }
}

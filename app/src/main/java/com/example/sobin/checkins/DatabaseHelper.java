package com.example.sobin.checkins;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sobin.checkins.Models.LocationDetails;

import java.util.ArrayList;

/**
 * Created by sobin on 4/8/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public SQLiteDatabase cDB;
    public static final String DATABASE_TABLE = "locations";
    public static final String FIELD_ROW_ID = "id";
    public static final String FIELD_LATI = "lat";
    public static final String FIELD_LN = "lng";
    public static final String FIELD_LOC_NAME = "locationname";
    public static final String FIELD_LOC_ADDRESS = "locationaddress";
    public static final String FIELD_LOC_DESCRIPTION = "description";
    public static final String FIELD_TIME = "time";
    public static final String FIELD_PHOTO_PATH = "photo_path";

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        cDB = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists " + DATABASE_TABLE + "("
                + FIELD_ROW_ID + " integer primary key autoincrement," +
                FIELD_LATI + " double," + FIELD_LN + " double," + FIELD_LOC_NAME + " text," +
                FIELD_LOC_ADDRESS + " text," + FIELD_LOC_DESCRIPTION + " text," + FIELD_TIME + " double," + FIELD_PHOTO_PATH +" text "+ ")";
        db.execSQL(sql);
    }

    public long insert(LocationDetails locationDetails) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.FIELD_LOC_NAME,locationDetails.getName());
        contentValues.put(DatabaseHelper.FIELD_LATI,locationDetails.getLat());
        contentValues.put(DatabaseHelper.FIELD_LN,locationDetails.getLng());
        contentValues.put(DatabaseHelper.FIELD_LOC_ADDRESS,locationDetails.getAddress());
        contentValues.put(DatabaseHelper.FIELD_LOC_DESCRIPTION,locationDetails.getDescription());
        contentValues.put(DatabaseHelper.FIELD_TIME,locationDetails.getTime());
        contentValues.put(DatabaseHelper.FIELD_PHOTO_PATH,locationDetails.getPhotopath());
        return cDB.insert(DATABASE_TABLE, null, contentValues);
    }

    public int delete() {
        return cDB.delete(DATABASE_TABLE, null, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(db);
    }
    public ArrayList<LocationDetails> getData() {
        ArrayList<LocationDetails> locationDetailsArrayList = new ArrayList<>();
            String selectQuery = "SELECT  * FROM " + DATABASE_TABLE;
            SQLiteDatabase cDB = this.getReadableDatabase();
            Cursor cursor = cDB.rawQuery(selectQuery, null);
            if (cursor.moveToFirst()) {
                do {
                    LocationDetails locationDetails=new LocationDetails();
                    locationDetails.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_LOC_NAME)));
                    locationDetails.setAddress(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_LOC_ADDRESS)));
                    locationDetails.setDescription(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_LOC_DESCRIPTION)));
                    locationDetails.setPhotopath(cursor.getString(cursor.getColumnIndex(DatabaseHelper.FIELD_PHOTO_PATH)));
                    locationDetails.setTime(cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.FIELD_TIME)));
                    locationDetails.setLat(cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.FIELD_LATI)));
                    locationDetails.setLat(cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.FIELD_LN)));
                    // get  the  data into array,or class variable
                    locationDetailsArrayList.add(locationDetails);
                } while (cursor.moveToNext());
            }
            cDB.close();
        return locationDetailsArrayList;
        }

}


package com.ajir.dharam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dharam on 7/26/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "TrackerDatabase";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_USER = "Tracker";
    public static final String TABLE_USER_LOCATION = "UserLocation";
    public static final String ID = "Id";
    public static final String USER_LONGITUDE = "Longitude";
    public static final String USER_LATTITUDE = "Lattitude";
    public static final String USER_LOCATION_NAME = "LocationName";
    public static final String USER_NAME = "Name";
    public static final String PASSWORD = "Password";
    public static final String PHONE_NO = "PhoneNo";


        public DatabaseHelper(Context context) {
            super(context,DATABASE_NAME,null,DATABASE_VERSION );
        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            String tracker = "CREATE TABLE " + TABLE_USER + "("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT,"
                    + PASSWORD + "TEXT,"+ PHONE_NO + " INTEGER" + ")";


            String location = "CREATE TABLE " + TABLE_USER_LOCATION + "("
                    + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_LATTITUDE + " TEXT,"
                    + USER_LONGITUDE + "TEXT,"+ USER_LOCATION_NAME + " VARCHAR(200)" + ")";
            db.execSQL(tracker);
            db.execSQL(location);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }


    void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(PASSWORD, user.getPassword());
        values.put(PHONE_NO,user.getPhone_number());



        db.insert(TABLE_USER, null, values);

        db.close();
    }

    void addUserLocation(UserLocation userLocation) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_LATTITUDE, userLocation.getLattitude());
        values.put(USER_LONGITUDE, userLocation.getLongitude());
        values.put(USER_LOCATION_NAME,userLocation.getLocationName());



        db.insert(TABLE_USER_LOCATION, null, values);

        db.close();
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }


}

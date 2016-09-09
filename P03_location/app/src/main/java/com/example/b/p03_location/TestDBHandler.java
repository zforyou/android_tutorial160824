package com.example.b.p03_location;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by b on 2016-09-09.
 */
public class TestDBHandler {
    TestSqliteOpenHelper helper;

    public TestDBHandler(Context context){
        helper = new TestSqliteOpenHelper(context, "myTracker", null, 1);
    }
    public void insert(long timestamp, double latitude, double longitude){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("timestamp", timestamp);
        values.put("latitude", latitude);
        values.put("longitude", longitude);

        db.insert("location", null, values);
    }

    public void delete (String name){
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("student","name =?", new String[]{name});
    }

    public void update(String name, int newAge){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("age", newAge);

        db.update("student", values, "name = ?", new String[]{name});
    }

    public String showAllData(){
        SQLiteDatabase db = helper.getReadableDatabase();

        String str = "";
        Cursor c = db.query("location", null, null, null, null, null, null);
        while (c.moveToNext()){
            long timestamp = c.getLong(c.getColumnIndex("timestamp"));
            double latitude = c.getDouble(c.getColumnIndex("latitude"));
            double longitude = c.getDouble(c.getColumnIndex("longitude"));

            str += "\ntimestamp : "+timestamp+
                    " latitude : " + latitude+ " longitude : "+longitude;
            Log.d("sqlite","timestamp : "+timestamp+
                    " latitude : " + latitude+ " longitude : "+longitude);
        }
        return str;
    }
}

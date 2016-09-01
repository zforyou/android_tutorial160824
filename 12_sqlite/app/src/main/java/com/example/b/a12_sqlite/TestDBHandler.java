package com.example.b.a12_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by b on 2016-09-01.
 */
public class TestDBHandler {
    TestSqliteOpenHelper helper;

    public TestDBHandler(Context context){
        helper = new TestSqliteOpenHelper(context, "people", null, 1);
    }

    public void insert(String name, String address, int age){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("address", address);
        values.put("age", age);

        db.insert("student", null, values);
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

    public void showAllData(){
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor c = db.query("student", null, null, null, null, null, null);
        while (c.moveToNext()){
            String name = c.getString(c.getColumnIndex("name"));
            String address = c.getString(c.getColumnIndex("address"));
            int age = c.getInt(c.getColumnIndex("age"));

            Log.d("sqlite","name : "+name+ " address : " + address+ " age : "+age);
        }
    }
}

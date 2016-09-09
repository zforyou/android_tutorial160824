package com.example.b.p03_location;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by b on 2016-09-09.
 */
public class TestSqliteOpenHelper extends SQLiteOpenHelper{
    public TestSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE location(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "timestamp INTEGER, latitude REAL, longitude REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS location;";
        db.execSQL(sql);

        onCreate(db);
    }
}

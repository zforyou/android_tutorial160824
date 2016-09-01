package com.example.b.a12_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by b on 2016-09-01.
 */
public class TestSqliteOpenHelper extends SQLiteOpenHelper {
    public TestSqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, address TEXT, age INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS student;";
        db.execSQL(sql);

        onCreate(db);
    }
}

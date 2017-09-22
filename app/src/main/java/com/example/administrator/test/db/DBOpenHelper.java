package com.example.administrator.test.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 9/22/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    public static final String DATABASE = "main_data.db";
    public static final String TABLE = "customer";
    public static final int VERSION = 1;

    public DBOpenHelper(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE+"(id INTEGER PRIMARY KEY AUTOINCREAMENT,nm TEXT,address TEXT,mail TEXT,mob INTEGER);");
    }
}
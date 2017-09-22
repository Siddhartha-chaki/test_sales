package com.example.administrator.test.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.administrator.test.Cust;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Created by Administrator on 9/22/2017.
 */

public class DatabaseAccess {
    private SQLiteDatabase database;
    private DBOpenHelper openHelper;
    private static volatile DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DBOpenHelper(context);
    }

    public static synchronized DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    public void save(Cust memo) {
        ContentValues values = new ContentValues();
        values.put("nm", memo.getNm());
        values.put("address", memo.getAddress());
        values.put("mail", memo.getEmail());
        values.put("mob", memo.getMob());
        database.insert(DBOpenHelper.TABLE, null, values);
    }

    public void update(Cust memo) {
        ContentValues values = new ContentValues();
        values.put("nm", memo.getNm());
        values.put("address", memo.getAddress());
        values.put("mail", memo.getEmail());
        values.put("mob", memo.getMob());
        String[] s={memo.getId()};
        database.update(DBOpenHelper.TABLE, values, "date = ?",s);
    }

    public void delete(Cust memo) {
        String date = memo.getId();
        database.delete(DBOpenHelper.TABLE, "id = ?", new String[]{date});
    }

    public List<Cust> getAllMemos() {
        List<Cust> memos = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * From customer ORDER BY id DESC", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Integer id = cursor.getInt(0);
            String nm = cursor.getString(1);
            String add = cursor.getString(2);
            String mail= cursor.getString(3);
            int mob=cursor.getInt(4);
            memos.add(new Cust(nm,add,mail,mob,id));
            cursor.moveToNext();
        }
        cursor.close();
        return memos;
    }
}


package com.info.notuygulamas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(@Nullable Context context) {
        super(context, "notlar.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS notlar " +
                "(not_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ders_adi TEXT," +
                "not1 INTEGER," +
                "not2 INTEGER" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS notlar");
        onCreate(db);
    }
}

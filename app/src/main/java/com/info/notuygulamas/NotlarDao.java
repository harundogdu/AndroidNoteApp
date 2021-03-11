package com.info.notuygulamas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotlarDao {
    public ArrayList<Notlar> tumNotlariGetir(Veritabani veritabani) {
        ArrayList<Notlar> notlarArrayList = new ArrayList<>();
        SQLiteDatabase database = veritabani.getWritableDatabase();
        Cursor c = database.rawQuery("SELECT * FROM notlar", null);

        while (c.moveToNext()) {
            Notlar n = new Notlar(
                    c.getInt(c.getColumnIndex("not_id")),
                    c.getString(c.getColumnIndex("ders_adi")),
                    c.getInt(c.getColumnIndex("not1")),
                    c.getInt(c.getColumnIndex("not2"))
            );
            notlarArrayList.add(n);
        }

        return notlarArrayList;
    }

    public void notSil(Veritabani veritabani, int not_id) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        database.delete("notlar", "not_id=?", new String[]{String.valueOf(not_id)});
        database.close();
    }

    public void notEkle(Veritabani veritabani, String ders_adi, int not1, int not2) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ders_adi", ders_adi);
        values.put("not1", not1);
        values.put("not2", not2);

        database.insertOrThrow("notlar", null, values);
        database.close();
    }

    public void notGuncelle(Veritabani veritabani , int not_id, String ders_adi , int not1 , int not2) {
        SQLiteDatabase database = veritabani.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("ders_adi", ders_adi);
        values.put("not1", not1);
        values.put("not2", not2);

        database.update("notlar",values,"not_id=?",new String[]{String.valueOf(not_id)});
        database.close();

    }

}

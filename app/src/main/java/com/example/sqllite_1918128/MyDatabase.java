package com.example.sqllite_1918128;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_inventory";
    private static final String tb_alat = "tb_alat";
    private static final String tb_alat_id  = "id";
    private static final String tb_alat_kode = "kode";
    private static final String tb_alat_nama = "nama";
    private static final String tb_alat_jumlah = "jumlah";
    private static final String CREATE_TABLE_ALAT = "CREATE TABLE " +
            tb_alat +"("
            + tb_alat_id + " INTEGER PRIMARY KEY ,"
            + tb_alat_kode + " TEXT ,"
            + tb_alat_nama + " TEXT ,"
            + tb_alat_jumlah + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ALAT);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateAlat(Alat data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_alat_id, data.get_id());
        values.put(tb_alat_kode, data.get_kode());
        values.put(tb_alat_nama, data.get_nama());
        values.put(tb_alat_jumlah, data.get_jumlah());
        db.insert(tb_alat, null, values);
        db.close();
    }
    public List<Alat> ReadAlat() {
        List<Alat> listAlt = new ArrayList<Alat>();
        String selectQuery = "SELECT * FROM " + tb_alat;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Alat data = new Alat();
                data.set_id(cursor.getString(0));
                data.set_kode(cursor.getString(1));
                data.set_nama(cursor.getString(2));
                data.set_jumlah(cursor.getString(3));
                listAlt.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listAlt;
    }
    public int UpdateAlat (Alat data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_alat_kode, data.get_kode());
        values.put(tb_alat_nama, data.get_nama());
        values.put(tb_alat_jumlah, data.get_jumlah());
        return db.update(tb_alat, values, tb_alat_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteAlat(Alat data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_alat,tb_alat_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

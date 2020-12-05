package com.example.calcoin.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeritabaniYardimcisi extends SQLiteOpenHelper {
    public VeritabaniYardimcisi(Context context){
        super(context,"CALCOIN",null,1); // CALCOIN veritabanı ismi

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table kullanicilar(id INTEGER PRIMARY KEY AUTOINCREMENT,kullaniciAdi varchar,telefon varchar,sifre varchar);");
        db.execSQL("Create table notlar(id INTEGER PRIMARY KEY AUTOINCREMENT,kullaniciAdi varchar,baslik varchar,notlar TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS CALCOIN");
        onCreate(db);

    }
}

package com.example.calcoin.DATABASE.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.calcoin.DATABASE.VeritabaniYardimcisi;

public class KullanicilarDao { // data access object     *> bütün fonksiyonları çalışıyor.

    public void kullaniciEkle(VeritabaniYardimcisi vt,String kullaniciAdi,String telefon,String sifre){
        SQLiteDatabase dbx=vt.getReadableDatabase();
        ContentValues degerler=new ContentValues();
        degerler.put("kullaniciAdi",kullaniciAdi);
        degerler.put("telefon",telefon);
        degerler.put("sifre",sifre);
        dbx.insertOrThrow("kullanicilar",null,degerler);
        dbx.close();
    }

    public int varMi(VeritabaniYardimcisi vt,String name){ // sonuç sıfırdan farklı ise o değerde bir kullanıcı vardır.
        int sonuc=0;
        String sql="select Count(*) from kullanicilar where kullaniciAdi='"+name+"'";

        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor c=dbx.rawQuery(sql,null);
        while (c.moveToNext()){
            sonuc=c.getInt(c.getColumnIndex("Count(*)"));
        }
        return sonuc;
    }

    public int girisSorgula(VeritabaniYardimcisi vt,String kullaniciadi,String sifresi){
        int sonuc=0;
        String sql="select Count(*) from kullanicilar where kullaniciAdi='"+kullaniciadi+"' and sifre='"+sifresi+"'";

        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor c=dbx.rawQuery(sql,null);
        while (c.moveToNext()){
            sonuc=c.getInt(c.getColumnIndex("Count(*)"));
        }
        return sonuc;
    }
}

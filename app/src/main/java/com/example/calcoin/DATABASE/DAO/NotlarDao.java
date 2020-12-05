package com.example.calcoin.DATABASE.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.calcoin.DATABASE.VeritabaniYardimcisi;
import com.example.calcoin.DATABASE.models.notlar;

import java.util.ArrayList;

public class NotlarDao {

    public void notEkle(VeritabaniYardimcisi vt,String kullaniciAdi,String baslik ,String not){
        SQLiteDatabase dbx=vt.getReadableDatabase();
        ContentValues degerler=new ContentValues();
        degerler.put("kullaniciAdi",kullaniciAdi);
        degerler.put("baslik",baslik);
        degerler.put("notlar",not);
        dbx.insertOrThrow("notlar",null,degerler);
        dbx.close();
    }


    ////////////////////////////////////////////////////////////////////////////
    public Cursor cursorList(VeritabaniYardimcisi vt,String name){ // çalışıyor. Başlıkları getiriyor.
        SQLiteDatabase db=vt.getWritableDatabase();
        Cursor data=db.rawQuery("Select * from notlar where kullaniciAdi='"+name+"'",null);
        return data;
    }
    ///////////////////////////////////////////////////////////////////////////
    public Cursor cursorNotList(VeritabaniYardimcisi vt,String name,String title){
        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor data=dbx.rawQuery("Select * from notlar where kullaniciAdi='"+name+"' and baslik='"+title+"'" ,null);
        return data;
    }
    /////////////////////////////////////////////////////////////////////////////
    public int varMi(VeritabaniYardimcisi vt,String name,String baslik){ // sonuç sıfırdan farklı ise o değerde bir kullanıcı vardır.
        int sonuc=0;
        String sql="select Count(*) from notlar where kullaniciAdi='"+name+"' and baslik='"+baslik+"'";

        SQLiteDatabase dbx=vt.getWritableDatabase();
        Cursor c=dbx.rawQuery(sql,null);
        while (c.moveToNext()){
            sonuc=c.getInt(c.getColumnIndex("Count(*)"));
        }
        return sonuc;
    }



}

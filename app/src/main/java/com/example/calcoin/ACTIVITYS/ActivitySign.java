package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.calcoin.DATABASE.DAO.KullanicilarDao;
import com.example.calcoin.DATABASE.VeritabaniYardimcisi;
import com.example.calcoin.R;

public class ActivitySign extends AppCompatActivity {

    // kullanıcı var mı yok mu yapılmadı.

    VeritabaniYardimcisi vt;
    EditText no,pass,pass2,userName;
    Button saveButton;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        getSupportActionBar().hide();
       // database=this.openOrCreateDatabase("CalCoin",MODE_PRIVATE,null);
        tanimla();
       vt=new VeritabaniYardimcisi(this);

    }
    public void tanimla(){
        no=(EditText)findViewById(R.id.numara);
        pass=(EditText)findViewById(R.id.sifre);
        saveButton=(Button)findViewById(R.id.kaydet);
        userName=(EditText)findViewById(R.id.isim);
        pass2=(EditText)findViewById(R.id.tekrar);
    }

    public void edittextClear(){
        no.setText("");
        pass.setText("");
        pass2.setText("");
        userName.setText("");

    }


    public boolean kullaniciVarMi(String name) {

        String sql = "Select count(*) from userTable where name=";
        String sql2=sql.concat(name);
            database = this.openOrCreateDatabase("CalCoin", MODE_PRIVATE, null);
            Cursor c=database.rawQuery(sql2,null);
            if(c==null)
                return false;
                else
                    return true;

    }

    public void save(View view){
        String sqlNo,sqlName,sqlPassword;

        sqlNo=no.getText().toString();
        sqlName=userName.getText().toString();
        sqlPassword=pass.getText().toString();

        KullanicilarDao kullanicilarDao=new KullanicilarDao();
       /* try{
            kullanicilarDao.kullaniciEkle(vt,sqlName,sqlNo,sqlPassword);
            Toast.makeText(getApplicationContext(),"Kullanıcı kaydedildi!",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Kullanıcı kaydedilemedi",Toast.LENGTH_LONG).show();
        }*/

        if(sqlName.length()>0 && sqlNo.length()>0 && sqlPassword.length()>0 && pass2.length()>0) { // 1.
            if(new String(pass.getText().toString()).equals(pass2.getText().toString())) { // şifreleri karşılaştırma yapıyor.

                if(kullanicilarDao.varMi(vt,sqlName)==0) { // çalışıyor.
                    try {
                        kullanicilarDao.kullaniciEkle(vt, sqlName, sqlNo, sqlPassword);
                        Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        },1500);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Unsuccessful", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"User found, try again!",Toast.LENGTH_LONG).show();
                }
                   /* try {
                        database = this.openOrCreateDatabase("CalCoin", MODE_PRIVATE, null); // database oluşturuldu, Eğer varsa da open yapıldı
                        String createTable = "Create table if not EXISTS userTable(id INTEGER PRIMARY KEY AUTOINCREMENT,number varchar,name varchar,password varchar)";
                        database.execSQL(createTable); // userTable tablosu oluşturuldu.

                        String insertSql = "INSERT INTO userTable(number,name,password) VALUES(?,?,?)";
                        SQLiteStatement statement = database.compileStatement(insertSql);
                        statement.bindString(1, sqlNo);
                        statement.bindString(2, sqlName);
                        statement.bindString(3, sqlPassword);
                        statement.execute();

                        Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                finish();
                            }
                        }, 2000);

                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Unsuccessful!", Toast.LENGTH_LONG).show();

                    //////////////}*/
                    edittextClear(); ////


            }
            else
                Toast.makeText(getApplicationContext(), "Pass match failed!", Toast.LENGTH_LONG).show();

        }//1.
        else
            Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_LONG).show();//




    }
}

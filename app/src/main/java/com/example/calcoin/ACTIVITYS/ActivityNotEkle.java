package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcoin.DATABASE.DAO.NotlarDao;
import com.example.calcoin.DATABASE.VeritabaniYardimcisi;
import com.example.calcoin.R;

import java.util.EmptyStackException;

public class ActivityNotEkle extends AppCompatActivity {
    public EditText title, note;
    public TextView nameText;
    public Button saveButton;

    String bilgi;
    VeritabaniYardimcisi vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_ekle);
        getSupportActionBar().hide();
        tanimla();
        vt=new VeritabaniYardimcisi(this);

        intentInfo();
    }

    public void intentInfo(){ // kullanici ismini alır
        Intent intent=getIntent();
        bilgi=intent.getStringExtra("gelenad");
        nameText.setText(bilgi);
    }
    public void tanimla() {
        title = (EditText) findViewById(R.id.baslikText);
        note = (EditText) findViewById(R.id.notText);
        nameText=(TextView)findViewById(R.id.isimlik);

        saveButton=(Button)findViewById(R.id.kaydet);
    }

    public void save(View view){ // çalışıyor.
        NotlarDao notlar=new NotlarDao();

            if(title.getText().length()!=0 && note.getText().length()!=0) {//1
              if(notlar.varMi(vt,nameText.getText().toString(),title.getText().toString())==0) {//2

                  try {////

                      notlar.notEkle(vt, nameText.getText().toString(), title.getText().toString(), note.getText().toString());
                      Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_LONG).show();

                        new Handler().postDelayed(new Runnable() {
                              @Override
                              public void run() {
                                finish();
                                 }
                           },1600);

                  } catch (Exception e) {

                      e.printStackTrace();

                      Toast.makeText(getApplicationContext(), "Unsuccessful!", Toast.LENGTH_LONG).show();
                  } ////
              }//2

               else
                  Toast.makeText(getApplicationContext(), "There is a note on this topic!", Toast.LENGTH_LONG).show();
                }//1
            else
                Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_LONG).show();


    }
    @Override
 public void onBackPressed(){ // Çalışıyor. Telefondan geri tuşuna basıldığında yapılmasını istediğimiz olayları tanımlıyoruz.
        finish();
    }
}
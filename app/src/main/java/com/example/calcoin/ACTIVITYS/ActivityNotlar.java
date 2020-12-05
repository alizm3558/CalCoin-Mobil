package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcoin.DATABASE.DAO.NotlarDao;
import com.example.calcoin.DATABASE.VeritabaniYardimcisi;
import com.example.calcoin.DATABASE.models.notlar;
import com.example.calcoin.R;

import java.util.ArrayList;

public class ActivityNotlar extends AppCompatActivity {
 Spinner spinner; TextView text1;
 VeritabaniYardimcisi vt;
 public String deger;

    public String isim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);
        getSupportActionBar().hide();
        spinner=(Spinner)findViewById(R.id.spinner);

        text1=(TextView)findViewById(R.id.textView3);
        vt=new VeritabaniYardimcisi(this);



        Intent intent=getIntent();
        isim=intent.getStringExtra("gelenad");
        baslikList();
        clickSpinner_degerAl();


    }




    public void baslikList(){ // çalışıyor.
        ArrayList<String> theList=new ArrayList<>();

        try{
        Cursor data=new NotlarDao().cursorList(vt,isim);
        if(data.getCount()==0){
            Toast.makeText(getApplicationContext(),"The database was empty!",Toast.LENGTH_LONG).show();
        }
        else{
            while (data.moveToNext()){
                theList.add(data.getString(2)); // gelmesini istediğimin kolonun indisini giriyoruz. burada gelmeesini istediğimiz baslik sütunu 3. indiste.

            }

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, theList);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);
        }
            }catch (Exception e){

            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"There is problem!",Toast.LENGTH_LONG).show();
        }

    }

    public void notal(){



        try{
            Cursor data=new NotlarDao().cursorNotList(vt,isim,deger);
            if(data.getCount()==0){
                Toast.makeText(getApplicationContext(),"The database was empty!",Toast.LENGTH_LONG).show();
            }
            else{
                while (data.moveToNext()) {
                    text1.setText(data.getString(3).toString());
                    // text1.setText(text1.getText().toString()+data.getString(3).toString());
                }

            }
        }catch (Exception e){

            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"There  is problem 2!",Toast.LENGTH_LONG).show();
        }
    }


    public void clickSpinner_degerAl(){
spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        deger=spinner.getSelectedItem().toString();
        //Toast.makeText(getApplicationContext(),"Taaaaam! '"+deger+"'",Toast.LENGTH_LONG).show();
        System.out.println("DEğer: '"+deger+"'");
        text1.setText("");
        notal();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
    }





}

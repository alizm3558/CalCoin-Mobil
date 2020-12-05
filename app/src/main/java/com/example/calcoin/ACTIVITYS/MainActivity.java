package com.example.calcoin.ACTIVITYS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calcoin.DATABASE.DAO.KullanicilarDao;
import com.example.calcoin.DATABASE.VeritabaniYardimcisi;
import com.example.calcoin.R;

public class MainActivity extends AppCompatActivity {

    EditText userName,password;
    TextView sign;
    Button login;
    VeritabaniYardimcisi vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        tanimla();
        vt= new VeritabaniYardimcisi(this);



    }




    public void signOpen(View view){
        Intent intent=new Intent(MainActivity.this, ActivitySign.class);
        startActivity(intent);

    }

    public void tanimla(){ // kompanetleri tanımlar.
        userName=(EditText)findViewById(R.id.kullaniciadi);
        password=(EditText)findViewById(R.id.sifre);
        login=(Button)findViewById(R.id.girisButon);
        sign=(TextView)findViewById(R.id.Sign);
    }

    public void girisYap(View view){
        KullanicilarDao kullanici=new KullanicilarDao();
        int deger=kullanici.girisSorgula(vt,userName.getText().toString(),password.getText().toString());


        try {/////////

            if(userName.getText().length()!=0 && password.getText().length()!=0){
            if (deger != 0) { // kullanici var ve giriş yapabilir
                Toast.makeText(getApplicationContext(), "Login succesfull!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, ActivityDovizler.class);

                intent.putExtra("gelenAd", userName.getText().toString());

                startActivity(intent);
                userName.setText("");
                password.setText("");


            } else
                Toast.makeText(getApplicationContext(), "User not found!", Toast.LENGTH_LONG).show();
        }
            else
                Toast.makeText(getApplicationContext(), "Missing information!", Toast.LENGTH_LONG).show();

        }
        catch (Exception e){

            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"Database error!",Toast.LENGTH_LONG).show();
        } /////



    }








}

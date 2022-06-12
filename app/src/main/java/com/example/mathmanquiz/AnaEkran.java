package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class AnaEkran extends AppCompatActivity {

    private Button oynaB, puanB, hesabimB, oyunModB;
    private TextView mathT, sesT;
    public String id2, nick2, seviye2, sif2, puan2;
    private sqliteDB v1;
    private Switch s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_ekran);

        v1 = new sqliteDB(this);

        s1 = findViewById(R.id.switch1);
        oyunModB= findViewById(R.id.oyunModB);
        oynaB = findViewById(R.id.oynaB);
        puanB = findViewById(R.id.puanB);
        hesabimB = findViewById(R.id.hesabimB);
        //sessizB = findViewById(R.id.sesB);
        sesT = findViewById(R.id.sesText);
        mathT = findViewById(R.id.mathmanText2);



        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){ String action = "PLAY";
                    Intent myService = new Intent(AnaEkran.this, MuzikServis.class);
                    myService.setAction(action);
                    startService(myService);}
                else {String action = "STOP";
                    Intent myService = new Intent(AnaEkran.this, MuzikServis.class);
                    myService.setAction(action);
                    startService(myService);}
            }
        });

        oynaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AnaEkran.this, ModMenu.class);
                i.putExtra("id3",id2);
                startActivity(i);
            }
        });

        puanB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i = new Intent(AnaEkran.this, ModBilgi.class);
               // startActivity(i);
                Intent i = new Intent(AnaEkran.this, PuanListesi.class);
                startActivity(i);
            }
        });

        oyunModB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AnaEkran.this, ModBilgi.class);
                startActivity(i);
            }
        });



        if (getIntent().getStringExtra("id") != null
        && getIntent().getStringExtra("nick") != null
        && getIntent().getStringExtra("sif") != null
        && getIntent().getStringExtra("seviye") != null
        && getIntent().getStringExtra("puan") != null )  {


            id2 = getIntent().getStringExtra("id");
            sif2 = getIntent().getStringExtra("sif");
            seviye2 = getIntent().getStringExtra("seviye");
            puan2 = getIntent().getStringExtra("puan");
            nick2 = getIntent().getStringExtra("nick");
        }

        hesabimB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = v1.getReadableDatabase();
                String[] sutun = {"id", "nickname", "sifre", "seviye", "puan"};
                Cursor okunanlar = db.query("kullaniciBilgileri", sutun,"id=?", new String[] {id2},null,null,null,null);

                if (okunanlar.moveToFirst()) {
                    do {
                        int id = okunanlar.getInt(0);
                        String nick = okunanlar.getString(1);
                        String sif = okunanlar.getString(2);
                        String seviye = okunanlar.getString(3);
                        int puan = okunanlar.getInt(4);

                        String idSt = Integer.toString(id); String puanSt = Integer.toString(puan);

                        Intent i = new Intent(AnaEkran.this, Bilgilerim.class);
                        i.putExtra("id2",idSt); i.putExtra("nick2",nick);
                        i.putExtra("sif2",sif); i.putExtra("seviye2",seviye);
                        i.putExtra("puan2",puanSt);
                        startActivity(i);
                    }
                    while (okunanlar.moveToNext());

                }    okunanlar.close();





            }
        });

    }
}
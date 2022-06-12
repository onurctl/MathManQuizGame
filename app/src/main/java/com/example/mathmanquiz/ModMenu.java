package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModMenu extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;
    public String id3;

  /*  @Override
    public void onBackPressed() {

        //guncelleme sonrası da mesela anaerkana donunce yenı nick i çekmeli en azından

       return; // BURAYA BUTON FALAN KOYMAMIZ LAZIM AMA VERILERI TUTAR MI GENE BILMIYORUM

        //o kulgiristeki metodu yazman lazim db ile ilgili olan mesela buraya da

        //startActivity(new Intent(ModMenu.this,AnaEkran.class)); // AMA BÖYLE DE ONDEN YUKLENEN VERILERI GETIRMIYOR
    }*/

    // GERIYE BASMAYI IPTAL ETMISTIK ONU DUZENLE GERI ONBACKPRESSED ICINE INTENT KOY

    //buraya bir geri butonu ekle anasayfa için
    //anasayfada da çıkış ekle ayrıca ve bir kez girince log out olmadıkça sorun olmamasını da yap

    //her bir destroy pause aşaması için içerikler yazılmalı, yoksa geri tuşlarına basıldıkça sorun oluyor, geriye basınca her şeyi iptal etmeli vs mesela çalışan

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_menu);



        // OYUNA GİRMEDEN BİR TANITIM MESAJI OYUNDA NE İSTENİYOR ONU ANLATAN VEYA OYUNDA ALTTA AYZSIN VS AMA GİRMEDEN YAZMALI

        //ÇIKIŞ ANA MENU BUTONLARI VS EKLE ÇÜNKÜ GERİYE BASTIKÇA ESK IEKRANALR DA GELIYOR BUNU NASIL HALLEDERIZ???
        // geri butonalrı bunu hallederçıkış butonları vs??

        b1 = findViewById(R.id.buton1);
        b2 = findViewById(R.id.buton2);
        b3 = findViewById(R.id.buton3);
        b4 = findViewById(R.id.buton4);
        b5 = findViewById(R.id.buton5);
        b6 = findViewById(R.id.buton6);
        b7 = findViewById(R.id.buton7);
        b8 = findViewById(R.id.buton8);
        b9 = findViewById(R.id.buton9);

        if (getIntent().getStringExtra("id3") != null )  {
            id3 = getIntent().getStringExtra("id3");
        }

        //

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModMenu.this,MainActivity.class));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModMenu.this,MainActivity2.class));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ModMenu.this,Mod3.class));
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModMenu.this, Mod4.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModMenu.this, Mod5.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(ModMenu.this, Mod6.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModMenu.this, Mod7.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModMenu.this, Mod8.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ModMenu.this, Mod9.class);
                i.putExtra("id3",id3);
                startActivity(i);
            }
        });

    }
}
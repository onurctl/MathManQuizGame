package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Mod7 extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, next, b9, b0, temizleB, eksiB, b6, b7, b8;
    private TextView s1, sonuc, d, y;
    private int num1=0, num2=0, num3=0;
    int dogru2 = 0, yanlis2=0;
    public String id4;
    private sqliteDB v1;
    public int cekilenPuan;
    private ProgressBar bar;

    void dbislem(){

        SQLiteDatabase db = v1.getReadableDatabase();
        String[] sutun = {"id", "nickname", "sifre", "seviye", "puan"};
        Cursor okunanlar = db.query("kullaniciBilgileri", sutun,"id=?", new String[] {id4},null,null,null,null);

        if (okunanlar.moveToFirst()) {

            do {
                cekilenPuan = okunanlar.getInt(4);
                cekilenPuan += (dogru2-yanlis2)*20;
                // puanAlinan+=puan;
                // String puanSt = Integer.toString(puanAlinan);
                // Toast.makeText(getApplicationContext(),"Puan: "+puanSt, Toast.LENGTH_LONG).show();
                //  guncelle(puanSt);

            }
            while (okunanlar.moveToNext());

        }    okunanlar.close();

        SQLiteDatabase db2 = v1.getReadableDatabase();
        //String[] sutun = {"id", "nickname", "sifre", "seviye", "puan"};
        ContentValues contentValues = new ContentValues();
        contentValues.put("puan", String.valueOf(cekilenPuan));
        Cursor okunanlar2 = db2.rawQuery("select*from kullaniciBilgileri where id=?", new String[]{id4});

        if (okunanlar.getCount() > 0) {
            long result = db.update("kullaniciBilgileri", contentValues, "id=?", new String[]{id4});
            if (result == -1) {
                Toast.makeText(getApplicationContext(), "Puan g??ncelleme ba??ar??s??z!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Puan??n??z g??ncellendi!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Puan g??ncelleme ba??ar??s??z", Toast.LENGTH_LONG).show();
        }okunanlar2.close();

    }

    private void loop() {
        // TODO Auto-generated method stub

        handler.postDelayed(new Runnable() {
            public void run() {

                handler.postDelayed(this, 30000);
                dbislem();
                onBackPressed();
            }
        }, 30000);

    }

    Handler handler = new Handler();

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }

    void bar (){
        CountDownTimer ct = new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long l) {
                int current = bar.getProgress()+3;
                if(current > bar.getMax()) current=0;
                bar.setProgress(current);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = findViewById(R.id.bar);
        bar.setProgress(0);         bar.setSecondaryProgress(0);
        bar();

        v1 = new sqliteDB(this);
        loop();
        if (getIntent().getStringExtra("id3") != null )  {
            id4 = getIntent().getStringExtra("id3");
        }


        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        temizleB = findViewById(R.id.temizleButon);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        next = findViewById(R.id.nextButon);

        s1 = findViewById(R.id.textView);
        d = findViewById(R.id.dogruText);
        y = findViewById(R.id.yanlisText);
        sonuc = findViewById(R.id.textView3);
        eksiB = findViewById(R.id.buttonEksi);

        sonuc.setText("");
        d.setText("DO??RU: 0");
        y.setText("YANLI??: 0");
        s1.setText("?");

        baslat();

        eksiB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        sonuc.setText(sonuc.getText() + "-");
        }
        });


        temizleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText("");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "1");

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText(sonuc.getText() + "2");

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText(sonuc.getText() + "3");

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText(sonuc.getText() + "4");

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sonuc.setText(sonuc.getText() + "5");

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "6");

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "7");

            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "8");

            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "9");

            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sonuc.setText(sonuc.getText() + "0");

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sayi = num1 - num2 - num3;
                if (sonuc.getText().equals(Integer.toString(sayi))) {
                    dogru2++;
                    d.setText("DO??RU: " + Integer.toString(dogru2));
                } else yanlis2++;
                y.setText("YANLI??: " + Integer.toString(yanlis2));
                baslat();

            }
        });


    }

    public void baslat() {
        Random myRandom = new Random();
        num1 = myRandom.nextInt(100) + 100;
        num2 = myRandom.nextInt(100) + 100;
        num3 = myRandom.nextInt(100) + 100;

        s1.setText(num1 + " - " + num2 + " - " + num3);

        sonuc.setText("");




    }
}
package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    // mod 2: max iki basamaklı çıkarma

    private Button b1, b2, b3, b4, b5, next, b9, b0, eksiB, temizleB, b6, b7, b8;
    private TextView s1, sonuc, d, y;
    private int num1=0, num2=0;
    int dogru2 = 0, yanlis2=0;     private ProgressBar bar;


    private void loop() {
        // TODO Auto-generated method stub

        handler.postDelayed(new Runnable() {
            public void run() {

                handler.postDelayed(this, 30000);
                Toast.makeText(getApplicationContext(), "Doğru: "+dogru2+"\nYanlış: "+yanlis2, Toast.LENGTH_LONG).show();

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
        loop();

        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b0 = findViewById(R.id.button0);
        eksiB = findViewById(R.id.buttonEksi);
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

        sonuc.setText("");
        d.setText("DOĞRU: 0");
        y.setText("YANLIŞ: 0");
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

                    int sayi = num1 - num2;
                    if (sonuc.getText().equals(Integer.toString(sayi))) {
                        dogru2++;
                        d.setText("DOĞRU: " + Integer.toString(dogru2));
                    } else yanlis2++;
                    y.setText("YANLIŞ: " + Integer.toString(yanlis2));
                    baslat();

            }
        });


    }

    public void baslat() {
        Random myRandom = new Random();
        num1 = myRandom.nextInt(99);
        num2 = myRandom.nextInt(99);

        s1.setText(num1 + " - " + num2);

        sonuc.setText("");


    }
}
package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class AcilisEkrani extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acilis_ekrani);

        String action = "PLAY";
        Intent myService = new Intent(AcilisEkrani.this, MuzikServis.class);
        myService.setAction(action);
        startService(myService);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(AcilisEkrani.this,KullaniciGiris.class));
                finish();
            }
        },3000);

    }
}
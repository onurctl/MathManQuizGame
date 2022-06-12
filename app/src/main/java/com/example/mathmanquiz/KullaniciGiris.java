package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KullaniciGiris extends AppCompatActivity {

    private TextView sifreText, mathmanText, veyaText;
    private Button girisB, uyeOlB;
    private EditText sifreEdit, nickEdit;
    private sqliteDB v1;

    @Override
    public void onBackPressed() {
        String action = "STOP";
        Intent myService = new Intent(KullaniciGiris.this, MuzikServis.class);
        myService.setAction(action);
        startService(myService);
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_giris);

        sifreText = findViewById(R.id.sifremText);
        mathmanText = findViewById(R.id.mathmanText);
        veyaText = findViewById(R.id.veyaText);

        girisB = findViewById(R.id.girisButon);
        uyeOlB = findViewById(R.id.uyeOlButon);

        sifreEdit = findViewById(R.id.sifremEdit);
        nickEdit = findViewById(R.id.nickEdit);

        v1 = new sqliteDB(this);

        uyeOlB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // bilgiGetir();
                startActivity(new Intent(KullaniciGiris.this, KayitOl.class));
            }
        });

        girisB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                bilgiGetir();

            }
        });

    }

    public void bilgiGetir() {

        SQLiteDatabase db = v1.getReadableDatabase();
        String [] sutun={"id", "nickname", "sifre", "seviye", "puan"};
        Cursor okunanlar = db.rawQuery("select * from kullaniciBilgileri"
                         + " where " + "nickname" + " = ? AND " + "sifre" +
                        " = ?", new String[] { nickEdit.getText().toString(), sifreEdit.getText().toString()});
            if (okunanlar.moveToFirst()) {

                do {

    int id = okunanlar.getInt(0);
    String nick = okunanlar.getString(1);
    String sif = okunanlar.getString(2);
    String seviye = okunanlar.getString(3);
    int puan = okunanlar.getInt(4);

    String idSt = Integer.toString(id);
    String puanSt = Integer.toString(puan);

    Intent i = new Intent(KullaniciGiris.this, AnaEkran.class);
    i.putExtra("id",idSt);
    i.putExtra("nick",nick);
    i.putExtra("sif",sif);
    i.putExtra("seviye",seviye);
    i.putExtra("puan",puanSt);
    startActivity(i);
}
                while (okunanlar.moveToNext());
            }
            else
            {Toast.makeText(getApplicationContext(), "Hatalı şifre-nickname kombinasyonu!", Toast.LENGTH_LONG).show(); }
                okunanlar.close();
    }
}



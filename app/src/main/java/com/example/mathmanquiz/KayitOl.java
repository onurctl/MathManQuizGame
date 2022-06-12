package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class KayitOl extends AppCompatActivity {

    // bu alan boş bırakılamaz, burası integer olmalı vs hata mesajları
    private TextView sifre, yas, yenihesap;
    private Button kaydolB;
    private EditText sifreEdit, kulAdEdit;
    private Spinner yasSp;
    private sqliteDB v1;

    public void ekle(String nick, String sifre, String duzey) {
        SQLiteDatabase db = v1.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("nickname", nick);
        cv1.put("sifre", sifre);
        cv1.put("seviye", duzey);
        db.insertOrThrow("kullaniciBilgileri", null, cv1);
        Toast.makeText(getApplicationContext(),"Kayıt başarılı!",Toast.LENGTH_LONG).show();
        Intent i = new Intent(KayitOl.this, KullaniciGiris.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol);

        v1 = new sqliteDB(this);

        sifre = findViewById(R.id.sifreText);
        yas = findViewById(R.id.yasText);
        yenihesap = findViewById(R.id.yeniUyeText);
        kaydolB = findViewById(R.id.kaydolButon);
        sifreEdit = findViewById(R.id.sifreEdit);
        kulAdEdit = findViewById(R.id.kulAdEdit);
        yasSp = findViewById(R.id.yasSpinner);

        kaydolB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(kulAdEdit.getText().toString().equals("") || sifreEdit.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(),"Nickname veya şifre boş bırakılamaz!",Toast.LENGTH_LONG).show();

                    }
                    else {ekle(kulAdEdit.getText().toString(), sifreEdit.getText().toString(), yasSp.getSelectedItem().toString());
                    }
                }
                finally {
                    v1.close();
                }
            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Acemi"); arrayList.add("Çalışkan"); arrayList.add("Tecrübeli"); arrayList.add("Master");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yasSp.setAdapter(arrayAdapter);
        yasSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
}
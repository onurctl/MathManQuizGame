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

public class Bilgilerim extends AppCompatActivity {

    private TextView sifre, yas, yenihesap, puanSeviyeT;
    private Button guncelleB, silB;
    private EditText sifreEdit, kulAdEdit;
    public String sif, kulad, idBilgilerim;
    private Spinner yasSp2;
    private sqliteDB v1;

    void bilgial(String a){
        kulAdEdit.setText(a);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilgilerim);

        v1 = new sqliteDB(this);

        puanSeviyeT = findViewById(R.id.puanSeviyeText);

        sifre = findViewById(R.id.sifreText2);
        yas = findViewById(R.id.yasText2);
        yenihesap = findViewById(R.id.bilgilerimText);

        guncelleB = findViewById(R.id.guncelleB);
        silB = findViewById(R.id.hesapSilB);

        sifreEdit = findViewById(R.id.sifreEdit2);
        kulAdEdit = findViewById(R.id.kulAdEdit2);

        yasSp2 = findViewById(R.id.yasSpinner2);

        guncelleB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sifreEdit.getText().toString().equals("") || kulAdEdit.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Güncelleme başarısız! Kullanıcı adı veya şifre boş bırakılamaz!", Toast.LENGTH_LONG).show();
                } else {

                    SQLiteDatabase db = v1.getReadableDatabase();
                    String[] sutun = {"id", "nickname", "sifre", "seviye", "puan"};
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("nickname", kulAdEdit.getText().toString());
                    contentValues.put("sifre", sifreEdit.getText().toString());
                    contentValues.put("seviye", yasSp2.getSelectedItem().toString());
                    Cursor okunanlar = db.rawQuery("select*from kullaniciBilgileri where id=?", new String[]{idBilgilerim});

                    if (okunanlar.getCount() > 0) {
                        long result = db.update("kullaniciBilgileri", contentValues, "id=?", new String[]{idBilgilerim});
                        if (result == -1) {
                            Toast.makeText(getApplicationContext(), "Güncelleme işlemi başarısız!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Güncelleme işlemi başarılı!", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Güncelleme işlemi başarısız!", Toast.LENGTH_LONG).show();
                    }


                }
            }
        });

        silB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = v1.getReadableDatabase();
                Cursor okunanlar = db.rawQuery("select*from kullaniciBilgileri where id=?", new String[]{idBilgilerim});

                if (okunanlar.getCount() > 0) {
                    long result = db.delete("kullaniciBilgileri", "id=?", new String[]{idBilgilerim});
                    if (result == -1) {
                        Toast.makeText(getApplicationContext(), "Hesap silme işlemi başarısız!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Hesabınız silindi!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Bilgilerim.this, KullaniciGiris.class);
                        startActivity(i);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Hesap silme işlemi başarısız!", Toast.LENGTH_LONG).show();
                }

            }
        });

        if (getIntent().getStringExtra("id2") != null
                && getIntent().getStringExtra("nick2") != null
                && getIntent().getStringExtra("sif2") != null
                && getIntent().getStringExtra("seviye2") != null
                && getIntent().getStringExtra("puan2") != null )  {
           // sif =  getIntent().getStringExtra("sif");
            sifreEdit.setText(getIntent().getStringExtra("sif2"));
            kulAdEdit.setText(getIntent().getStringExtra("nick2"));
            idBilgilerim = getIntent().getStringExtra("id2");

            puanSeviyeT.setText("PUAN: "+getIntent().getStringExtra("puan2")+" - SEVİYE: "+getIntent().getStringExtra("seviye2"));

        }

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Acemi"); arrayList.add("Çalışkan"); arrayList.add("Tecrübeli"); arrayList.add("Master");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yasSp2.setAdapter(arrayAdapter);
        yasSp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PuanListesi extends AppCompatActivity {

    ListView puanListe;
    ArrayList list = new ArrayList();
    ArrayAdapter adapter;
    private sqliteDB v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan_listesi);

        puanListe = findViewById(R.id.puanListe);

        v1 = new sqliteDB(this);

        puanListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(PuanListesi.this, String.valueOf(puanListe.getAdapter().getItem(i)), Toast.LENGTH_SHORT).show();
            }
        });

        showlist();
}

void showlist(){

    list.clear();

    SQLiteDatabase db = v1.getReadableDatabase();
    String [] sutun={"nickname", "puan"};
    String puan="puan";
    Cursor okunanlar = db.query("kullaniciBilgileri", sutun,
            null, null, null, null, puan + " DESC");


    if(okunanlar.getCount() == 0)
    {
        Toast.makeText(PuanListesi.this, "Veri yok!", Toast.LENGTH_SHORT).show();
    }
    while(okunanlar.moveToNext())
    {
        list.add(okunanlar.getString(0)+"\n"+okunanlar.getString(1));

    }
    adapter = new ArrayAdapter(PuanListesi.this,android.R.layout.simple_list_item_1,list);
    puanListe.setAdapter(adapter);

}
}

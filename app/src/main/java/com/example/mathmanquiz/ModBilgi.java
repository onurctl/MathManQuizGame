package com.example.mathmanquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ModBilgi extends AppCompatActivity {

private ListView modListe;
private ArrayAdapter<String> adapter;
private String [] modlar ={"İKİLİ TOPLAMA (SIRADAN)\n\nMaksimum iki basamaklı sayılarla toplama işlemi",
        "İKİLİ ÇIKARMA (SIRADAN)\n\nMaksimum iki basamaklı sayılarla çıkarma işlemi","" +
        "BİRE İKİ ÇARPMA (SIRADAN)\n\nMaksimum iki basamaklı ve maksimum bir basamaklı iki sayının çarpma işlemi",
        "TERSİNİ DÜŞÜN(EH İŞTE)\n\nVerilen iki basamaklı toplama işlemini çıkarma olarak düşün ve sayıların yerlerini değiştir!",
        "ONDALIK ÇIKARMA (EH İŞTE)\n\nOndalıklı sayılarla çıkarma işlemi",
        "ÜÇ BASAMAK TOPLA (EH İŞTE)\n\nİki adet üç basamaklı sayı ile toplama işlemi",
        "ÜÇ BASAMAK ÇIKAR (ZOR)\n\nİki adet üç basamaklı sayı ile çıkarma işlemi",
        "TERSİNİ DÜŞÜN (ZOR)\n\nVerilen üç basamaklı toplama işlemini çıkarma olarak düşün ve sayıların yerlerini değiştir!",
        "ÜÇ SAYI KARMA (ZOR)\n\nÜç adet iki basamaklı sayının toplama ve çıkarma işlemi"
};
private TextView oyunModText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_bilgi);

        oyunModText = findViewById(R.id.oyunModText);
        modListe = findViewById(R.id.puanListe);

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_list,modlar);
        modListe.setAdapter(adapter);
    }
}
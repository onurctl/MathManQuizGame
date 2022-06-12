package com.example.mathmanquiz;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class sqliteDB extends SQLiteOpenHelper {

    public sqliteDB (Context c){
        super(c,"Mathman", null, 1);
    }

    public sqliteDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String sql = "create table kullaniciBilgileri (id integer primary key autoincrement, nickname text not null, " +
            "sifre text not null, seviye text, puan int default 0)";
    db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("drop table if exists kullaniciBilgileri");
    }
}

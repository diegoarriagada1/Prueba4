package com.csto.prueba4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class Dbhelper extends SQLiteOpenHelper {
    public static String Nombre_BD= "censo.db";
    public static int Version_DB=1;
    public static String Tabla_V="create table voto (id_voto integer primary key autoincrement, voto_blanco integer not null, voto_nulo integer not null,voto_boric integer not null, voto_kast integer not null)";

    public Dbhelper(Context context) {
        super(context, Nombre_BD, null, Version_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Tabla_V);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists censo");
        sqLiteDatabase.execSQL(Tabla_V);
    }
}
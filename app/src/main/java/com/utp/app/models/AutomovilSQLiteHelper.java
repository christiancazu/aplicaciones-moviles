package com.utp.app.models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AutomovilSQLiteHelper extends SQLiteOpenHelper {

    public static final String AUTOMOVIL_TABLE = "automovil";

    String sqlCreate =
            "CREATE TABLE automovil(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
            "matricula TEXT," +
            "color TEXT)";

    public AutomovilSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + AUTOMOVIL_TABLE);
        db.execSQL(sqlCreate);
    }

}

package com.utp.app.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.utp.app.entities.Automovil;
import com.utp.app.models.AutomovilSQLiteHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AutomovilService {

    private final String DB_NAME = "db_prueba";

    private AutomovilSQLiteHelper automovilHelper;
    private SQLiteDatabase db;

    private List<Automovil> automoviles;

    public AutomovilService(Context ctx) {
        automoviles = new ArrayList();
        automovilHelper = new AutomovilSQLiteHelper(ctx, DB_NAME, null, 1);
        db = automovilHelper.getWritableDatabase();
    }

    public void create() {
        if (db != null) {
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("matricula", "PER-666");
            nuevoRegistro.put("color", "gray");
            db.insert(AutomovilSQLiteHelper.AUTOMOVIL_TABLE, null, nuevoRegistro);
        }
    }

    public void removeAll() {
        db.delete(AutomovilSQLiteHelper.AUTOMOVIL_TABLE, "", null);
    }

    public void update() {
        automoviles.clear();
        automoviles.addAll(getAll());
    }

    private Collection<Automovil> getAll() {
        Cursor cursor = db.rawQuery("SELECT * FROM " + AutomovilSQLiteHelper.AUTOMOVIL_TABLE, null);
        List<Automovil> currentList = new ArrayList();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                Automovil automovil = new Automovil(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("matricula")),
                        cursor.getString(cursor.getColumnIndex("color"))
                );
                Log.i("getAll", automovil.getMatricula());
                currentList.add(automovil);
                cursor.moveToNext();
            }
        }
        Log.i("getAll - size", String.valueOf(currentList.size()));
        return currentList;
    }

    public void closeDB() {
        db.close();
    }
}

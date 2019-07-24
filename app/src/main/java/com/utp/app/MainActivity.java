package com.utp.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.utp.app.entities.Automovil;
import com.utp.app.models.AutomovilSQLiteHelper;
import com.utp.app.services.AutomovilService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutomovilService automovilService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        automovilService = new AutomovilService(this);
    }

    public void createAutomoviles(View v) {
        automovilService.create();
    }

    public void deleteAutomoviles(View v) {
        automovilService.removeAll();
    }

    public void findAutomoviles(View v) {
        automovilService.update();
    }

    @Override
    protected void onDestroy() {
        automovilService.closeDB();
        super.onDestroy();
    }
}


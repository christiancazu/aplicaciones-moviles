package com.utp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText etValue;
    private TextView tvSharedPreferences, tvInternalStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgetsBinding();
    }

    public void sharedPreferencesOnClickSave(View v) {
        MySharedPreferences.setData(this, etValue.getText().toString());
    }

    public void sharedPreferencesOnClickRead(View v) {
        tvSharedPreferences.setText(MySharedPreferences.getData(this));
    }

    public void internalStorageOnClickSave(View v) throws IOException {
        InternalStorage.setData(this, etValue.getText().toString());
    }

    public void internalStorageOnClickRead(View v) throws IOException {
        tvInternalStorage.setText(InternalStorage.getData(this));
    }

    private void initWidgetsBinding() {
        etValue = findViewById(R.id.et_value);

        tvSharedPreferences = findViewById(R.id.tv_shared_preferences);
        tvInternalStorage = findViewById(R.id.tv_internal_storage);
    }

}

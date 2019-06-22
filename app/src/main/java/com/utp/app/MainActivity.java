package com.utp.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etValue;
    private TextView tvSharedPreferences;
    private final String MY_SHARED_PREFERENCES_DATA = "myData";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.et_value);
        tvSharedPreferences = findViewById(R.id.tv_shared_preferences);

        sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES_DATA, Context.MODE_PRIVATE);
    }

    public void sharedPreferences_OnClickSave(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", etValue.getText().toString());
        editor.commit();
    }

    public void sharedPreferences_OnClickRead(View v) {
        tvSharedPreferences.setText(sharedPreferences.getString("token", ""));
    }
}

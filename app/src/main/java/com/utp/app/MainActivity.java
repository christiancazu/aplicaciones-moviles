package com.utp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etValue;
    private TextView tvSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.et_value);
        tvSharedPreferences = findViewById(R.id.tv_shared_preferences);
    }

    public void sharedPreferences_OnClickSave(View v) {
        MySharedPreferences.setData(this, etValue.getText().toString());
    }

    public void sharedPreferences_OnClickRead(View v) {
        tvSharedPreferences.setText(MySharedPreferences.getData(this));
    }

}

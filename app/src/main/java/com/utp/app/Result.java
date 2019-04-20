package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Result extends AppCompatActivity {

    TextView txtCode, txtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // receiving Intent values from the previous activity
        Intent intent = getIntent();
        // saving in HashMap values passed from the previous activity
        HashMap<String, String> hmResult = (HashMap<String, String>) intent.getSerializableExtra("result");

        // setting TextView variables with ids from activity_result
        txtCode = findViewById(R.id.txv_code);
        txtPwd = findViewById(R.id.txv_pwd);

        // setting TextView text with HashMap values from the previous activity
        txtCode.setText("code: " + hmResult.get("code"));
        txtPwd.setText("password: " + hmResult.get("pwd"));
    }

}

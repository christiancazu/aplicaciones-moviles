package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Authenticate(View v) {
        EditText txtName = findViewById(R.id.txt_name);
        EditText txtPwd = findViewById(R.id.txt_pwd);

        User user = new User(
                txtName.getText().toString(),
                txtPwd.getText().toString());

        Intent intent = new Intent(this, UserData.class);
        intent.putExtra("data", user);
    }
}

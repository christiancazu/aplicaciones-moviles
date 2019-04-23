package com.utp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import models.User;

public class UserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        User user = (User) getIntent().getSerializableExtra("data");

        TextView txtName = findViewById(R.id.txt_data_user);
        TextView txtPwd = findViewById(R.id.tx_data_pwd);

        txtName.setText(user.getName());
        txtPwd.setText(user.getPassword());
    }

}

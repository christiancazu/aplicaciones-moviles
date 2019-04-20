package com.utp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class UserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        User user = (User) getIntent().getParcelableExtra("data");

        TextView txtName = findViewById(R.id.txt_name);
        TextView txtPwd = findViewById(R.id.txt_pwd);

        txtName.setText(user.getName());
        txtPwd.setText(user.getPassword());

        Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();
    }


}

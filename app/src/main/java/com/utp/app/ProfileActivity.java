package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    User user;
    TextView tvName, tvSurname, tvBirthdate, tvLogin, tvPwd;
    ImageButton ibEye;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toastMessage("login successful");

        initUser();
        setDataToActivity();

        initImageButtonListener();
    }

    private void initImageButtonListener() {
        ibEye = findViewById(R.id.ib_eye);

        ibEye.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        tvPwd.setText(user.getPassword());
                        break;
                    case MotionEvent.ACTION_UP:
                        tvPwd.setText("********");
                        break;
                }
                return true;
            }
        });
    }

    private void initUser() {
        user = (User) getIntent().getSerializableExtra("user");
    }

    private void setDataToActivity() {
        tvName = findViewById(R.id.tv_name);
        tvSurname = findViewById(R.id.tv_surname);
        tvBirthdate = findViewById(R.id.tv_birthdate);
        tvLogin = findViewById(R.id.tv_login);
        tvPwd = findViewById(R.id.tv_pwd);

        tvName.setText(user.getName());
        tvSurname.setText(user.getSurname());
        tvBirthdate.setText(user.getBirthdate());
        tvLogin.setText(user.getLogin());
        // tvPwd.setText(user.getPassword());
    }

    private void toastMessage(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}

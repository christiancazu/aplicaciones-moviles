package com.utp.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ProfileActivity extends AppCompatActivity {

    User user;
    TextView tvName, tvSurname, tvBirthdate, tvLogin, tvPwd;
    ImageButton ibEye;
    Toast toast;

    ImageView ivProfile;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivProfile = findViewById(R.id.iv_profile);

        toastMessage("The session has been initialize!");

        initUser();
        setDataToActivity();

        initImageButtonListener();

        loadImageProfileFromStorage();
    }

    private void loadImageProfileFromStorage() {
        File file =new File(StorageManager.PATH_STORAGE, "profile.jpg");
        Bitmap b = null;
        try {
            b = BitmapFactory.decodeStream(new FileInputStream(file));
            ivProfile.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            ivProfile.setImageResource(R.drawable.fallback);
            e.printStackTrace();
        }
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

    public void onClickTestament(View v) {
        intent = new Intent(this, TestamentActivity.class);
        startActivity(intent);
    }

    public void logOutOnClick(View v) {
        MySharedPreferences.purgeToken(this);

        redirectToLogin();
    }

    private void redirectToLogin() {
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void toastMessage(String msg) {
        if (toast == null) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}

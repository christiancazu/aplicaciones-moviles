package com.utp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.utp.app.model.User;

public class UserActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        initUser();
    }

    private void initUser() {

        user = new User("Christian", 25);

        ((Global) this.getApplication()).setUser(user);
    }
}

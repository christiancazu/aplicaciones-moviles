package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.utp.app.model.User;

public class MainActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUser();
    }

    private void initUser() {

        user = new User("Christian", 25);

        ((Global) this.getApplication()).setUser(user);
    }

    public void goToPlayList(View v) {
        Intent intent = new Intent(this, PlayList.class);
        startActivity(intent);
    }

    public void goToMyPlayList(View v) {
        Intent intent = new Intent(this, MyPlayList.class);
        startActivity(intent);
    }
}

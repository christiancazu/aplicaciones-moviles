package com.utp.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.utp.app.models.User;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        User user = ((Global) this.getApplication()).getUser();

        Toast.makeText(this, user.getCode(), Toast.LENGTH_SHORT).show();
    }
}

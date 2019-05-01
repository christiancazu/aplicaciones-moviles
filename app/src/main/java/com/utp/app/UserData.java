package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.utp.app.models.User;

public class UserData extends Activity {

    TextView txvUser, txvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        User user = ((Global) this.getApplication()).getUser();

        txvUser = findViewById(R.id.txv_user);
        txvCode = findViewById(R.id.txv_code);

        txvUser.setText(user.fullName());
        txvCode.setText(user.getCode());
    }

    public void goToLogin(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}

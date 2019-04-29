package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.utp.app.models.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assistance extends Activity {

    User user;
    TextView txvUser, txvAssist, txvcurrentAction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        user = ((Global) this.getApplication()).getUser();

        txvUser = findViewById(R.id.txv_user);
        txvcurrentAction = findViewById(R.id.txv_currentAction);
        txvAssist = findViewById(R.id.txv_assist);

        // toastMessage(getResources().getString(R.string.assist_success));

        txvUser.setText(user.fullName());
        txvcurrentAction.setText(getIntent().getStringExtra("message") + " on:");
        txvAssist.setText(dateFormat.format(date));
    }

    public void goBack(View v) {
        i = new Intent(this, Home.class);
        startActivity(i);
    }

}

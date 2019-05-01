package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.utp.app.models.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Assistance extends Activity {

    TextView txvUser, txvAssist, txvCurrentAction;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistance);

        User user = ((Global) this.getApplication()).getUser();

        txvUser = findViewById(R.id.txv_user);
        txvCurrentAction = findViewById(R.id.txv_currentAction);
        txvAssist = findViewById(R.id.txv_assist);

        Toast.makeText(this,
                getIntent().getStringExtra("message") + " registered",
                Toast.LENGTH_SHORT)
                .show();

        txvUser.setText(user.fullName());
        txvCurrentAction.setText(getIntent().getStringExtra("message") + " registered on:");
        txvAssist.setText(dateFormat.format(date));
    }

    public void goBack(View v) {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

}

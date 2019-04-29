package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.utp.app.models.User;

public class MainActivity extends Activity {

    Intent i;
    EditText txtCode, txtPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Global) this.getApplication()).setUser(new User("ga", "ge"));
    }

    public void signIn(View v) {
        i = new Intent(this, Home.class);
        startActivity(i);
        /*authUser = new User(txtCode.getText().toString(), txtPwd.getText().toString());
        if (user != null && validateCredentials()) {
            toastMessage(getResources().getString(R.string.access_success));
            i = new Intent(this, Home.class);
            i.putExtra("user", user);
            startActivity(i);
        } else {
            toastMessage(getResources().getString(R.string.access_denied));
        }*/
    }

}

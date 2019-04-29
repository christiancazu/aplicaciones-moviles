package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.utp.app.models.User;

public class MainActivity extends Activity {

    Intent i;
    EditText etxCode, etxPwd;
    User user, authUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user =  ((Global) this.getApplication()).getUser();

        etxCode = findViewById(R.id.etx_code);
        etxPwd = findViewById(R.id.etx_pwd);
    }

    public void signIn(View v) {

        authUser = new User(etxCode.getText().toString(), etxPwd.getText().toString());

        if (user != null && validateCredentials()) {
            toastMessage(getResources().getString(R.string.access_success));
            redirectToHome();
        } else {
            toastMessage(getResources().getString(R.string.access_denied));
        }
    }

    public void signUp(View v) {

        i = new Intent(this, Register.class);
        startActivity(i);
    }

    protected boolean validateCredentials() {

        return
            user.getCode().equals(authUser.getPassword()) &&
            user.getPassword().equals(authUser.getPassword());
    }

    protected void redirectToHome() {

        i = new Intent(this, Home.class);
        startActivity(i);
    }

    protected void toastMessage(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

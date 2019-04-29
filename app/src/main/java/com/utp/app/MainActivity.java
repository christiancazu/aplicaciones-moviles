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
    User user;
    String strCode, strPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = ((Global) this.getApplication()).getUser();

        etxCode = findViewById(R.id.etx_code);
        etxPwd = findViewById(R.id.etx_pwd);
    }

    public void signIn(View v) {
        strCode = etxCode.getText().toString();
        strPwd = etxPwd.getText().toString();

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
            user.getCode().equals(strCode) &&
            user.getPassword().equals(strPwd);
    }

    protected void redirectToHome() {
        i = new Intent(this, Home.class);
        startActivity(i);
    }

    protected void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

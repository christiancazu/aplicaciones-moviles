package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.utp.app.models.User;

public class Register extends Activity {

    EditText etxCode, etxPwd;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etxCode = findViewById(R.id.etx_code);
        etxPwd = findViewById(R.id.etx_pwd);
    }

    public void signUp(View v) {

        User user = new User(
                etxCode.getText().toString(),
                etxPwd.getText().toString());

        ((Global) this.getApplication()).setUser(user);

        Toast.makeText(
                this,
                getResources().getString(R.string.register_success),
                Toast.LENGTH_SHORT)
                .show();

        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}

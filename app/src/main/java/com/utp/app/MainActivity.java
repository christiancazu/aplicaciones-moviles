package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtCode, txtPwd;
    String strCode, strPwd, appCode = "christian", appPwd = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCode = findViewById(R.id.txt_code);
        txtPwd = findViewById(R.id.txt_pwd);
    }

    public void authenticate(View v) {
        strCode = txtCode.getText().toString();
        strPwd = txtPwd.getText().toString();

        if (validateCredentials()) {
            Intent aResult = new Intent(this, Result.class);
            aResult.putExtra("result", strCode);
            startActivity(aResult);
        } else {
            // Toast.makeText(this, getResources().getString(R.string.access_denied), Toast.LENGTH_SHORT).show();
            Intent aDenied = new Intent(this, Denied.class);
            aDenied.putExtra("result", strCode);
            startActivity(aDenied);
        }
    }

    protected boolean validateCredentials() {
        return strCode.equals(appCode) && strPwd.equals(appPwd);
    }
}

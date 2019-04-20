package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // declaring variables
    Button btnJoin;
    EditText txtCode, txtPwd;
    Intent intent;
    String appCode = "christian",
            appPwd = "123456";
    HashMap<String, String> credentials = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting TextView variables with ids from activity_main
        txtCode = findViewById(R.id.txt_code);
        txtPwd = findViewById(R.id.txt_pwd);

        // setting Button variable with id from activity_main
        btnJoin = findViewById(R.id.btn_join);
        // initialize Button disabled
        btnJoin.setEnabled(false);

        // initialize EditText txtCode with his text change listener
        loadTxtCodeListener();
    }

    /**
     * called by onClick event Button with @+id/btn_join from form_layout
     * redirected to new activity depending if credentials are corrects
     *
     * @param v
     */
    public void authenticate(View v) {
        // setting HashMap credentials with EditText values
        credentials.put("code", txtCode.getText().toString());
        credentials.put("pwd", txtPwd.getText().toString());

        // setting Intent depending of value returned from validateCredentials()
        if (validateCredentials()) {
            toastMessage(getResources().getString(R.string.access_success));
            intent = new Intent(this, Result.class);
            intent.putExtra("result", credentials);
        } else {
            toastMessage(getResources().getString(R.string.access_denied));
            intent = new Intent(this, Denied.class);
            intent.putExtra("result", credentials.get("code"));
        }

        // starting new activity
        startActivity(intent);
    }

    /**
     * validate credentials if are equals to appCode & appPwd
     *
     * @return boolean
     */
    protected boolean validateCredentials() {
        return appCode.equals(credentials.get("code")) && appPwd.equals(credentials.get("pwd"));
    }

    /**
     * clean input fields to empty values & set focus to txtCode
     *
     * @param v
     */
    public void cleanFields(View v) {
        txtCode.setText("");
        txtPwd.setText("");
        txtCode.requestFocus();
    }

    /**
     * show Toast message
     *
     * @param msg
     */
    protected void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * txtCode text changes listener
     *
     */
    protected void loadTxtCodeListener() {
        txtCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnJoin.setEnabled(txtCode.getText().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

}

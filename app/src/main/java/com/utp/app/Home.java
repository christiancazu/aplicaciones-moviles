package com.utp.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity {

    Intent i;
    Button btnRegister;
    TextView txvUser;
    boolean isAssistRegistered, isExitRegistered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        isAssistRegistered = ((Global) this.getApplication()).isAssistRegistered();
        isExitRegistered = ((Global) this.getApplication()).isExitRegistered();

        btnRegister = findViewById(R.id.btn_register);
        txvUser = findViewById(R.id.tvw_user);

        setTxvUser();
        loadBtnRegister();
    }

    public void registerAction(View v) {
        i = new Intent(this, Assistance.class);

        i.putExtra("message",
                isAssistRegistered ? "Exit" : "Assist");

        setRegisterAction();
        startActivity(i);
    }

    protected void loadBtnRegister() {
        if (isExitRegistered) {
            btnRegister.setVisibility(View.INVISIBLE);
            return;
        }

        btnRegister.setText(getResources().getText(
            isAssistRegistered
                ? R.string.btn_register_exit_time
                : R.string.btn_register_assist_time));
    }

    protected void setRegisterAction() {
        if (!isAssistRegistered) {
            ((Global) this.getApplication()).setAssistRegistered(true);
        } else {
            ((Global) this.getApplication()).setExitRegistered(true);
        }
    }

    public void logOut(View v) {
        toastMessage(getResources().getText(R.string.logout_success).toString());
        i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    protected void setTxvUser() {
        txvUser.setText(((Global) this.getApplication()).getUser().fullName());
    }

    protected void toastMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}

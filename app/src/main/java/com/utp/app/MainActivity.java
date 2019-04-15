package com.utp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declaring variables
    private TextView txv;
    private boolean switcher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting txv with the id assigned in activity_main.xml
        txv = findViewById(R.id.txvMessage);
    }

    /**
     * method called when event onClick is launched from button on activity_main.xml
     *
     * @param foo
     */
    protected void onClickBtn(View foo) {

        // sending current boolean value of switcher parsed to string
        showToast(Boolean.toString(switcher));

        // setting TextView message depending on switcher boolean value
        // string message comes from res/values/strings.xml
        txv.setText(switcher
                ? getResources().getString(R.string.switcher_message_true)
                : getResources().getString(R.string.switcher_message_false));

        // switching current boolean value to his inverse
        switcher = !switcher;
    }

    /**
     * to show Toast message on screen
     *
     * @param message
     */
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /*-----------------------
    |   Overriding methods  |
    ------------------------*/
    @Override
    protected void onStart() {
        showToast("app is onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        showToast("app is onRestart");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        showToast("app is onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        showToast("app is onResume");
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        showToast("app is onDestroy");
        super.onDestroy();
    }
}

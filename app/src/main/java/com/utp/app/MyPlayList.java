package com.utp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.utp.app.model.Song;
import com.utp.app.model.User;

import java.util.ArrayList;
import java.util.List;

public class MyPlayList extends AppCompatActivity {

    TextView stringTextView;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        stringTextView = findViewById(R.id.textView2);

        user = ((Global) this.getApplication()).getUser();

        ArrayList<String> stringData = new ArrayList<String>();

        //user.getSongs();

        // Toast.makeText(this, user.getName(), Toast.LENGTH_SHORT).show();

        for (String song : user.getSongs()) {
            stringData.add(song);
        }

       /*

        stringData.add("ONE");
        stringData.add("TWO");
        stringData.add("THREE");
        stringData.add("Four");
        stringData.add("Five");
        stringData.add("Six");
        stringData.add("Seven");*/

        for(int i=0; i < stringData.size(); i++){

            stringTextView.setText(stringTextView.getText() + stringData.get(i) + " , ");
        }
    }
}

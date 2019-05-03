package com.utp.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView userList;
    private List<User> users;
    public UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = findViewById(R.id.rvw_users);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        userList.setLayoutManager(llm);

        initData();
        initUserAdapter();
    }

    private void initData() {
        users = new ArrayList<>();
        users.add(new User("aaaa", "c"));
        users.add(new User("wwww", "bbcbbb"));
        users.add(new User("qqqq", "b"));
        users.add(new User("bbbb", "z"));
        users.add(new User("dddd", "bbbbb"));
        users.add(new User("eeee", "aaa"));
        users.add(new User("bbbb", "x"));
        users.add(new User("aaaa", "c"));
        users.add(new User("wwww", "bbcbbb"));
        users.add(new User("qqqq", "b"));
        users.add(new User("bbbb", "z"));
        users.add(new User("dddd", "bbbbb"));
        users.add(new User("eeee", "aaa"));
        users.add(new User("bbbb", "x"));
    }

    private void initUserAdapter() {
        userAdapter = new UserAdapter(users);
        userList.setAdapter(userAdapter);
    }


}

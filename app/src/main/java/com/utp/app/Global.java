package com.utp.app;

import android.app.Application;

import com.utp.app.model.User;

public class Global extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.utp.app;

import android.app.Application;

import com.utp.app.models.User;

public class Global extends Application {
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

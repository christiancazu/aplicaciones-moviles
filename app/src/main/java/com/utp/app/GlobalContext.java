package com.utp.app;

import android.app.Application;

public class GlobalContext extends Application {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

package com.utp.app;

import android.app.Application;

import com.utp.app.models.User;

public class Global extends Application {
    private User user;
    private boolean isAssistRegistered = false;
    private boolean isExitRegistered = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAssistRegistered() {
        return isAssistRegistered;
    }

    public void setAssistRegistered(boolean assistRegistered) {
        this.isAssistRegistered = assistRegistered;
    }

    public boolean isExitRegistered() {
        return isExitRegistered;
    }

    public void setExitRegistered(boolean exitRegistered) {
        isExitRegistered = exitRegistered;
    }

}

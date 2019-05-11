package com.utp.app.model;

import java.io.Serializable;

public class Song implements Serializable {

    private String name;
    private long duration;

    public Song(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    // return in mm:ss format
    public String getDuration() {
        long minutes = (duration / 1000) / 60;
        long seconds = (duration / 1000) % 60;
        return minutes + ":" + seconds;
    }

}

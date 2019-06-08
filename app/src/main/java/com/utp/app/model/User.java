package com.utp.app.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private int age;
    private ArrayList<String> songs;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSong(String song) {
        this.songs.add(song);
    }
}

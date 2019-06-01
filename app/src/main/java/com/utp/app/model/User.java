package com.utp.app.model;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name;
    private int edad;
    private ArrayList<String> songs;

    public User(String name, int edad) {
        this.name = name;
        this.edad = edad;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSong(String song) {
        this.songs.add(song);
    }
}

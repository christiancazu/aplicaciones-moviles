package com.utp.app.models;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {
    private String name;
    private String surname;
    private String code;
    private String password;

    public User(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        generateCode();
    }

    public String getCode() { return code; }

    public String getPassword() {
        return password;
    }

    private void generateCode() {
        Random r = new Random();
        int result = r.nextInt(9999 - 1000) + 1000;
        code = Integer.toString(result);
    }

    public String fullName() {
        return name + " " + surname;
    }
}

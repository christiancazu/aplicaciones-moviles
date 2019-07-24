package com.utp.app.entities;

import java.io.Serializable;

public class Automovil implements Serializable {

    private int id;
    private String matricula, color;

    public Automovil(int id, String matricula, String color) {
        this.id = id;
        this.matricula = matricula;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}

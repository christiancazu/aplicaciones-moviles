package com.utp.app;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GlobalContext extends Application {
    private List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno alumno) {
        this.alumnos.add(alumno);
    }
}

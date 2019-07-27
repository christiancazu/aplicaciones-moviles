package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etAge, etSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.et_name);
        etSex = findViewById(R.id.et_sex);
        etAge = findViewById(R.id.et_age);
    }

    public void onClickRegisterUser(View v) {
        Alumno alumno = new Alumno();
        alumno.setNombre(etName.getText().toString());
        alumno.setSexo(etSex.getText().toString());
        alumno.setEdad(Integer.parseInt(etAge.getText().toString()));

        ((GlobalContext) this.getApplication()).setAlumnos(alumno);

        Alumno a = ((GlobalContext) this.getApplication()).getAlumnos().get(0);

        Toast.makeText(this,"alumno was added", Toast.LENGTH_SHORT).show();
    }

    public void onClickGoBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

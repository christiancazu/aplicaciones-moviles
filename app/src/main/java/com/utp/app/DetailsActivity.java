package com.utp.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    TextView tvName, tvSex, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int index = getIntent().getIntExtra("index", 0);

        tvName = findViewById(R.id.tv_name);
        tvSex = findViewById(R.id.tv_sex);
        tvAge = findViewById(R.id.tv_age);

        Alumno alumno = ((GlobalContext) this.getApplicationContext()).getAlumnos().get(index);

        tvName.setText(alumno.getNombre());
        tvSex.setText(alumno.getSexo());
        tvAge.setText(Integer.toString(alumno.getEdad()));

    }

    public void onClickGoBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

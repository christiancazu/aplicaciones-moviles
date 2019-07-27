package com.utp.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Alumno> alumnos = new ArrayList<>();

    RecyclerView rvSongs;
    AlumnoAdapter alumnoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // loadAlumnos();

        alumnos = ((GlobalContext) this.getApplication()).getAlumnos();

        rvSongs = findViewById(R.id.rv_songs);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvSongs.setLayoutManager(llm);

        initAlumnoAdapter();
    }

    private void initAlumnoAdapter() {
        alumnoAdapter = new AlumnoAdapter(alumnos);
        rvSongs.setAdapter(alumnoAdapter);
    }

    public void selectSong(View v) {
        int itemPosition = rvSongs.getChildViewHolder(v).getAdapterPosition();

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("index", itemPosition);
        startActivity(intent);
    }

    private void loadAlumnos() {
        TextView stringTextView = findViewById(R.id.textView2);

        List<Alumno> alumnos = ((GlobalContext) this.getApplication()).getAlumnos();

        ArrayList<String> stringData = new ArrayList<>();

        for (Alumno alumno : alumnos) {
            stringData.add(alumno.getNombre());
        }

        for(int i=0; i < stringData.size(); i++) {
            stringTextView.setText(stringTextView.getText() + stringData.get(i) + " , ");
        }
    }

    public void onClickRegister(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}

package com.utp.app;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<Alumno> alumnos;

    public AlumnoAdapter(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // return null;
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alumno_card, viewGroup, false);
        return new AlumnoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder AlumnoViewHolder, int i) {
        Alumno alumno = alumnos.get(i);
        AlumnoViewHolder.txvName.setText(alumno.getNombre());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public static class AlumnoViewHolder extends ViewHolder {

        private TextView txvName, txvSurname;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);

            txvName = itemView.findViewById(R.id.tv_song_name);
        }
    }
}

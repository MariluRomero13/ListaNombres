package com.example.listanombres.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.listanombres.R;
import com.example.listanombres.modelos.Alumno;

import java.util.List;

public class adaptadorAlumnos   extends RecyclerView.Adapter<adaptadorAlumnos.ViewHolder>  {

    private List<Alumno> alumnos;

    public adaptadorAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_nombres, viewGroup, false);
        ViewHolder vh = new ViewHolder(vista);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.id.setText(alumnos.get(i).getId().toString());
        viewHolder.nombre.setText(alumnos.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return alumnos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView id;

        public ViewHolder(View vista)
        {
            super(vista);
            id = vista.findViewById(R.id.tvid);
            nombre = vista.findViewById(R.id.tvnombre);
        }

    }
}

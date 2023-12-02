package com.example.myapps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {

    private List<Usuario> usuariosList;

    public UsuarioAdapter(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuariosList.get(position);
        holder.nombreTextView.setText(usuario.getNombre());
        holder.apellidoTextView.setText(usuario.getApellido());
        holder.fechaTextView.setText(usuario.getFecha());
    }
    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuariosList.get(position);

        // Convertir los valores de nombre y apellido a enteros (suponiendo que contienen valores numéricos)
        int nombre = Integer.parseInt(usuario.getNombre());
        int apellido = Integer.parseInt(usuario.getApellido());

        // Calcular la suma
        int suma = nombre + apellido;

        // Establecer el texto en el TextView
        holder.nombreTextView.setText("Suma: " + String.valueOf(suma));
        holder.apellidoTextView.setText("");  // Puedes dejar esto en blanco o agregar otro valor si lo deseas
        holder.fechaTextView.setText("");  // Puedes dejar esto en blanco o agregar otro valor si lo deseas
    }


    @Override
    public int getItemCount() {
        return usuariosList.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView nombreTextView, apellidoTextView, fechaTextView;

        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
            apellidoTextView = itemView.findViewById(R.id.apellidoTextView);
            fechaTextView = itemView.findViewById(R.id.fechaTextView);
        }
    }
}



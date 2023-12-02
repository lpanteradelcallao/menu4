package com.example.myapps;

public class Usuario {

    private String nombre;
    private String apellido;
    private String fecha;

    // Constructor vacío requerido por Firebase
    public Usuario() {}

    public Usuario(String nombre, String apellido, String fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFecha() {
        return fecha;
    }
}

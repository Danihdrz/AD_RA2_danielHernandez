package org.example.model;

public class Libro {
    private int id;
    private String nombre;

    public Libro() {
    }

    public Libro(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }


    public String toString() {
        return "Clo{id=" + this.id + ", nombre='" + this.nombre + "}";
    }
}

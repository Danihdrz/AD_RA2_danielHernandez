package org.example.model;

public class Cliente {
    private int id;
    private String nombre;

    public Cliente() {
    }

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return "Cliente{id=" + this.id + ", nombre=" + this.nombre + " }";
    }
}

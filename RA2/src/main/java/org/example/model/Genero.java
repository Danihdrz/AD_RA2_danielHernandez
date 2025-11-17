package org.example.model;

public class Genero {
    private String nombre_genero;

    public Genero() {
    }

    public Genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }


    public String getnombre_genero() {
        return this.nombre_genero;
    }

    public void setnombre_genero(String nombre_genero) {
        this.nombre_genero = nombre_genero;
    }

    public String toString() {
        return "Genero{nombre=" + this.nombre_genero + "}";
    }
}


package org.example.model;

public class Pedido {
    private int id;
    private int id_libro;
    private int id_cliente;
    private String genero_libro;

    public Pedido() {
    }

    public Pedido(int id, int id_libro, int id_cliente, String genero_libro) {
        this.id = id;
        this.id_libro = id_libro;
        this.id_cliente = id_cliente;
        this.genero_libro = genero_libro;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getid_libro() {
        return this.id_libro;
    }

    public void setid_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getid_cliente() {
        return this.id_cliente;
    }

    public void setid_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getgenero_libro() {
        return this.genero_libro;
    }

    public void setgenero_libro(String genero_libro) {
        this.genero_libro = genero_libro;
    }

    public String toString() {
        return "Pedido{id=" + this.id + ", id_libro=" + this.id_libro + ", id_cliente=" + this.id_cliente + ", genero_libro= " + this.genero_libro + " }";
    }
}

package org.example;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.example.dao.GeneroDAO;
import org.example.dao.LibroDAO;
import org.example.dao.PedidoDAO;
import org.example.model.Genero;
import org.example.model.Libro;


public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAO();
        GeneroDAO generoDAO = new GeneroDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        Libro e1 = new Libro(2, "Luis");
        int id1 = libroDAO.crear(e1);
        System.out.println("Empleados creados con IDs: " + id1 + " .");
        Genero p1 = new Genero("terror");
        int pid1 = GeneroDAO.crear(p1);
        System.out.println("Proyectos creados con IDs: " + pid1 + ".");
        List<Libro> libro = libroDAO.obtenerTodos();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        libro.forEach(var10001::println);
        List<Genero> proyectos = GeneroDAO.obtenerTodos();
    }
}

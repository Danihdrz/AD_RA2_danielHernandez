package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.config.DatabaseConfig;
import org.example.model.Pedido;

public class PedidoDAO {
    public int crear(Connection conn, int id_libro, int id_cliente, String genero_libro) throws SQLException {
        String sql = "INSERT INTO asignaciones (empleado_id, proyecto_id) VALUES (?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql, 1)) {
            stmt.setInt(1, id_libro);
            stmt.setInt(2, id_cliente);
            stmt.setString(3, genero_libro);

            int filas = stmt.executeUpdate();
            if (filas == 0) {
                byte var14 = -1;
                return var14;
            }

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    int var8 = keys.getInt(1);
                    return var8;
                }
            }
        }

        return -1;
    }

    public int crear(int id_libro, int id_cliente, String genero_libro) {
        try (Connection conn = DatabaseConfig.getConnection()) {
            return this.crear(conn, id_libro, id_cliente, genero_libro);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Pedido> obtenerTodos() {
        List<Pedido> lista = new ArrayList();
        String sql = "SELECT * FROM libro";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {
            while(rs.next()) {
                lista.add(new Pedido(rs.getInt("id"), rs.getInt("id_libro"), rs.getInt("id_Cliente"), rs.getString("genero_libro")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Pedido WHERE id = ?";

        try {
            boolean var5;
            try (
                    Connection conn = DatabaseConfig.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql);
            ) {
                stmt.setInt(1, id);
                var5 = stmt.executeUpdate() > 0;
            }

            return var5;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Pedido> obtenerPorLibro(int id_libro) {
        List<Pedido> lista = new ArrayList();
        String sql = "SELECT * FROM Pedido WHERE id_libro = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id_libro);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    lista.add(new Pedido(rs.getInt("id"), rs.getInt("id_libro"), rs.getInt("id_cliente"), rs.getString("genero_libro")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Pedido> obtenerPorCliente(int id_cliente) {
        List<Pedido> lista = new ArrayList();
        String sql = "SELECT * FROM pedido WHERE id_cliente = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id_cliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    lista.add(new Pedido(rs.getInt("id"), rs.getInt("id_libro"), rs.getInt("id_cliente"), rs.getString("genero_libro")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<Pedido> obtenerPorGenero(int genero_libro) {
        List<Pedido> lista = new ArrayList();
        String sql = "SELECT * FROM pedido WHERE genero_libro = ?";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, genero_libro);

            try (ResultSet rs = stmt.executeQuery()) {
                while(rs.next()) {
                    lista.add(new Pedido(rs.getInt("id"), rs.getInt("id_libro"), rs.getInt("id_cliente"), rs.getString("genero_libro")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}


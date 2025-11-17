package org.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.config.DatabaseConfig;
import org.example.model.Genero;

public class GeneroDAO {
    public static int crear(Genero genero) {
        String sql = "INSERT INTO genero (nombre_genero) VALUES (?)";

        try {
            byte var6;
            try (
                    Connection conn = DatabaseConfig.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql, 1);
            ) {
                stmt.setString(1, genero.getnombre_genero());
                int filas = stmt.executeUpdate();
                if (filas != 0) {
                    try (ResultSet keys = stmt.getGeneratedKeys()) {
                        if (keys.next()) {
                            int var7 = keys.getInt(1);
                            return var7;
                        }

                        return -1;
                    }
                }

                var6 = -1;
            }

            return var6;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static List<Genero> obtenerTodos() {
        List<Genero> lista = new ArrayList();
        String sql = "SELECT * FROM genero";

        try (
                Connection conn = DatabaseConfig.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }


    public boolean actualizar(Genero genero) {
        String sql = "UPDATE libro SET nombre=? WHERE id=?";

        try {
            boolean var5;
            try (
                    Connection conn = DatabaseConfig.getConnection();
                    PreparedStatement stmt = conn.prepareStatement(sql);
            ) {
                stmt.setString(1, genero.getnombre_genero());
                var5 = stmt.executeUpdate() > 0;
            }

            return var5;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM genero WHERE id=?";

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

    private Genero mapearProyecto(ResultSet rs) throws SQLException {
        return new Genero(rs.getString("nombre"));
    }
}

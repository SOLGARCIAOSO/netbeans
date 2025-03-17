package Servicios;

import DB.BaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import Modelos.Juego;
import Modelos.Categoria;

public class JuegoServicio {

    public void agregarJuego(Juego juego) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "INSERT INTO juegos (nombre, categoria_id, fechaLanzamiento, precio, desarrollador, descripcion, rating) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, juego.getNombre());
            stmt.setInt(2, juego.getCategoria().getIdCategoria()); // Usar el ID correcto de la categoría
            stmt.setDate(3, new java.sql.Date(juego.getFechaLanzamiento().getTime()));
            stmt.setDouble(4, juego.getPrecio());
            stmt.setString(5, juego.getDesarrollador());
            stmt.setString(6, juego.getDescripcion());
            stmt.setDouble(7, juego.getRating());

            stmt.executeUpdate();
            System.out.println("El juego se registró correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar el juego " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void eliminarJuego(int idJuego) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "DELETE FROM juegos WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idJuego);
            stmt.executeUpdate();
            System.out.println("El juego se eliminó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar el juego " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void editarJuego(Juego juego) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "UPDATE juegos SET nombre = ?, categoria_id = ?, fechaLanzamiento = ?, precio = ?, desarrollador = ?, descripcion = ?, rating = ? WHERE idJuego = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, juego.getNombre());
            stmt.setInt(2, juego.getCategoria().getIdCategoria()); // Usar ID correcto de la categoría
            stmt.setDate(3, new java.sql.Date(juego.getFechaLanzamiento().getTime()));
            stmt.setDouble(4, juego.getPrecio());
            stmt.setString(5, juego.getDesarrollador());
            stmt.setString(6, juego.getDescripcion());
            stmt.setDouble(7, juego.getRating());
            stmt.setInt(8, juego.getIdJuego()); // Usar idJuego en lugar de id

            stmt.executeUpdate();
            System.out.println("El juego se editó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar el juego " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void mostrarJuegos() {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "SELECT j.id AS idJuego, j.nombre, c.id AS idCategoria, c.nombre AS nombreCategoria, " +
                     "j.fecha_lanzamiento, j.precio, j.desarrollador, j.descripcion, j.rating " +
                     "FROM juegos j INNER JOIN categorias c ON j.categoria_id = c.id";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int idJuego = rs.getInt("idJuego");
                String nombre = rs.getString("nombre");
                int idCategoria = rs.getInt("idCategoria");
                String nombreCategoria = rs.getString("nombreCategoria");
                Date fechaLanzamiento = rs.getDate("fecha_lanzamiento");
                double precio = rs.getDouble("precio");
                String desarrollador = rs.getString("desarrollador");
                String descripcion = rs.getString("descripcion");
                double rating = rs.getDouble("rating");

                System.out.println("Juego ID: " + idJuego);
                System.out.println("Nombre: " + nombre);
                System.out.println("Categoría: " + nombreCategoria + " (ID: " + idCategoria + ")");
                System.out.println("Fecha de Lanzamiento: " + fechaLanzamiento);
                System.out.println("Precio: " + precio);
                System.out.println("Desarrollador: " + desarrollador);
                System.out.println("Descripción: " + descripcion);
                System.out.println("Rating: " + rating);
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar juegos " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }
}

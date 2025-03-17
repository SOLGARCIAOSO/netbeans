package Servicios;

import DB.BaseDeDatos;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServicio {

    public void agregarUsuario(Usuario usuario) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "INSERT INTO usuarios (nombre, correo, password, fecha_registro) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getPassword());
            stmt.setDate(4, new java.sql.Date(usuario.getFechaRegistro().getTime()));

            stmt.executeUpdate();
            System.out.println("El usuario se registró correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar el usuario " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void eliminarUsuario(int id) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("El usuario se eliminó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar el usuario " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void editarUsuario(Usuario usuario) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "UPDATE usuarios SET nombre = ?, correo = ?, password = ?, fecha_registro = ? WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getPassword());
            stmt.setDate(4, new java.sql.Date(usuario.getFechaRegistro().getTime()));
            stmt.setInt(5, usuario.getId());

            stmt.executeUpdate();
            System.out.println("El usuario se editó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar el usuario " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void mostrarUsuarios() {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = mapearUsuario(rs);
                System.out.println(usuario);
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar usuarios " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario usuario = null;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    usuario = mapearUsuario(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al obtener usuario por ID " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }

        return usuario;
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        Connection conexion = BaseDeDatos.Conectar();
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al obtener todos los usuarios " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }

        return usuarios;
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("correo"),
                rs.getString("password"),
                rs.getDate("fecha_registro")
        );
    }
}

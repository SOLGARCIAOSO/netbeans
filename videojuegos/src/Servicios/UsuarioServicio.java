package Servicios;

import DB.BaseDeDatos;
import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

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
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String correo = rs.getString("correo");
                String password = rs.getString("password");
                Date fechaRegistro = rs.getDate("fecha_registro");
                
                System.out.println("Usuario ID: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Correo: " + correo);
                System.out.println("Contraseña: " + password);
                System.out.println("Fecha de Registro: " + fechaRegistro);
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar usuarios " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }
}

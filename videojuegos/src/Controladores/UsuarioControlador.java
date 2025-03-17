package Controladores;

import Modelos.Usuario;
import Servicios.UsuarioServicio;
import java.util.List;

public class UsuarioControlador {
    private UsuarioServicio service;

    public UsuarioControlador() {
        service = new UsuarioServicio();
    }

    public void agregarUsuario(Usuario usuario) {
        service.agregarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        service.eliminarUsuario(id);
    }

    public void editarUsuario(Usuario usuario) {
        service.editarUsuario(usuario);
    }

    public void mostrarUsuarios() {
        service.mostrarUsuarios();
    }

    public Usuario obtenerUsuarioPorId(int idUsuarioFactura) {
        List<Usuario> usuarios = service.obtenerTodosLosUsuarios(); // Usamos el método del servicio
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuarioFactura) {
                return usuario;
            }
        }
        return null; // Retorna null si no encuentra el usuario
    }
}

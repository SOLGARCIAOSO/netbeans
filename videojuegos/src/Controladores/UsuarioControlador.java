package Controladores;

import Modelos.Usuario;
import Servicios.UsuarioServicio;

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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
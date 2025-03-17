package Controladores;

import Modelos.Categoria;
import Servicios.CategoriaServicio;
import java.util.List;

public class CategoriaControlador {
    private final CategoriaServicio servicio;

    public CategoriaControlador() {
        this.servicio = new CategoriaServicio();
    }

    // Método para obtener la lista de categorías predefinidas
    public List<Categoria> obtenerCategorias() {
        return servicio.obtenerCategorias();
    }

    // Método para mostrar las categorías en la consola
    public void mostrarCategorias() {
        servicio.mostrarCategorias();
    }
}

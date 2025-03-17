package Controladores;

import Modelos.Juego;
import Servicios.JuegoServicio;
import java.util.List;

public class JuegoControlador {
    private final JuegoServicio servicio;

    public JuegoControlador() {
        this.servicio = new JuegoServicio();
    }

    // Método para agregar un nuevo juego
    public void agregarJuego(Juego juego) {
        servicio.agregarJuego(juego);
    }

    // Método para editar un juego existente
    public void editarJuego(Juego juego) {
        servicio.editarJuego(juego);
    }

    // Método para eliminar un juego por su ID
    public void eliminarJuego(int idJuego) {
        servicio.eliminarJuego(idJuego);
    }

    // Método para mostrar todos los juegos registrados en la consola
    public void mostrarJuegos() {
        servicio.mostrarJuegos();
    }

    // Método para obtener un juego por ID
    public Juego obtenerJuegoPorId(int idJuegoComprado) {
        List<Juego> juegos = servicio.obtenerTodosLosJuegos(); // Método en JuegoServicio
        for (Juego juego : juegos) {
            if (juego.getIdJuego() == idJuegoComprado) {
                return juego;
            }
        }
        return null; // Retorna null si no encuentra el juego
    }
}

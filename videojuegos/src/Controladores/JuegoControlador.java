package Controladores;

import Modelos.Juego;
import Servicios.JuegoServicio;

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
}

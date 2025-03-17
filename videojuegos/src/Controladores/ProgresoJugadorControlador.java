
package Controladores;

import Modelos.ProgresoJugador;
import Servicios.ProgresoJugadorServicio;

public class ProgresoJugadorControlador {
    private ProgresoJugadorServicio service;

    public ProgresoJugadorControlador() {
        service = new ProgresoJugadorServicio();
    }
    
    public void insertarProgreso(ProgresoJugador progreso) {
        boolean resp = service.insertarProgreso(progreso);
        if (resp) {
            System.out.println("¡Progreso registrado con éxito!");
        } else {
            System.out.println("No se pudo registrar el progreso (ID duplicado).");
        }
    }
    
    public void imprimirProgresos() {
        service.imprimirProgresos();
    }
    
    public void actualizarProgreso(int id, int horas, int logros, double porcentaje) {
        boolean resp = service.actualizarProgreso(id, horas, logros, porcentaje);
        if (resp) {
            System.out.println("¡Progreso actualizado con éxito!");
        } else {
            System.out.println("No se encontró progreso con ID: " + id);
        }
    }
    
    public void eliminarProgreso(int id) {
        boolean resp = service.eliminarProgreso(id);
        if (resp) {
            System.out.println("¡Progreso eliminado con éxito!");
        } else {
            System.out.println("No se encontró progreso con ID: " + id);
        }
    }
}

package Servicios;

import DB.BaseDeDatos;
import Modelos.ProgresoJugador;

public class ProgresoJugadorServicio {
    
    public boolean insertarProgreso(ProgresoJugador nuevo) {
        for (ProgresoJugador p : BaseDeDatos.listaProgresoJugadores) {
            if (p.getId() == nuevo.getId()) {
                return false;
            }
        }
        BaseDeDatos.listaProgresoJugadores.add(nuevo);
        return true;
    }
    
    public void imprimirProgresos() {
        System.out.println("\n===== PROGRESO DE JUGADORES =====");
        for (ProgresoJugador p : BaseDeDatos.listaProgresoJugadores) {
            System.out.println("ID: " + p.getId() +
                               " | Usuario: " + p.getUsuario().getNombre() +
                               " | Juego: " + p.getJuego().getNombre() +
                               " | Horas: " + p.getHorasJugadas() +
                               " | Logros: " + p.getLogrosDesbloqueados() +
                               " | Avance: " + p.getPorcentajeCompletado() + "%");
        }
        System.out.println("=================================\n");
    }
    
    public boolean actualizarProgreso(int id, int nuevasHoras, int nuevosLogros, double nuevoPorcentaje) {
        for (ProgresoJugador p : BaseDeDatos.listaProgresoJugadores) {
            if (p.getId() == id) {
                p.setHorasJugadas(nuevasHoras);
                p.setLogrosDesbloqueados(nuevosLogros);
                p.setPorcentajeCompletado(nuevoPorcentaje);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarProgreso(int id) {
        for (int i = 0; i < BaseDeDatos.listaProgresoJugadores.size(); i++) {
            if (BaseDeDatos.listaProgresoJugadores.get(i).getId() == id) {
                BaseDeDatos.listaProgresoJugadores.remove(i);
                return true;
            }
        }
        return false;
    }
}

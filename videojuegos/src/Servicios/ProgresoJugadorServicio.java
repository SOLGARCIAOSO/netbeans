package Servicios;

import DB.BaseDeDatos;
import Modelos.ProgresoJugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class ProgresoJugadorServicio {

    static {
        insertarProgresosSiNoExisten();
    }

    public ProgresoJugadorServicio() {
        // Constructor vacío
    }

    // Insertar un nuevo progreso de jugador
    public boolean insertarProgreso(ProgresoJugador nuevo) {
        for (ProgresoJugador p : BaseDeDatos.listaProgresoJugadores) {
            if (p.getId() == nuevo.getId()) {
                return false; // No se puede insertar un progreso con un ID ya existente
            }
        }
        BaseDeDatos.listaProgresoJugadores.add(nuevo);
        return true;
    }

    // Método para insertar progresos si no existen en la base de datos
    private static void insertarProgresosSiNoExisten() {
        Connection conexion = BaseDeDatos.Conectar();
        String consultaExistencia = "SELECT COUNT(*) FROM progreso_jugadores";
        String sqlInsertar = "INSERT INTO progreso_jugadores (id, id_usuario, id_juego, horas_jugadas, logros, avance) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement verificarStmt = conexion.prepareStatement(consultaExistencia);
             ResultSet resultado = verificarStmt.executeQuery()) {
            
            resultado.next();
            int cantidadRegistros = resultado.getInt(1);

            if (cantidadRegistros > 0) {
                System.out.println("✅ Los progresos de los jugadores ya están registrados.");
                return;
            }

            // Si no existen progresos, se insertan los predeterminados
            try (PreparedStatement insertarStmt = conexion.prepareStatement(sqlInsertar)) {
                for (ProgresoJugador progreso : BaseDeDatos.listaProgresoJugadores) {
                    insertarStmt.setInt(1, progreso.getId());
                    insertarStmt.setInt(2, progreso.getUsuario().getId()); // Asumimos que cada usuario tiene un ID único
                    insertarStmt.setInt(3, progreso.getJuego().getIdJuego()); // Asumimos que cada juego tiene un ID único
                    insertarStmt.setInt(4, progreso.getHorasJugadas());
                    insertarStmt.setInt(5, progreso.getLogrosDesbloqueados());
                    insertarStmt.setDouble(6, progreso.getPorcentajeCompletado());
                    insertarStmt.executeUpdate();
                }
                System.out.println("✅ Progresos de jugadores insertados correctamente en la base de datos.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar progresos de jugadores: " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    // Imprimir todos los progresos de jugadores
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

    // Actualizar el progreso de un jugador
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

    // Eliminar un progreso de jugador
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

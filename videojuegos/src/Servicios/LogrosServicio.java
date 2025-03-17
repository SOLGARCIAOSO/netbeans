package Servicios;

import DB.BaseDeDatos;
import Modelos.Logros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

public class LogrosServicio {
    
    static {
        insertarLogrosSiNoExisten();
    }

    public LogrosServicio() {
        // Constructor vacío
    }

    public List<Logros> obtenerLogros() {
        return Logros.LOGROS; // Suponiendo que tienes una lista estática en la clase Logro
    }

    public void mostrarLogros() {
        List<Logros> logros = obtenerLogros();
        if (logros.isEmpty()) {
            System.out.println("⚠ No hay logros disponibles.");
        } else {
            logros.forEach(logro -> {
                System.out.println("🏅 Logro ID: " + logro.getIdLogro());
                System.out.println("   Nombre: " + logro.getNombre());
                System.out.println("   Descripción: " + logro.getDescripcion());
                System.out.println("   Desbloqueado: " + (logro.isDesbloqueado() ? "Sí" : "No"));
                System.out.println("-------------------------------");
            });
        }
    }

    private static void insertarLogrosSiNoExisten() {
        Connection conexion = BaseDeDatos.Conectar();
        String consultaExistencia = "SELECT COUNT(*) FROM logros";
        String sqlInsertar = "INSERT INTO logros (idLogro, nombre, descripcion, desbloqueado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement verificarStmt = conexion.prepareStatement(consultaExistencia);
             ResultSet resultado = verificarStmt.executeQuery()) {
            
            resultado.next();
            int cantidadRegistros = resultado.getInt(1);

            if (cantidadRegistros > 0) {
                System.out.println("✅ Los logros ya están registrados.");
                return;
            }

            try (PreparedStatement insertarStmt = conexion.prepareStatement(sqlInsertar)) {
                for (Logros logro : Logros.LOGROS) {
                    insertarStmt.setInt(1, logro.getIdLogro());
                    insertarStmt.setString(2, logro.getNombre());
                    insertarStmt.setString(3, logro.getDescripcion());
                    insertarStmt.setBoolean(4, logro.isDesbloqueado()); // Asumiendo que por defecto no están desbloqueados
                    insertarStmt.executeUpdate();
                }
                System.out.println("✅ Logros insertados correctamente en la base de datos.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar logros: " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }
}

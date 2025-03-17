package Servicios;

import Modelos.Categoria;
import java.sql.*;

import java.util.List;

public class CategoriaServicio {
    private static final String URL = "jdbc:mysql://localhost:3306/videojuegos_db";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "";

    static {
        // Se ejecuta solo una vez antes de cualquier otra ejecución
        insertarCategoriasSiNoExisten();
    }

    public CategoriaServicio() {
        // Constructor vacío
    }

    // Obtiene la lista de categorías predefinidas
    public List<Categoria> obtenerCategorias() {
        return Categoria.CATEGORIAS_PREESTABLECIDAS;
    }

    // Muestra todas las categorías predefinidas en consola
    public void mostrarCategorias() {
        List<Categoria> categorias = obtenerCategorias();
        if (categorias.isEmpty()) {
            System.out.println("⚠ No hay categorías disponibles.");
        } else {
            categorias.forEach(categoria -> {
                System.out.println("🔹 Categoría ID: " + categoria.getIdCategoria());
                System.out.println("   Nombre: " + categoria.getNombre());
                System.out.println("   Descripción: " + categoria.getDescripcion());
                System.out.println("   Activo: " + (categoria.isActivo() ? "Sí" : "No"));
                System.out.println("-------------------------------");
            });
        }
    }

    // 🔹 Método estático que inserta las categorías solo si no existen
    private static void insertarCategoriasSiNoExisten() {
        String consultaExistencia = "SELECT COUNT(*) FROM categorias";
        String sqlInsertar = "INSERT INTO categorias (id, nombre, descripcion, estado) VALUES (?, ?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             PreparedStatement verificarStmt = conexion.prepareStatement(consultaExistencia);
             ResultSet resultado = verificarStmt.executeQuery()) {

            resultado.next();
            int cantidadRegistros = resultado.getInt(1);

            if (cantidadRegistros > 0) {
                System.out.println("✅ Las categorías ya están registradas.");
                return; // Salimos sin hacer nada
            }

            // Insertamos solo si la tabla está vacía
            try (PreparedStatement insertarStmt = conexion.prepareStatement(sqlInsertar)) {
                for (Categoria categoria : Categoria.CATEGORIAS_PREESTABLECIDAS) {
                    insertarStmt.setInt(1, categoria.getIdCategoria());
                    insertarStmt.setString(2, categoria.getNombre());
                    insertarStmt.setString(3, categoria.getDescripcion());
                    insertarStmt.setBoolean(4, categoria.isActivo());
                    insertarStmt.executeUpdate();
                }
                System.out.println("✅ Categorías insertadas correctamente en la base de datos.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar categorías: " + e.getMessage());
        }
    }
}

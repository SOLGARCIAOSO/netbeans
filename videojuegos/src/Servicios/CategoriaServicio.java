package Servicios;

import DB.BaseDeDatos;
import Modelos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.List;

public class CategoriaServicio {
    static {
        insertarCategoriasSiNoExisten();
    }

    public CategoriaServicio() {
        // Constructor vacío
    }

    public List<Categoria> obtenerCategorias() {
        return Categoria.CATEGORIAS_PREESTABLECIDAS;
    }

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

    private static void insertarCategoriasSiNoExisten() {
        Connection conexion = BaseDeDatos.Conectar();
        String consultaExistencia = "SELECT COUNT(*) FROM categorias";
        String sqlInsertar = "INSERT INTO categorias (idCategoria, nombreCategoria, descripcion, activo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement verificarStmt = conexion.prepareStatement(consultaExistencia);
             ResultSet resultado = verificarStmt.executeQuery()) {
            
            resultado.next();
            int cantidadRegistros = resultado.getInt(1);

            if (cantidadRegistros > 0) {
                System.out.println("✅ Las categorías ya están registradas.");
                return;
            }

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
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }
}

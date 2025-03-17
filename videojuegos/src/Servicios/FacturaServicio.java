package Servicios;

import DB.BaseDeDatos;
import Modelos.Factura;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FacturaServicio {

    public void agregarFactura(Factura factura) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "INSERT INTO facturas (numero_factura, usuario_id, fecha_emision, fecha_vencimiento, estado, total, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, factura.getNumeroFactura());
            stmt.setInt(2, factura.getUsuario().getId());
            stmt.setDate(3, new Date(factura.getFechaEmision().getTime()));
            stmt.setDate(4, new Date(factura.getFechaVencimiento().getTime()));
            stmt.setString(5, factura.getEstadoFactura());
            stmt.setDouble(6, factura.getTotal());
            stmt.setString(7, factura.getObservaciones());

            stmt.executeUpdate();
            System.out.println("La factura se registró correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al registrar la factura " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void eliminarFactura(int id) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "DELETE FROM facturas WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("La factura se eliminó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al eliminar la factura " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void editarFactura(Factura factura) {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "UPDATE facturas SET numero_factura = ?, usuario_id = ?, fecha_emision = ?, fecha_vencimiento = ?, estado = ?, total = ?, observaciones = ? WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, factura.getNumeroFactura());
            stmt.setInt(2, factura.getUsuario().getId());
            stmt.setDate(3, new Date(factura.getFechaEmision().getTime()));
            stmt.setDate(4, new Date(factura.getFechaVencimiento().getTime()));
            stmt.setString(5, factura.getEstadoFactura());
            stmt.setDouble(6, factura.getTotal());
            stmt.setString(7, factura.getObservaciones());
            stmt.setInt(8, factura.getId());

            stmt.executeUpdate();
            System.out.println("La factura se editó correctamente.");
        } catch (SQLException e) {
            System.out.println("ERROR: Al editar la factura " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }

    public void mostrarFacturas() {
        Connection conexion = BaseDeDatos.Conectar();
        String sql = "SELECT * FROM facturas";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String numeroFactura = rs.getString("numero_factura");
                int usuarioId = rs.getInt("usuario_id");
                Date fechaEmision = rs.getDate("fecha_emision");
                Date fechaVencimiento = rs.getDate("fecha_vencimiento");
                String estado = rs.getString("estado");
                double total = rs.getDouble("total");
                String observaciones = rs.getString("observaciones");

                System.out.println("Factura ID: " + id);
                System.out.println("Número: " + numeroFactura);
                System.out.println("Usuario ID: " + usuarioId);
                System.out.println("Fecha Emisión: " + fechaEmision);
                System.out.println("Fecha Vencimiento: " + fechaVencimiento);
                System.out.println("Estado: " + estado);
                System.out.println("Total: " + total);
                System.out.println("Observaciones: " + observaciones);
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            System.out.println("ERROR: Al consultar facturas " + e.getMessage());
        } finally {
            BaseDeDatos.DesconectarDB(conexion);
        }
    }
}

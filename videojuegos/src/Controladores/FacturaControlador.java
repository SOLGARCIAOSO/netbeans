package Controladores;

import Modelos.Factura;
import Servicios.FacturaServicio;
import java.util.List;

/**
 * Controlador para gestionar las facturas.
 */
public class FacturaControlador {
    private FacturaServicio service;

    public FacturaControlador() {
        service = new FacturaServicio();
    }

    public void agregarFactura(Factura factura) {
        service.agregarFactura(factura);
        System.out.println("¡Factura registrada con éxito!");
    }

    public void eliminarFactura(int id) {
        service.eliminarFactura(id);
        System.out.println("¡Factura eliminada con éxito!");
    }

    public void editarFactura(Factura factura) {
        service.editarFactura(factura);
        System.out.println("¡Factura editada con éxito!");
    }

    public void mostrarFacturas() {
        service.mostrarFacturas();
    }

    public Factura obtenerFacturaPorId(int idFacturaBuscar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void actualizarFactura(Factura facturaExistente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

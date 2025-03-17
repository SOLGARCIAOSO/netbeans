package Controladores;

import Modelos.PasarelaDePago;
import Modelos.PasarelaDePago.EstadoPago; 
import Servicios.PasarelaDePagoServicio;

public class PasarelaDePagoControlador {
    private PasarelaDePagoServicio service;

    public PasarelaDePagoControlador() {
        service = new PasarelaDePagoServicio();
    }
    
    public void insertarPago(PasarelaDePago pago) {
        boolean resp = service.insertarPago(pago);
        if (resp) {
            System.out.println("¡Pago registrado con éxito!");
        } else {
            System.out.println("No se pudo registrar el pago (ID duplicado).");
        }
    }
    
    public void imprimirPagos() {
        service.imprimirPagos();
    }
    
    public void actualizarPago(int id, EstadoPago nuevoEstado) {
        boolean resp = service.actualizarPago(id, nuevoEstado);
        if (resp) {
            System.out.println("¡Pago actualizado con éxito! Nuevo estado: " + nuevoEstado);
        } else {
            System.out.println("No se encontró pago con ID: " + id);
        }
    }
    
    public void eliminarPago(int id) {
        boolean resp = service.eliminarPago(id);
        if (resp) {
            System.out.println("¡Pago eliminado con éxito!");
        } else {
            System.out.println("No se encontró pago con ID: " + id);
        }
    }
}

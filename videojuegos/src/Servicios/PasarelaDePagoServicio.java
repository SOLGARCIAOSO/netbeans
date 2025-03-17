package Servicios;

import Modelos.PasarelaDePago;
import Modelos.Usuario;
import Modelos.Juego;
import DB.BaseDeDatos ;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasarelaDePagoServicio {
    
    public boolean insertarPago(PasarelaDePago nuevo) {
     
        for (PasarelaDePago p : BaseDeDatos.listaPasarelasPago) {
            if (p.getId() == nuevo.getId()) {
                return false; 
            }
        }
        
        BaseDeDatos.listaPasarelasPago.add(nuevo);
        return true;
    }

    public void imprimirPagos() {
        System.out.println("\n===== REGISTRO DE PAGOS =====");
        if (BaseDeDatos.listaPasarelasPago.isEmpty()) {
            System.out.println("No hay pagos registrados.");
        } else {
            for (PasarelaDePago p : BaseDeDatos.listaPasarelasPago) {
                System.out.println("ID: " + p.getId() +
                                   " | Comprador: " + p.getComprador().getNombre() +
                                   " | Juego: " + p.getJuegoComprado().getNombre() +
                                   " | Monto: $" + p.getMonto() +
                                   " | Método: " + p.getMetodoPago() +
                                   " | Fecha: " + p.getFechaCompra() +
                                   " | Estado: " + p.getEstadoPago());
            }
        }
        System.out.println("================================\n");
    }

    public boolean actualizarPago(int id, PasarelaDePago.EstadoPago nuevoEstado) {
        for (PasarelaDePago p : BaseDeDatos.listaPasarelasPago) {
            if (p.getId() == id) {
                p.setEstadoPago(nuevoEstado);
                return true; 
            }
        }
        return false; 
    }

    public boolean eliminarPago(int id) {
        return BaseDeDatos.listaPasarelasPago.removeIf(p -> p.getId() == id);
    }
}
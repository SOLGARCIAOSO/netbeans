package Modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Representa una factura generada tras una compra.
 * Incluye información del comprador, los juegos adquiridos, datos financieros y fechas relevantes.
 */
public class Factura {
    private int id;
    private String numeroFactura;       // Número de factura con formato específico
    private Usuario usuario;            // Comprador
    private List<Juego> juegos;         // Lista de juegos adquiridos
    private Date fechaEmision;          // Fecha de emisión de la factura
    private Date fechaVencimiento;      // Fecha límite de pago
    private double subtotal;            // Suma de los precios de los juegos
    private double impuestos;           // Impuestos aplicados (ej. 15% del subtotal)
    private double descuento;           // Descuento aplicado (ej. 10% del subtotal)
    private double total;               // Total a pagar: subtotal + impuestos - descuento
    private String observaciones;       // Notas o comentarios adicionales
    private String estadoFactura;       // Estado de la factura ("Pendiente", "Pagada", "Cancelada", etc.)

    public Factura(int par, Usuario usuarioFactura, Date date, double montoTotal) {
        this.fechaEmision = new Date();
        this.estadoFactura = "Pendiente";
    }

    public Factura(int id, double subtotal, String numeroFactura, Date fechaEmision) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.usuario = usuario;
        this.juegos = juegos;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.descuento = descuento;
        this.total = total;
        this.observaciones = observaciones;
        this.estadoFactura = estadoFactura;
    }

    // Getters y Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(String numeroFactura) { this.numeroFactura = numeroFactura; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public List<Juego> getJuegos() { return juegos; }
    public void setJuegos(List<Juego> juegos) { this.juegos = juegos; }
    public Date getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(Date fechaEmision) { this.fechaEmision = fechaEmision; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(Date fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getImpuestos() { return impuestos; }
    public void setImpuestos(double impuestos) { this.impuestos = impuestos; }
    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public String getEstadoFactura() { return estadoFactura; }
    public void setEstadoFactura(String estadoFactura) { this.estadoFactura = estadoFactura; }

    /**
     * Calcula el subtotal sumando el precio de cada juego.
     */
    public void calcularSubtotal() {
        double suma = 0.0;
        if (juegos != null) {
            for (Juego juego : juegos) {
                suma += juego.getPrecio();
            }
        }
        this.subtotal = suma;
    }

    /**
     * Calcula el total aplicando impuestos (15%) y descuento (10%) sobre el subtotal.
     */
    public void calcularTotal() {
        calcularSubtotal();
        this.impuestos = subtotal * 0.15;
        this.descuento = subtotal * 0.10;
        this.total = subtotal + impuestos - descuento;
    }

    /**
     * Imprime la factura de forma detallada.
     */
    public void imprimirFactura() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println("===== FACTURA =====");
        System.out.println("Factura ID: " + id);
        System.out.println("Número de Factura: " + numeroFactura);
        System.out.println("Fecha de Emisión: " + sdf.format(fechaEmision));
        if (fechaVencimiento != null) {
            System.out.println("Fecha de Vencimiento: " + sdf.format(fechaVencimiento));
        }
        System.out.println("Comprador: " + usuario.getNombre() + " (" + usuario.getCorreo() + ")");
        System.out.println("Juegos adquiridos:");
        if (juegos != null && !juegos.isEmpty()) {
            for (Juego juego : juegos) {
                System.out.println("  - " + juego.getNombre() + " | Precio: $" + juego.getPrecio());
            }
        } else {
            System.out.println("  No se han agregado juegos.");
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Impuestos (15%): $" + impuestos);
        System.out.println("Descuento (10%): $" + descuento);
        System.out.println("Total a pagar: $" + total);
        System.out.println("Observaciones: " + (observaciones != null ? observaciones : "Ninguna"));
        System.out.println("Estado de la Factura: " + estadoFactura);
        System.out.println("====================");
    }

    public void setMontoTotal(double nuevoMontoTotal) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setFecha(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}

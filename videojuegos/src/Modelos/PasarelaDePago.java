package Modelos;

import java.util.Date;

public class PasarelaDePago {
    public enum EstadoPago {
        PENDIENTE,
        PROCESANDO,
        EXITOSO,
        FALLIDO,
        REEMBOLSADO
    }

    private int id;
    private Usuario comprador; 
    private Juego juegoComprado; 
    private double monto; 
    private String metodoPago; 
    private Date fechaCompra; 
    private EstadoPago estadoPago; 

    
    public PasarelaDePago(int id, Usuario comprador, Juego juegoComprado, double monto, String metodoPago, Date fechaCompra, EstadoPago estadoPago) {
        this.id = id;
        this.comprador = comprador;
        this.juegoComprado = juegoComprado;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.fechaCompra = fechaCompra;
        this.estadoPago = estadoPago;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Usuario getComprador() { return comprador; }
    public void setComprador(Usuario comprador) { this.comprador = comprador; }
    public Juego getJuegoComprado() { return juegoComprado; }
    public void setJuegoComprado(Juego juegoComprado) { this.juegoComprado = juegoComprado; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public Date getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(Date fechaCompra) { this.fechaCompra = fechaCompra; }
    
    public EstadoPago getEstadoPago() { return estadoPago; }
    public void setEstadoPago(EstadoPago estadoPago) { this.estadoPago = estadoPago; }
}

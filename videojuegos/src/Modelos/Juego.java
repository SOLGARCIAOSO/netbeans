package Modelos;

import java.util.Date;

public class Juego {
    private int idJuego;
    private String nombre;
    private Categoria categoria;
    private Date fechaLanzamiento;
    private double precio;
    private String desarrollador;
    private String descripcion;
    private double rating;

    public Juego(int idJuego, String nombre, Categoria categoria, Date fechaLanzamiento, 
                 double precio, String desarrollador, String descripcion, double rating) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fechaLanzamiento = fechaLanzamiento;
        setPrecio(precio);
        setDesarrollador(desarrollador);
        this.descripcion = descripcion;
        setRating(rating);
    }

    public int getIdJuego() { return idJuego; }
    public void setIdJuego(int idJuego) { this.idJuego = idJuego; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public int getIdCategoria() {
        return (categoria != null) ? categoria.getIdCategoria() : 0; // Retorna 0 si la categoría es null
    }

    public Date getFechaLanzamiento() { return fechaLanzamiento; }
    public void setFechaLanzamiento(Date fechaLanzamiento) { this.fechaLanzamiento = fechaLanzamiento; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    public String getDesarrollador() { return desarrollador; }
    public void setDesarrollador(String desarrollador) {
        if (desarrollador == null || desarrollador.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del desarrollador no puede estar vacío.");
        }
        this.desarrollador = desarrollador;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getRating() { return rating; }
    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("El rating debe estar entre 0 y 10.");
        }
        this.rating = rating;
    }

}

package Modelos;

import java.util.Arrays;
import java.util.List;

public class Logros {

   
    private int idLogro;
    private String nombre;
    private String descripcion;
    private boolean desbloqueado;
    public static List<Logros> LOGROS;
    // Constructor
    public Logros(int idLogro, String nombre, String descripcion) {
        this.idLogro = idLogro;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desbloqueado = false;  // Inicialmente no está desbloqueado
    }

    // Getters y setters
    public int getIdLogro() { return idLogro; }
    public void setIdLogro(int idLogro) { this.idLogro = idLogro; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isDesbloqueado() { return desbloqueado; }
    public void setDesbloqueado(boolean desbloqueado) { this.desbloqueado = desbloqueado; }

   public class LogrosPreestablecidos {

        public static final List<Logros> LOGROS = Arrays.asList(
        new Logros(1, "Primeros Pasos", "Completa el tutorial o inicia el juego."),
        new Logros(2, "Avance en la Historia", "Completa el primer capítulo del juego."),
        new Logros(3, "Sin Ayuda", "Completa una misión sin utilizar ayudas o pistas."),
        new Logros(4, "Rendimiento Excepcional", "Obtén una calificación S en una misión."),
        new Logros(5, "Explorador Completo", "Explora todas las áreas del mapa del juego.")
    );
    }

    
    
}

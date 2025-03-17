package Modelos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private String descripcion;
    private boolean activo;
    private Date fechaCreacion;
    private Date fechaActualizacion;
    private List<Juego> juegos; // Lista de juegos asociados a la categoría

    // Lista de categorías preestablecidas
    public static final List<Categoria> CATEGORIAS_PREESTABLECIDAS = Arrays.asList(
        new Categoria(1, "Acción", "Juegos con combates dinámicos y mucha adrenalina", true),
        new Categoria(2, "Aventura", "Juegos con exploración, narrativa y resolución de acertijos", true),
        new Categoria(3, "Estrategia", "Juegos que requieren planificación y toma de decisiones", true),
        new Categoria(4, "RPG (Rol)", "Juegos donde el jugador progresa con experiencia y misiones", true),
        new Categoria(5, "Deportes", "Juegos basados en disciplinas deportivas", true),
        new Categoria(6, "Carreras", "Juegos de velocidad y competencia automovilística", true),
        new Categoria(7, "Shooters (FPS/TPS)", "Juegos de disparos en primera o tercera persona", true),
        new Categoria(8, "Survival Horror", "Juegos de terror y supervivencia con recursos limitados", true),
        new Categoria(9, "Plataformas", "Juegos de desplazamiento con saltos y obstáculos", true),
        new Categoria(10, "Mundo Abierto (Sandbox)", "Juegos con exploración y libertad total", true)
    );

    // Constructor
    public Categoria(int idCategoria, String nombreCategoria, String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
        this.fechaCreacion = new Date();
        this.fechaActualizacion = new Date();
        this.juegos = new ArrayList<>();
    }

    // Getters y Setters
    public int getIdCategoria() { return idCategoria; }
    public String getNombre() { return nombreCategoria; }
    public void setNombre(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }
    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public Date getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(Date fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }
    public List<Juego> getJuegos() { return juegos; }
    public void setJuegos(List<Juego> juegos) { this.juegos = juegos; }
}

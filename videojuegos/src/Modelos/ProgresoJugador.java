package Modelos;

public class ProgresoJugador {
    private int id;
    private Usuario usuario;  
    private Juego juego;      
    private int horasJugadas; 
    private int logrosDesbloqueados; 
    private double porcentajeCompletado; 

    
    public ProgresoJugador(int id, Usuario usuario, Juego juego, int horasJugadas, int logrosDesbloqueados, double porcentajeCompletado) {
        this.id = id;
        this.usuario = usuario;
        this.juego = juego;
        this.horasJugadas = horasJugadas;
        this.logrosDesbloqueados = logrosDesbloqueados;
        this.porcentajeCompletado = porcentajeCompletado;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Juego getJuego() { return juego; }
    public void setJuego(Juego juego) { this.juego = juego; }
    public int getHorasJugadas() { return horasJugadas; }
    public void setHorasJugadas(int horasJugadas) { this.horasJugadas = horasJugadas; }
    public int getLogrosDesbloqueados() { return logrosDesbloqueados; }
    public void setLogrosDesbloqueados(int logrosDesbloqueados) { this.logrosDesbloqueados = logrosDesbloqueados; }
    public double getPorcentajeCompletado() { return porcentajeCompletado; }
    public void setPorcentajeCompletado(double porcentajeCompletado) { this.porcentajeCompletado = porcentajeCompletado; }

    
    
}

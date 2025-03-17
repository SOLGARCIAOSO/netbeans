package Modelos;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private Date fechaRegistro;

    
    public Usuario() {}

    
    public Usuario(int id, String nombre, String correo, String password, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(Date fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    
}

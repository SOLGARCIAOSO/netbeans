package DB;

import Modelos.Juego;
import Modelos.Usuario;
import Modelos.ProgresoJugador;
import Modelos.PasarelaDePago;
import Modelos.Categoria;
import Modelos.Factura;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que simula una base de datos en memoria.
 * Contiene ArrayLists estáticos para compartir datos entre los servicios.
 */
public class BaseDeDatos {
    public static ArrayList<Juego> listaJuegos = new ArrayList<>();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<ProgresoJugador> listaProgresoJugadores = new ArrayList<>();
    public static ArrayList<PasarelaDePago> listaPasarelasPago = new ArrayList<>();
    public static ArrayList<Categoria> listaCategorias = new ArrayList<>();
    public static ArrayList<Factura> listaFacturas = new ArrayList<>();
    
   
    private static final String url = "jdbc:mysql://localhost:3306/videojuegos_db";
    private static final String usuario = "root";
    private static final String password = "";
    
    public static Connection Conectar() {
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa");
        } catch(ClassNotFoundException e) {
            System.out.println("ERROR: El driver mysql no se encontro");
            e.printStackTrace();
        } catch(SQLException e) {
            System.out.println("Error de conexión");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static void DesconectarDB(Connection conexion) {
        if(conexion != null) {
            try {
                conexion.close();
                System.out.println("La conexión se cerro con éxito");
            } catch(SQLException e) {
                System.out.println("ERROR: Mal cierre de conexión " + e.getMessage());
            }
        }
    }
}


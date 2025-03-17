package videojuegos;

import Controladores.*;
import Modelos.*;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JuegoControlador juegoControlador = new JuegoControlador();
        CategoriaControlador categoriaControlador = new CategoriaControlador();
        UsuarioControlador usuarioControlador = new UsuarioControlador();
        PasarelaDePagoControlador pagoControlador = new PasarelaDePagoControlador();

        categoriaControlador.mostrarCategorias();

        int opcion;
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Insertar juego");
            System.out.println("2. Actualizar juego");
            System.out.println("3. Eliminar juego");
            System.out.println("4. Listar juegos");
            System.out.println("5. Insertar usuario");
            System.out.println("6. Actualizar usuario");
            System.out.println("7. Eliminar usuario");
            System.out.println("8. Listar usuarios");
            System.out.println("9. Insertar pago");
            System.out.println("10. Listar pagos");
            System.out.println("11. Actualizar pago");
            System.out.println("12. Eliminar pago");
            System.out.println("13. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del juego: ");
                    int idJuego = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del juego: ");
                    String nombreJuego = sc.nextLine();

                    // Obtener lista de categorías disponibles
                    List<Categoria> categorias = categoriaControlador.obtenerCategorias();
                    if (categorias.isEmpty()) {
                        System.out.println("No hay categorías disponibles. No se puede insertar el juego.");
                        break;
                    }

                    // Mostrar categorías disponibles
                    System.out.println("Categorías disponibles:");
                    for (Categoria cat : categorias) {
                        System.out.println(cat.getIdCategoria() + ". " + cat.getNombre());
                    }

                    // Pedir ID de categoría
                    Categoria categoriaSeleccionada = null;
                    while (categoriaSeleccionada == null) {
                        System.out.print("Selecciona el ID de la categoría para el juego: ");
                        int idCategoria = sc.nextInt();
                        sc.nextLine();
                        
                        for (Categoria cat : categorias) {
                            if (cat.getIdCategoria() == idCategoria) {
                                categoriaSeleccionada = cat;
                                break;
                            }
                        }

                        if (categoriaSeleccionada == null) {
                            System.out.println("ID de categoría no válido. Intenta de nuevo.");
                        }
                    }

                    System.out.print("Precio: ");
                    double precioJuego = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Desarrollador: ");
                    String desarrollador = sc.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();
                    System.out.print("Calificación: ");
                    double calificacion = sc.nextDouble();
                    sc.nextLine();

                    Juego nuevoJuego = new Juego(idJuego, nombreJuego, categoriaSeleccionada, new Date(), precioJuego, desarrollador, descripcion, calificacion);
                    juegoControlador.agregarJuego(nuevoJuego);
                    break;

                case 2:
                    System.out.print("ID del juego a actualizar: ");
                    int idJuegoAct = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombreJuego = sc.nextLine();

                    // Obtener lista de categorías disponibles
                    categorias = categoriaControlador.obtenerCategorias();
                    if (categorias.isEmpty()) {
                        System.out.println("No hay categorías disponibles. No se puede actualizar el juego.");
                        break;
                    }

                    // Mostrar categorías disponibles
                    System.out.println("Categorías disponibles:");
                    for (Categoria cat : categorias) {
                        System.out.println(cat.getIdCategoria() + ". " + cat.getNombre());
                    }

                    // Pedir ID de categoría
                    categoriaSeleccionada = null;
                    while (categoriaSeleccionada == null) {
                        System.out.print("Selecciona el ID de la nueva categoría para el juego: ");
                        int idCategoria = sc.nextInt();
                        sc.nextLine();

                        for (Categoria cat : categorias) {
                            if (cat.getIdCategoria() == idCategoria) {
                                categoriaSeleccionada = cat;
                                break;
                            }
                        }

                        if (categoriaSeleccionada == null) {
                            System.out.println("ID de categoría no válido. Intenta de nuevo.");
                        }
                    }

                    Juego juegoActualizado = new Juego(idJuegoAct, nuevoNombreJuego, categoriaSeleccionada, new Date(), 0, "", "", 0);
                    juegoControlador.editarJuego(juegoActualizado);
                    break;

                case 3:
                    System.out.print("ID del juego a eliminar: ");
                    int idJuegoDel = sc.nextInt();
                    sc.nextLine();
                    juegoControlador.eliminarJuego(idJuegoDel);
                    break;

                case 4:
                    juegoControlador.mostrarJuegos();
                    break;

                case 5:
                    System.out.print("Nombre del usuario: ");
                    String nombreUsuario = sc.nextLine();
                    System.out.print("Correo: ");
                    String correo = sc.nextLine();
                    System.out.print("Contraseña: ");
                    String password = sc.nextLine();

                    Usuario nuevoUsuario = new Usuario(0, nombreUsuario, correo, password, new Date());
                    usuarioControlador.agregarUsuario(nuevoUsuario);
                    break;

                case 6:
                    System.out.print("ID del usuario a actualizar: ");
                    int idUsuario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.print("Nuevo correo: ");
                    String nuevoCorreo = sc.nextLine();

                    Usuario usuarioActualizado = new Usuario(idUsuario, nuevoNombre, nuevoCorreo, "", new Date());
                    usuarioControlador.editarUsuario(usuarioActualizado);
                    break;

                case 7:
                    System.out.print("ID del usuario a eliminar: ");
                    int idUsuarioDel = sc.nextInt();
                    sc.nextLine();
                    usuarioControlador.eliminarUsuario(idUsuarioDel);
                    break;

                case 8:
                    usuarioControlador.mostrarUsuarios();
                    break;
                case 9:
                    System.out.print("ID del pago: ");
                    int idPago = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("ID del usuario comprador: ");
                    int idUsuarioComprador = sc.nextInt();
                    sc.nextLine();
                    
                    Usuario comprador = usuarioControlador.obtenerUsuarioPorId(idUsuarioComprador);
                    if (comprador == null) {
                        System.out.println("Usuario no encontrado. No se puede procesar el pago.");
                        break;
                    }

                    System.out.print("ID del juego comprado: ");
                    int idJuegoComprado = sc.nextInt();
                    sc.nextLine();
                    
                    Juego juegoComprado = juegoControlador.obtenerJuegoPorId(idJuegoComprado);
                    if (juegoComprado == null) {
                        System.out.println("Juego no encontrado. No se puede procesar el pago.");
                        break;
                    }

                    System.out.print("Monto: ");
                    double monto = sc.nextDouble();
                    sc.nextLine();
                    
                    System.out.print("Método de pago: ");
                    String metodo = sc.nextLine();

                    PasarelaDePago nuevoPago = new PasarelaDePago(
                        idPago, 
                        comprador, 
                        juegoComprado, 
                        monto, 
                        metodo, 
                        new Date(), 
                        PasarelaDePago.EstadoPago.PENDIENTE
                    );
                    pagoControlador.insertarPago(nuevoPago);
                    break;
                case 10:
                    pagoControlador.imprimirPagos();
                    break;
                case 11:
                    System.out.print("ID del pago a actualizar: ");
                    int idPagoActualizar = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.println("Estados disponibles:");
                    for (PasarelaDePago.EstadoPago estado : PasarelaDePago.EstadoPago.values()) {
                        System.out.println(estado.ordinal() + ". " + estado);
                    }
                    
                    System.out.print("Selecciona el nuevo estado del pago: ");
                    int estadoIndex = sc.nextInt();
                    sc.nextLine();
                    
                    if (estadoIndex < 0 || estadoIndex >= PasarelaDePago.EstadoPago.values().length) {
                        System.out.println("Opción de estado no válida.");
                        break;
                    }
                    
                    PasarelaDePago.EstadoPago nuevoEstado = PasarelaDePago.EstadoPago.values()[estadoIndex];
                    pagoControlador.actualizarPago(idPagoActualizar, nuevoEstado);
                    break;
                case 12:
                    System.out.print("ID del pago a eliminar: ");
                    int idPagoEliminar = sc.nextInt();
                    sc.nextLine();
                    pagoControlador.eliminarPago(idPagoEliminar);
                    break;
                case 13:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 13);
        
        sc.close();
    }
}
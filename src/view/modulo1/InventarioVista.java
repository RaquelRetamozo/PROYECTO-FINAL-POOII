package view.modulo1;

import Model.entidades.Producto;

import java.util.List;
import java.util.Scanner;

public class InventarioVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE INVENTARIO ===");
        System.out.println("1. Registrar producto");
        System.out.println("2. Buscar producto");
        System.out.println("3. Listar productos");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosProducto() {
        System.out.print("ID Producto: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo (LIQUIDO/POLVO): ");
        String tipo = scanner.nextLine();
        System.out.print("Fecha fabricacion (YYYY-MM-DD): ");
        String fechaFab = scanner.nextLine();
        System.out.print("Fecha vencimiento (YYYY-MM-DD): ");
        String fechaVen = scanner.nextLine();
        System.out.print("Cantidad: ");
        String cantidad = scanner.nextLine();
        System.out.print("Dosis: ");
        String dosis = scanner.nextLine();
        System.out.print("Parametro extra (viscosidad/humedad): ");
        String param = scanner.nextLine();
        return new String[]{id, nombre, tipo, fechaFab, fechaVen, cantidad, dosis, param};
    }

    public String pedirIdProducto() {
        System.out.print("ID Producto: ");
        return scanner.nextLine();
    }

    public void mostrarProducto(Producto producto) {
        System.out.println("\n--- PRODUCTO ---");
        System.out.println("ID: " + producto.getIdProducto());
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Tipo: " + producto.getTipo());
        System.out.println("Cantidad: " + producto.getCantidad());
        System.out.println("Dosis: " + producto.getDosis());
        System.out.println("Fecha Fabricacion: " + producto.getFechaFabricacion());
        System.out.println("Fecha Vencimiento: " + producto.getFechaVencimiento());
        System.out.println("Vencido: " + (producto.estaVencido() ? "SI" : "NO"));
    }

    public void mostrarListaProductos(List<Producto> productos) {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        for (Producto p : productos) {
            System.out.println("ID: " + p.getIdProducto() +
                    " | Nombre: " + p.getNombre() +
                    " | Tipo: " + p.getTipo() +
                    " | Cant: " + p.getCantidad());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}

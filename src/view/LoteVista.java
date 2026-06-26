package view;

import Model.entidades.Lote;
import java.util.List;
import java.util.Scanner;

public class LoteVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public LoteVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE LOTES ===");
        System.out.println("1. Registrar lote");
        System.out.println("2. Buscar lote");
        System.out.println("3. Listar lotes");
        System.out.println("4. Listar lotes vencidos");
        System.out.println("5. Listar lotes activos");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] pedirDatosLote() {
        System.out.print("ID Lote: ");
        String id = scanner.nextLine();
        System.out.print("Numero de lote: ");
        String numero = scanner.nextLine();
        System.out.print("ID Producto: ");
        String idProducto = scanner.nextLine();
        System.out.print("Cantidad: ");
        String cantidad = scanner.nextLine();
        System.out.print("Ubicacion: ");
        String ubicacion = scanner.nextLine();
        return new String[]{id, numero, idProducto, cantidad, ubicacion};
    }

    public String pedirIdLote() {
        System.out.print("ID Lote: ");
        return scanner.nextLine();
    }

    public void mostrarLote(Lote lote) {
        System.out.println("\n--- LOTE ---");
        System.out.println("ID: " + lote.getIdLote());
        System.out.println("Numero: " + lote.getNumeroLote());
        System.out.println("Producto: " + lote.getProducto().getNombre());
        System.out.println("Cantidad: " + lote.getCantidad());
        System.out.println("Ubicacion: " + lote.getUbicacion());
        System.out.println("Estado: " + lote.getEstado());
        System.out.println("Fecha Ingreso: " + lote.getFechaIngreso());
    }

    public void mostrarListaLotes(List<Lote> lotes) {
        System.out.println("\n--- LISTA DE LOTES ---");
        if (lotes.isEmpty()) {
            System.out.println("No hay lotes registrados.");
            return;
        }
        for (Lote l : lotes) {
            System.out.println("ID: " + l.getIdLote() +
                    " | Numero: " + l.getNumeroLote() +
                    " | Producto: " + l.getProducto().getNombre() +
                    " | Estado: " + l.getEstado());
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
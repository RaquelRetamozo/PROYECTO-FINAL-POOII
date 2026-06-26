package view;

import Model.entidades.Stock;
import java.util.List;
import java.util.Scanner;

public class StockVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public StockVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE STOCK ===");
        System.out.println("1. Registrar stock");
        System.out.println("2. Buscar stock");
        System.out.println("3. Listar stocks");
        System.out.println("4. Reducir stock");
        System.out.println("5. Aumentar stock");
        System.out.println("6. Listar bajo stock");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String pedirIdStock() {
        System.out.print("ID Stock: ");
        return scanner.nextLine();
    }

    public int pedirCantidad() {
        System.out.print("Cantidad: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarStock(Stock stock) {
        System.out.println("\n--- STOCK ---");
        System.out.println("ID: " + stock.getIdStock());
        System.out.println("Lote: " + stock.getLote().getNumeroLote());
        System.out.println("Producto: " + stock.getLote().getProducto().getNombre());
        System.out.println("Disponible: " + stock.getCantidadDisponible());
        System.out.println("Minimo: " + stock.getCantidadMinima());
        System.out.println("Estado: " + (stock.hayDesabastecimiento() ? "BAJO STOCK" : "OK"));
    }

    public void mostrarListaStocks(List<Stock> stocks) {
        System.out.println("\n--- LISTA DE STOCKS ---");
        if (stocks.isEmpty()) {
            System.out.println("No hay stocks registrados.");
            return;
        }
        for (Stock s : stocks) {
            System.out.println("ID: " + s.getIdStock() +
                    " | Producto: " + s.getLote().getProducto().getNombre() +
                    " | Disponible: " + s.getCantidadDisponible() +
                    " | Estado: " + (s.hayDesabastecimiento() ? "⚠ BAJO" : "OK"));
        }
    }

    public void mostrarExito(String mensaje) {
        System.out.println("✓ " + mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}
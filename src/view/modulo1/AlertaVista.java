package view.modulo1;

import Model.entidades.Lote;
import Model.entidades.Stock;
import java.util.List;
import java.util.Scanner;

public class AlertaVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public AlertaVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== ALERTAS ===");
        System.out.println("1. Ver lotes proximos a vencer");
        System.out.println("2. Ver lotes vencidos");
        System.out.println("3. Ver stock critico");
        System.out.println("4. Ver alertas ambientales");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarLotesProximosAVencer(List<Lote> lotes) {
        System.out.println("\n--- LOTES PROXIMOS A VENCER ---");
        if (lotes.isEmpty()) {
            System.out.println("No hay lotes proximos a vencer.");
            return;
        }
        for (Lote l : lotes) {
            System.out.println("Lote: " + l.getNumeroLote() +
                    " | Producto: " + l.getProducto().getNombre() +
                    " | Vence: " + l.getProducto().getFechaVencimiento());
        }
    }

    public void mostrarLotesVencidos(List<Lote> lotes) {
        System.out.println("\n--- LOTES VENCIDOS ---");
        if (lotes.isEmpty()) {
            System.out.println("No hay lotes vencidos.");
            return;
        }
        for (Lote l : lotes) {
            System.out.println("Lote: " + l.getNumeroLote() +
                    " | Producto: " + l.getProducto().getNombre() +
                    " | Vencio: " + l.getProducto().getFechaVencimiento());
        }
    }

    public void mostrarStockCritico(List<Stock> stocks) {
        System.out.println("\n--- STOCK CRITICO ---");
        if (stocks.isEmpty()) {
            System.out.println("No hay stock critico.");
            return;
        }
        for (Stock s : stocks) {
            System.out.println("Producto: " + s.getLote().getProducto().getNombre() +
                    " | Disponible: " + s.getCantidadDisponible() +
                    " | Minimo: " + s.getCantidadMinima());
        }
    }

    public void mostrarAlertasAmbientales(List<String> alertas) {
        System.out.println("\n--- ALERTAS AMBIENTALES ---");
        if (alertas.isEmpty()) {
            System.out.println("No hay alertas ambientales.");
            return;
        }
        for (String alerta : alertas) {
            System.out.println(alerta);
        }
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}

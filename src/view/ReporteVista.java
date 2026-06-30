package view;

// Corregido: Por convención de Java, los paquetes deben ir en minúsculas (model en lugar de Model)
import model.entidades.ReporteCalidad;
import model.entidades.ReporteDespachos;
import model.entidades.ReporteInventario;
import java.util.Scanner;

public class ReporteVista {

    // Atributos
    private final Scanner scanner; // 'final' porque no cambiará su referencia

    // Constructor
    public ReporteVista() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos
    public int mostrarMenu() {
        while (true) {
            try {
                System.out.println("\n=== REPORTES ===");
                System.out.println("1. Reporte de inventario");
                System.out.println("2. Reporte de despachos");
                System.out.println("3. Reporte de calidad");
                System.out.println("0. Volver");
                System.out.print("Seleccione: ");

                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                mostrarError("Opción no válida. Por favor, ingrese un número.");
            }
        }
    }

    public void mostrarReporteInventario(ReporteInventario reporte) {
        if (reporte == null) {
            mostrarError("El reporte de inventario está vacío.");
            return;
        }
        System.out.println("\n=== REPORTE DE INVENTARIO ===");
        imprimirDatosBase(reporte.getTitulo(), reporte.getGeneradoPor(), reporte.getFechaGeneracion());
        System.out.println("Total productos: " + reporte.getTotalProductos());
        System.out.println("Lotes vencidos: " + reporte.getTotalLotesVencidos());
        System.out.println("Bajo stock:     " + reporte.getTotalBajoStock());
    }

    public void mostrarReporteDespachos(ReporteDespachos reporte) {
        if (reporte == null) {
            mostrarError("El reporte de despachos está vacío.");
            return;
        }
        System.out.println("\n=== REPORTE DE DESPACHOS ===");
        imprimirDatosBase(reporte.getTitulo(), reporte.getGeneradoPor(), reporte.getFechaGeneracion());
        System.out.println("Total despachos: " + reporte.getTotalDespachos());
        System.out.println("Entregados:      " + reporte.getTotalEntregados());
        System.out.println("Pendientes:      " + reporte.getTotalPendientes());
        System.out.println("Cancelados:      " + reporte.getTotalCancelados());
        System.out.printf("Monto total:     S/. %.2f%n", reporte.getMontoTotal()); // Formato de moneda ordenado
    }

    public void mostrarReporteCalidad(ReporteCalidad reporte) {
        if (reporte == null) {
            mostrarError("El reporte de calidad está vacío.");
            return;
        }
        System.out.println("\n=== REPORTE DE CALIDAD ===");
        imprimirDatosBase(reporte.getTitulo(), reporte.getGeneradoPor(), reporte.getFechaGeneracion());
        System.out.println("No conformidades: " + reporte.getTotalNoConformidades());
        System.out.println("Críticas:         " + reporte.getTotalCriticos());
        System.out.println("Reclamos:         " + reporte.getTotalReclamos());
    }

    public void mostrarError(String mensaje) {
        System.err.println("✗ Error: " + mensaje); // Usa System.err para que salga en rojo en IntelliJ
    }

    // Método auxiliar para evitar repetir código en las cabeceras de los reportes
    private void imprimirDatosBase(String titulo, String generadoPor, String fecha) {
        System.out.println("Título:       " + titulo);
        System.out.println("Generado por: " + generadoPor);
        System.out.println("Fecha:        " + fecha);
        System.out.println("---------------------------------");
    }
}

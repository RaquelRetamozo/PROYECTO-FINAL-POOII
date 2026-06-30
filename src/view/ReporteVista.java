package view;

import Model.entidades.ReporteCalidad;
import Model.entidades.ReporteDespachos;
import Model.entidades.ReporteInventario;
import java.util.Scanner;

public class ReporteVista {

    //Atributos
    private Scanner scanner;

    //Constructor
    public ReporteVista() {
        this.scanner = new Scanner(System.in);
    }

    //Métodos
    public int mostrarMenu() {
        System.out.println("\n=== REPORTES ===");
        System.out.println("1. Reporte de inventario");
        System.out.println("2. Reporte de despachos");
        System.out.println("3. Reporte de calidad");
        System.out.println("0. Volver");
        System.out.print("Seleccione: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarReporteInventario(ReporteInventario reporte) {
        System.out.println("\n=== REPORTE DE INVENTARIO ===");
        System.out.println("Titulo: " + reporte.getTitulo());
        System.out.println("Generado por: " + reporte.getGeneradoPor());
        System.out.println("Fecha: " + reporte.getFechaGeneracion());
        System.out.println("Total productos: " + reporte.getTotalProductos());
        System.out.println("Lotes vencidos: " + reporte.getTotalLotesVencidos());
        System.out.println("Bajo stock: " + reporte.getTotalBajoStock());
    }

    public void mostrarReporteDespachos(ReporteDespachos reporte) {
        System.out.println("\n=== REPORTE DE DESPACHOS ===");
        System.out.println("Titulo: " + reporte.getTitulo());
        System.out.println("Generado por: " + reporte.getGeneradoPor());
        System.out.println("Fecha: " + reporte.getFechaGeneracion());
        System.out.println("Total despachos: " + reporte.getTotalDespachos());
        System.out.println("Entregados: " + reporte.getTotalEntregados());
        System.out.println("Pendientes: " + reporte.getTotalPendientes());
        System.out.println("Cancelados: " + reporte.getTotalCancelados());
        System.out.println("Monto total: S/." + reporte.getMontoTotal());
    }

    public void mostrarReporteCalidad(ReporteCalidad reporte) {
        System.out.println("\n=== REPORTE DE CALIDAD ===");
        System.out.println("Titulo: " + reporte.getTitulo());
        System.out.println("Generado por: " + reporte.getGeneradoPor());
        System.out.println("Fecha: " + reporte.getFechaGeneracion());
        System.out.println("No conformidades: " + reporte.getTotalNoConformidades());
        System.out.println("Criticas: " + reporte.getTotalCriticos());
        System.out.println("Reclamos: " + reporte.getTotalReclamos());
    }

    public void mostrarError(String mensaje) {
        System.out.println("✗ Error: " + mensaje);
    }
}

package controller;

// Corregido: Paquetes en minúsculas por convención de Java (model en lugar de Model)
import model.entidades.ReporteCalidad;
import model.entidades.ReporteDespachos;
import model.entidades.ReporteInventario;
import model.servicios.ReporteService;

public class ReporteController {

    // Atributos
    private final ReporteService reporteService; // 'final' porque la referencia al servicio no debería cambiar

    // Constructor
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    // Métodos
    public ReporteInventario generarReporteInventario(String generadoPor) {
        // Validación básica antes de procesar
        if (generadoPor == null || generadoPor.trim().isEmpty()) {
            return null;
        }
        return reporteService.generarReporteInventario(generadoPor);
    }

    public ReporteDespachos generarReporteDespachos(String generadoPor) {
        if (generadoPor == null || generadoPor.trim().isEmpty()) {
            return null;
        }
        return reporteService.generarReporteDespachos(generadoPor);
    }

    public ReporteCalidad generarReporteCalidad(String generadoPor) {
        if (generadoPor == null || generadoPor.trim().isEmpty()) {
            return null;
        }
        return reporteService.generarReporteCalidad(generadoPor);
    }
}
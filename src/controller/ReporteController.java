package controller;

import Model.entidades.ReporteCalidad;
import Model.entidades.ReporteDespachos;
import Model.entidades.ReporteInventario;
import Model.servicios.ReporteService;

public class ReporteController {

    //Atributos
    private ReporteService reporteService;

    //Constructor
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    //Métodos
    public ReporteInventario generarReporteInventario(String generadoPor) {
        ReporteInventario reporte = reporteService.generarReporteInventario(generadoPor);
        System.out.println("Reporte de inventario generado correctamente.");
        return reporte;
    }

    public ReporteDespachos generarReporteDespachos(String generadoPor) {
        ReporteDespachos reporte = reporteService.generarReporteDespachos(generadoPor);
        System.out.println("Reporte de despachos generado correctamente.");
        return reporte;
    }

    public ReporteCalidad generarReporteCalidad(String generadoPor) {
        ReporteCalidad reporte = reporteService.generarReporteCalidad(generadoPor);
        System.out.println("Reporte de calidad generado correctamente.");
        return reporte;
    }
}

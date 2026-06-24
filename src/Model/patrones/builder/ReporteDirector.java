package Model.patrones.builder;

import Model.entidades.Reporte;

public class ReporteDirector {

    //Atributos
    private ReporteBuilder builder;

    //Constructor
    public ReporteDirector(ReporteBuilder builder) {
        this.builder = builder;
    }

    //Métodos
    public Reporte construirReporteInventario(String generadoPor) {
        return builder
                .idReporte("RI-" + System.currentTimeMillis())
                .titulo("Reporte de Inventario")
                .descripcion("Reporte generado automáticamente")
                .generadoPor(generadoPor)
                .tipo("INVENTARIO")
                .build();
    }

    public Reporte construirReporteTrazabilidad(String generadoPor) {
        return builder
                .idReporte("RT-" + System.currentTimeMillis())
                .titulo("Reporte de Trazabilidad")
                .descripcion("Reporte generado automáticamente")
                .generadoPor(generadoPor)
                .tipo("TRAZABILIDAD")
                .build();
    }

    public Reporte construirReporteCalidad(String generadoPor) {
        return builder
                .idReporte("RC-" + System.currentTimeMillis())
                .titulo("Reporte de Calidad")
                .descripcion("Reporte generado automáticamente")
                .generadoPor(generadoPor)
                .tipo("CALIDAD")
                .build();
    }

    public Reporte construirReporteDespachos(String generadoPor) {
        return builder
                .idReporte("RD-" + System.currentTimeMillis())
                .titulo("Reporte de Despachos")
                .descripcion("Reporte generado automáticamente")
                .generadoPor(generadoPor)
                .tipo("DESPACHOS")
                .build();
    }
}
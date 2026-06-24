package Model.patrones.factory;

import Model.entidades.ReporteInventario;

public class ReporteInventarioFactory {

    //Métodos
    public static ReporteInventario crear(String generadoPor) {
        return new ReporteInventario(
                "RI-" + System.currentTimeMillis(),
                "Reporte de Inventario",
                "Reporte generado automáticamente",
                generadoPor
        );
    }
}
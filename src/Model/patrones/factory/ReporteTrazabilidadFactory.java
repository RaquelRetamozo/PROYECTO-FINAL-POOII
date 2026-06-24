package Model.patrones.factory;

import Model.entidades.ReporteTrazabilidad;

public class ReporteTrazabilidadFactory {

    //Métodos
    public static ReporteTrazabilidad crear(String generadoPor) {
        return new ReporteTrazabilidad(
                "RT-" + System.currentTimeMillis(),
                "Reporte de Trazabilidad",
                "Reporte generado automáticamente",
                generadoPor
        );
    }
}
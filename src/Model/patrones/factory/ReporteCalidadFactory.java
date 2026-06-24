package Model.patrones.factory;

import Model.entidades.ReporteCalidad;

public class ReporteCalidadFactory {

    //Métodos
    public static ReporteCalidad crear(String generadoPor) {
        return new ReporteCalidad(
                "RC-" + System.currentTimeMillis(),
                "Reporte de Calidad",
                "Reporte generado automáticamente",
                generadoPor
        );
    }
}
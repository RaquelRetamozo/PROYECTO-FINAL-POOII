package Model.patrones.factory;

import Model.entidades.Reporte;
import Model.entidades.ReporteCalidad;
import Model.entidades.ReporteDespachos;
import Model.entidades.ReporteInventario;
import Model.entidades.ReporteTrazabilidad;

public class ReporteFactory {

    //Métodos
    public static Reporte crear(String tipo, String idReporte,
                                String titulo, String generadoPor) {
        switch (tipo.toUpperCase()) {
            case "INVENTARIO":
                return new ReporteInventario(idReporte, titulo, "", generadoPor);
            case "TRAZABILIDAD":
                return new ReporteTrazabilidad(idReporte, titulo, "", generadoPor);
            case "CALIDAD":
                return new ReporteCalidad(idReporte, titulo, "", generadoPor);
            case "DESPACHOS":
                return new ReporteDespachos(idReporte, titulo, "", generadoPor);
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido: " + tipo);
        }
    }
}
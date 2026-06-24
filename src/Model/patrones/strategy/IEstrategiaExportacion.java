package Model.patrones.strategy;

import Model.entidades.Reporte;

public interface IEstrategiaExportacion {
    void exportar(Reporte reporte);
}
package Model.patrones.strategy;

import Model.entidades.Reporte;

public class ExportacionExcel implements IEstrategiaExportacion {

    //Métodos
    @Override
    public void exportar(Reporte reporte) {
        System.out.println("=== EXPORTANDO A EXCEL ===");
        System.out.println("Reporte: " + reporte.getTitulo());
        System.out.println("Tipo: " + reporte.getTipoReporte());
        System.out.println("Generado por: " + reporte.getGeneradoPor());
        System.out.println("Fecha: " + reporte.getFechaGeneracion());
        System.out.println("Archivo generado: " + reporte.getTitulo() + ".xlsx");
        System.out.println("=========================");
    }
}
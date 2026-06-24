package Model.patrones.strategy;

import Model.entidades.Reporte;

public class ExportacionPDF implements IEstrategiaExportacion {

    //Métodos
    @Override
    public void exportar(Reporte reporte) {
        System.out.println("=== EXPORTANDO A PDF ===");
        System.out.println("Reporte: " + reporte.getTitulo());
        System.out.println("Tipo: " + reporte.getTipoReporte());
        System.out.println("Generado por: " + reporte.getGeneradoPor());
        System.out.println("Fecha: " + reporte.getFechaGeneracion());
        System.out.println("Archivo generado: " + reporte.getTitulo() + ".pdf");
        System.out.println("=======================");
    }
}